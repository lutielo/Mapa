package br.unisul.ia;

import javax.swing.JOptionPane;

import br.unisul.ia.Mapa;

public class Main {
	public static void main(String[] args) {
		Mapa mapa = new Mapa();

		mapa.colorirEstadosDoMapa();
		mapa.imprimirEstadoCor();
		mapa.imprimeNumerosDeEstadosPintadosPorCor();
		
		int resposta = JOptionPane.showConfirmDialog(null, "Gostaria de equilibrar as cores do mapa ?",
									  "Informação" , JOptionPane.YES_NO_OPTION);
		
		if (resposta == JOptionPane.YES_OPTION) {
			mapa.equilibrarCores();
			mapa.imprimirEstadoCor();
			mapa.imprimeNumerosDeEstadosPintadosPorCor();
			JOptionPane.showMessageDialog(null, "Os mapas (colorido e equilibrado) estão no console");
		} else {
			JOptionPane.showMessageDialog(null, "O mapa colorido está no console");
		}
		 
	}
}