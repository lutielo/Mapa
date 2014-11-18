package br.unisul.ia;

public class Aresta {
	private String nome;
	private Estado estadoOrigem;
	private Estado estadoDestino;

	public Aresta(String nome, Estado estadoOrigem, Estado estadoDestino) {
		this.nome = nome;
		this.estadoOrigem = estadoOrigem;
		this.estadoDestino = estadoDestino;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstadoOrigem() {
		return estadoOrigem;
	}

	public void setEstadoOrigem(Estado estadoOrigem) {
		this.estadoOrigem = estadoOrigem;
	}

	public Estado getEstadoDestino() {
		return estadoDestino;
	}

	public void setEstadoDestino(Estado estadoDestino) {
		this.estadoDestino = estadoDestino;
	}
}