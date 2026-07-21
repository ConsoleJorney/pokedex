package br.com.elias.pokedex.dao;

import br.com.elias.pokedex.database.Conexao;
import br.com.elias.pokedex.model.Pokemon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PokemonDAO {

	public void salvar(Pokemon pokemon) {

		String sql = """
								INSERT INTO pokemon
								(numero_pokedex, nome, tipo, altura, peso, descricao, imagem,
				 hp, ataque, defesa, ataque_especial, defesa_especial, velocidade, habilidades)
				VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
								""";

		try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

			stmt.setInt(1, pokemon.getNumeroPokedex());
			stmt.setString(2, pokemon.getNome());
			stmt.setString(3, pokemon.getTipo());
			stmt.setDouble(4, pokemon.getAltura());
			stmt.setDouble(5, pokemon.getPeso());
			stmt.setString(6, pokemon.getDescricao());
			stmt.setString(7, pokemon.getImagem());
			stmt.setInt(8, pokemon.getHp());
			stmt.setInt(9, pokemon.getAtaque());
			stmt.setInt(10, pokemon.getDefesa());
			stmt.setInt(11, pokemon.getAtaqueEspecial());
			stmt.setInt(12, pokemon.getDefesaEspecial());
			stmt.setInt(13, pokemon.getVelocidade());
			stmt.setString(14, pokemon.getHabilidades());
			stmt.executeUpdate();

			System.out.println("Pokémon salvo com sucesso!");

		} catch (SQLException e) {

			throw new RuntimeException("Erro ao salvar Pokémon.", e);

		}
	}

	public Pokemon buscarPorNumero(int numeroPokedex) {

		String sql = """
				SELECT *
				FROM pokemon
				WHERE numero_pokedex = ?
				""";

		try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

			stmt.setInt(1, numeroPokedex);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return montarPokemon(rs);
			}

		} catch (SQLException e) {

			throw new RuntimeException("Erro ao buscar Pokémon.", e);

		}

		return null;
	}

	public Pokemon buscarPorNome(String nome) {

		String sql = """
				SELECT *
				FROM pokemon
				WHERE nome = ?
				""";

		try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

			stmt.setString(1, nome);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return montarPokemon(rs);
			}

		} catch (SQLException e) {

			throw new RuntimeException("Erro ao buscar Pokémon.", e);

		}

		return null;
	}

	public List<Pokemon> listarTodos() {

		List<Pokemon> pokemons = new ArrayList<>();

		String sql = """
				SELECT *
				FROM pokemon
				ORDER BY numero_pokedex
				""";

		try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				pokemons.add(montarPokemon(rs));
			}

		} catch (SQLException e) {

			throw new RuntimeException("Erro ao listar Pokémon.", e);

		}

		return pokemons;
	}

	private Pokemon montarPokemon(ResultSet rs) throws SQLException {

		Pokemon pokemon = new Pokemon();

		pokemon.setId(rs.getInt("id"));
		pokemon.setNumeroPokedex(rs.getInt("numero_pokedex"));
		pokemon.setNome(rs.getString("nome"));
		pokemon.setTipo(rs.getString("tipo"));
		pokemon.setAltura(rs.getDouble("altura"));
		pokemon.setPeso(rs.getDouble("peso"));
		pokemon.setDescricao(rs.getString("descricao"));
		pokemon.setImagem(rs.getString("imagem"));
		pokemon.setHp(rs.getInt("hp"));
		pokemon.setAtaque(rs.getInt("ataque"));
		pokemon.setDefesa(rs.getInt("defesa"));
		pokemon.setAtaqueEspecial(rs.getInt("ataque_especial"));
		pokemon.setDefesaEspecial(rs.getInt("defesa_especial"));
		pokemon.setVelocidade(rs.getInt("velocidade"));
		pokemon.setHabilidades(rs.getString("habilidades"));
		return pokemon;
	}

	public boolean excluir(int id) {

		String sql = """
				DELETE FROM pokemon
				WHERE id = ?
				""";

		try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

			stmt.setInt(1, id);

			int linhasAfetadas = stmt.executeUpdate();

			return linhasAfetadas > 0;

		} catch (SQLException e) {

			throw new RuntimeException("Erro ao excluir Pokémon.", e);

		}

	}

	public boolean atualizar(Pokemon pokemon) {

		String sql = """
				UPDATE pokemon
				SET
				    nome = ?,
				    tipo = ?,
				    altura = ?,
				    peso = ?,
				    descricao = ?,
				    imagem = ?,
				      hp = ?,
				     ataque = ?,
				      defesa = ?,
				     ataque_especial = ?,
				     defesa_especial = ?,
				     velocidade = ?,
				    habilidades = ?
				WHERE id = ?
				""";

		try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

			stmt.setString(1, pokemon.getNome());
			stmt.setString(2, pokemon.getTipo());
			stmt.setDouble(3, pokemon.getAltura());
			stmt.setDouble(4, pokemon.getPeso());
			stmt.setString(5, pokemon.getDescricao());
			stmt.setString(6, pokemon.getImagem());
			stmt.setInt(7, pokemon.getHp());
			stmt.setInt(8, pokemon.getAtaque());
			stmt.setInt(9, pokemon.getDefesa());
			stmt.setInt(10, pokemon.getAtaqueEspecial());
			stmt.setInt(11, pokemon.getDefesaEspecial());
			stmt.setInt(12, pokemon.getVelocidade());
			stmt.setString(13, pokemon.getHabilidades());
			stmt.setInt(14, pokemon.getId());

			int linhasAfetadas = stmt.executeUpdate();

			return linhasAfetadas > 0;

		} catch (SQLException e) {

			throw new RuntimeException("Erro ao atualizar Pokémon.", e);

		}
	}
}