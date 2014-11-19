package br.unisul.ia;

public class Fronteira {
	private String relacao;
	private Estado estado;
	private Estado vizinho;

	public Fronteira(String relacao, Estado estado, Estado vizinho) {
		this.relacao = relacao;
		this.estado = estado;
		this.vizinho = vizinho;
	}

	public String getRelacao() {
		return relacao;
	}

	public void setRelacao(String relacao) {
		this.relacao = relacao;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Estado getVizinho() {
		return vizinho;
	}

	public void setVizinho(Estado vizinho) {
		this.vizinho = vizinho;
	}

}