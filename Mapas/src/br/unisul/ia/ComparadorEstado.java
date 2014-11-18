package br.unisul.ia;

import java.util.Comparator;

public class ComparadorEstado implements Comparator<Estado> {

	@Override
	public int compare(Estado estado, Estado outroEstado) {
		return estado.getTotalVizinhos() > outroEstado.getTotalVizinhos() ? -1 : 1;
	}
}