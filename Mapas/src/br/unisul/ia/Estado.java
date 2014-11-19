package br.unisul.ia;

import java.util.ArrayList;
import java.util.List;

public class Estado {
	private String nome;
	private String uf;
	private List<Estado> estadosVizinhos = new ArrayList<Estado>();
	private CorDoEstado corDoEstado;

	public Estado(String nome, String uf) {
		this.nome = nome;
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Estado> getEstadosVizinhos() {
		return estadosVizinhos;
	}

	public void setEstadosVizinhos(List<Estado> estadosVizinhos) {
		this.estadosVizinhos = estadosVizinhos;
	}

	public CorDoEstado getCorDoEstado() {
		return corDoEstado;
	}

	public void setCorDoEstado(CorDoEstado corDoEstado) {
		this.corDoEstado = corDoEstado;
	}

	public int getTotalVizinhos() {
		return this.estadosVizinhos.size();
	}

	public boolean isColorido() {
		return this.corDoEstado != null;
	}
}