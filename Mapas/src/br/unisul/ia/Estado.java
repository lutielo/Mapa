package br.unisul.ia;

import java.util.ArrayList;
import java.util.List;

enum CorEstado {
	// AZUL("Azul"), AMARELO("Amarelo"), VERDE("Verde"), VERMELHO("Vermelho");
	AZUL("#0066FF"), AMARELO("#FFFF00"), VERDE("#009900"), VERMELHO("#FF0000");

	private String cor;

	CorEstado(String cor) {
		this.cor = cor;
	}

	public String getCor() {
		return this.cor;
	}
}

public class Estado {
	private String nome;
	private String sigla;
	private List<Estado> estadosVizinhos = new ArrayList<Estado>();
	private CorEstado corEstado;

	public Estado(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Estado> getEstadosVizinhos() {
		return estadosVizinhos;
	}

	public void setEstadosVizinhos(List<Estado> estadosVizinhos) {
		this.estadosVizinhos = estadosVizinhos;
	}

	public CorEstado getCorEstado() {
		return corEstado;
	}

	public void setCorEstado(CorEstado corEstado) {
		this.corEstado = corEstado;
	}

	public int getTotalVizinhos() {
		return this.estadosVizinhos.size();
	}

	public boolean isColorido() {
		return this.corEstado != null;
	}
}