package br.com.elias.pokedex.model;
import java.util.ArrayList;
import java.util.List;

public class Pokemon {

	private int id;
	private int numeroPokedex;
	private String nome;
	private String tipo;
	private double altura;
	private double peso;
	private String descricao;
	private String imagem;
	private int hp;
	private int ataque;
	private int defesa;
	private int ataqueEspecial;
	private int defesaEspecial;
	private int velocidade;
	private List<FormaPokemon> formas = new ArrayList<>();
	private String habilidades;

	public Pokemon() {
	}

	public Pokemon(int id, int numeroPokedex, String nome, String tipo, double altura, double peso, String descricao,
			String imagem) {

		this.id = id;
		this.numeroPokedex = numeroPokedex;
		this.nome = nome;
		this.tipo = tipo;
		this.altura = altura;
		this.peso = peso;
		this.descricao = descricao;
		this.imagem = imagem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroPokedex() {
		return numeroPokedex;
	}

	public void setNumeroPokedex(int numeroPokedex) {
		this.numeroPokedex = numeroPokedex;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}

	public int getAtaqueEspecial() {
		return ataqueEspecial;
	}

	public void setAtaqueEspecial(int ataqueEspecial) {
		this.ataqueEspecial = ataqueEspecial;
	}

	public int getDefesaEspecial() {
		return defesaEspecial;
	}

	public void setDefesaEspecial(int defesaEspecial) {
		this.defesaEspecial = defesaEspecial;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public String getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(String habilidades) {
		this.habilidades = habilidades;
	}

}