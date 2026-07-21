package br.com.elias.pokedex.service;

import br.com.elias.pokedex.dao.PokemonDAO;
import br.com.elias.pokedex.dto.*;
import br.com.elias.pokedex.model.Pokemon;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class PokemonService {

	private static final String URL = "https://pokeapi.co/api/v2/pokemon/";
	private static final String URL_SPECIES = "https://pokeapi.co/api/v2/pokemon-species/";

	private final HttpClient client = HttpClient.newHttpClient();
	private final ObjectMapper mapper = new ObjectMapper();
	private final PokemonDAO dao = new PokemonDAO();
	private final TradutorService tradutor = new TradutorService();

	public Pokemon buscarPokemon(String nome) {

		// Guarda o nome original
		String nomeOriginal = nome.toLowerCase().trim();


		// Busca pelo nome original no banco
		Pokemon pokemonBanco = dao.buscarPorNome(nomeOriginal);

		if (pokemonBanco != null) {
			System.out.println("Pokémon encontrado no banco!");
			return pokemonBanco;
		}

		try {

			// Busca Pokémon
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL + nome)).GET().build();

			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			PokemonDTO dto = mapper.readValue(response.body(), PokemonDTO.class);

			// Busca Species
			HttpRequest speciesRequest = HttpRequest.newBuilder().uri(URI.create(URL_SPECIES + nome)).GET().build();

			HttpResponse<String> speciesResponse = client.send(speciesRequest, HttpResponse.BodyHandlers.ofString());

			PokemonSpeciesDTO speciesDTO = mapper.readValue(speciesResponse.body(), PokemonSpeciesDTO.class);

			Pokemon pokemon = new Pokemon();

			pokemon.setId(dto.getId());
			pokemon.setNumeroPokedex(dto.getId());

			// Nome - usa o nome original para salvar
			pokemon.setNome(nomeOriginal);

			// Altura
			pokemon.setAltura(dto.getHeight());

			pokemon.setPeso(dto.getWeight());

			if (dto.getSprites() != null) {

				pokemon.setImagem(dto.getSprites().getFrontDefault());

			}

			if (dto.getTypes() != null && !dto.getTypes().isEmpty()) {

				String tipo = dto.getTypes().get(0).getType().getName();

				
			}

			String descricao = "";

			if (speciesDTO.getFlavorTextEntries() != null) {

				for (FlavorTextDTO flavor : speciesDTO.getFlavorTextEntries()) {

					if ("en".equals(flavor.getLanguage().getName())) {

						descricao = flavor.getFlavorText().replace("\n", " ").replace("\f", " ");

						break;

					}

				}

			}

			pokemon.setDescricao(tradutor.traduzir(descricao));

			if (dto.getStats() != null) {

				for (PokemonStatsDTO stat : dto.getStats()) {

					if (stat.getStat() == null)
						continue;

					switch (stat.getStat().getName()) {

					case "hp":
						pokemon.setHp(stat.getBase_stat());
						break;

					case "attack":
						pokemon.setAtaque(stat.getBase_stat());
						break;

					case "defense":
						pokemon.setDefesa(stat.getBase_stat());
						break;

					case "special-attack":
						pokemon.setAtaqueEspecial(stat.getBase_stat());
						break;

					case "special-defense":
						pokemon.setDefesaEspecial(stat.getBase_stat());
						break;

					case "speed":
						pokemon.setVelocidade(stat.getBase_stat());
						break;

					}

				}

			}

			if (dto.getAbilities() != null && !dto.getAbilities().isEmpty()
					&& dto.getAbilities().get(0).getAbility() != null) {

				pokemon.setHabilidades(tradutor.traduzir(dto.getAbilities().get(0).getAbility().getName()));

			}

			if (speciesDTO.getVarieties() != null) {

				System.out.println("\n===== FORMAS ENCONTRADAS =====");

				for (VarietyDTO variedade : speciesDTO.getVarieties()) {

					System.out.println(variedade.getPokemon().getName());

				}

				System.out.println("==============================\n");

			}

			dao.salvar(pokemon);

			return pokemon;

		} catch (Exception e) {

			throw new RuntimeException("Erro ao buscar Pokémon", e);

		}

	}

	public List<Pokemon> listarTodos() {
		return dao.listarTodos();
	}

	public boolean excluirPokemon(int id) {
		return dao.excluir(id);
	}

	public boolean atualizarPokemon(Pokemon pokemon) {
		return dao.atualizar(pokemon);
	}

}