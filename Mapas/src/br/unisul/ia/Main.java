package br.unisul.ia;

import br.unisul.ia.Mapa;

public class Main {
	public static void main(String[] args) {
		Mapa mapa = new Mapa();
		mapa.gerarGrafo(false, "original");

		mapa.colorirEstados();
		mapa.gerarGrafo(true, "colorido");
		mapa.contarEstadosColoridos();
		
		System.out.println("");
		mapa.equilibrarCores();
		mapa.gerarGrafo(true, "equilibrado");
		mapa.contarEstadosColoridos();
	}
}