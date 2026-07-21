package br.com.elias.pokedex;

import br.com.elias.pokedex.database.Conexao;
import br.com.elias.pokedex.model.Pokemon;

import br.com.elias.pokedex.service.PokemonService;
import io.javalin.Javalin;

public class Main {

	public static void main(String[] args) {

		Javalin app = Javalin.create(config -> {

		    config.bundledPlugins.enableCors(cors -> {

		        cors.addRule(rule -> {

		            rule.anyHost();

		        });

		    });

		});
		PokemonService service = new PokemonService();

		app.get("/", ctx -> ctx.result("Bem-vindo à Pokédex API!"));

		app.get("/pokemon", ctx -> {
			ctx.json(service.listarTodos());
		});

		app.get("/pokemon/{nome}", ctx -> {

			String nome = ctx.pathParam("nome");

			Pokemon pokemon = service.buscarPokemon(nome);

			ctx.json(pokemon);

		});
		app.delete("/pokemon/{id}", ctx -> {

			int id = Integer.parseInt(ctx.pathParam("id"));

			boolean removido = service.excluirPokemon(id);

			if (removido) {

				ctx.result("Pokémon removido com sucesso!");

			} else {

				ctx.status(404);
				ctx.result("Pokémon não encontrado.");

			}

		});
		app.put("/pokemon/{id}", ctx -> {

		    int id = Integer.parseInt(ctx.pathParam("id"));

		    Pokemon pokemon = ctx.bodyAsClass(Pokemon.class);

		    pokemon.setId(id);

		    boolean atualizado = service.atualizarPokemon(pokemon);

		    if (atualizado) {

		        ctx.result("Pokémon atualizado com sucesso!");

		    } else {

		        ctx.status(404);
		        ctx.result("Pokémon não encontrado.");

		    }

		});
		app.start(7000);

		System.out.println("Servidor iniciado!");
	}
}