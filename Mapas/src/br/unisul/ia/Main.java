package br.unisul.ia;

import br.unisul.ia.Mapa;

public class Main {
	public static void main(String[] args) {
		Mapa mapa = new Mapa();

		mapa.colorirEstadosDoMapa();
		mapa.gerarGrafo();
		mapa.imprimeNumerosDeEstadosPintadosPorCor();
		
		System.out.println("");
		
		mapa.equilibrarCores();
		mapa.gerarGrafo();
		mapa.imprimeNumerosDeEstadosPintadosPorCor();
	}
}