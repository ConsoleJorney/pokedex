package br.com.elias.pokedex.service;

import java.util.HashMap;
import java.util.Map;

public class TradutorPokemon {

    private static final Map<String, String> TIPOS = new HashMap<>();
    private static final Map<String, String> STATUS = new HashMap<>();
    private static final Map<String, String> GERACOES = new HashMap<>();
    private static final Map<String, String> FORMAS = new HashMap<>();

    static {

        // TIPOS
        TIPOS.put("normal", "Normal");
        TIPOS.put("fire", "Fogo");
        TIPOS.put("water", "Água");
        TIPOS.put("electric", "Elétrico");
        TIPOS.put("grass", "Grama");
        TIPOS.put("ice", "Gelo");
        TIPOS.put("fighting", "Lutador");
        TIPOS.put("poison", "Veneno");
        TIPOS.put("ground", "Terra");
        TIPOS.put("flying", "Voador");
        TIPOS.put("psychic", "Psíquico");
        TIPOS.put("bug", "Inseto");
        TIPOS.put("rock", "Pedra");
        TIPOS.put("ghost", "Fantasma");
        TIPOS.put("dragon", "Dragão");
        TIPOS.put("dark", "Sombrio");
        TIPOS.put("steel", "Aço");
        TIPOS.put("fairy", "Fada");

        // STATUS
        STATUS.put("hp", "HP");
        STATUS.put("attack", "Ataque");
        STATUS.put("defense", "Defesa");
        STATUS.put("special-attack", "Ataque Especial");
        STATUS.put("special-defense", "Defesa Especial");
        STATUS.put("speed", "Velocidade");

        // GERAÇÕES
        GERACOES.put("generation-i", "1ª Geração");
        GERACOES.put("generation-ii", "2ª Geração");
        GERACOES.put("generation-iii", "3ª Geração");
        GERACOES.put("generation-iv", "4ª Geração");
        GERACOES.put("generation-v", "5ª Geração");
        GERACOES.put("generation-vi", "6ª Geração");
        GERACOES.put("generation-vii", "7ª Geração");
        GERACOES.put("generation-viii", "8ª Geração");
        GERACOES.put("generation-ix", "9ª Geração");

       
        FORMAS.put("mega", "Mega Evolução");
        FORMAS.put("gmax", "Gigantamax");
        FORMAS.put("alola", "Forma de Alola");
        FORMAS.put("galar", "Forma de Galar");
        FORMAS.put("hisui", "Forma de Hisui");
        FORMAS.put("paldea", "Forma de Paldea");
        FORMAS.put("origin", "Forma Origem");
        FORMAS.put("paradox", "Paradoxo");
    }

    public static String traduzirTipo(String tipo) {
        return TIPOS.getOrDefault(tipo.toLowerCase(), tipo);
    }

    public static String traduzirStatus(String status) {
        return STATUS.getOrDefault(status.toLowerCase(), status);
    }

    public static String traduzirGeracao(String geracao) {
        return GERACOES.getOrDefault(geracao.toLowerCase(), geracao);
    }

    public static String traduzirForma(String forma) {
        return FORMAS.getOrDefault(forma.toLowerCase(), forma);
    }

}