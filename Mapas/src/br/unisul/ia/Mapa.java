package br.unisul.ia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapa {
	List<Estado> estados = EstadoFactory.popularEstados();
	List<CorDoEstado> coresDisponiveisParaPintura = Arrays.asList(CorDoEstado.values());

	public void colorirEstadosDoMapa() {
		for (Estado estado : this.estados) {
			colorirEstado(estado);
			for (Estado vizinho : estado.getEstadosVizinhos()) {
				colorirEstado(vizinho);
			}
		}
	}

	public void colorirEstado(Estado estado) {
		for (CorDoEstado cor : this.coresDisponiveisParaPintura) {
			boolean estadoPodeSerColorido = true;
			for (Estado vizinho : estado.getEstadosVizinhos()) {
				if (vizinho.isColorido()) {
					if (vizinhoJaUsaCor(cor, vizinho)) {
						estadoPodeSerColorido = false;
						break;
					}
				}
			}
			if (estadoPodeSerColorido) {
				estado.setCorDoEstado(cor);
				break;
			}
		}
	}

	private boolean vizinhoJaUsaCor(CorDoEstado cor, Estado vizinho) {
		return vizinho.getCorDoEstado().equals(cor);
	}

	public void imprimeNumerosDeEstadosPintadosPorCor() {
		int numeroEstadosCorAzul = 0;
		int numeroEstadosCorAmarela = 0;
		int numeroEstadosCorVerde = 0;
		int numeroEstadosCorVermelha = 0;

		for (Estado estado : this.estados) {
			if (estado.getCorDoEstado().equals(CorDoEstado.AZUL)) {
				numeroEstadosCorAzul++;
			} else if (estado.getCorDoEstado().equals(CorDoEstado.AMARELO)) {
				numeroEstadosCorAmarela++;
			} else if (estado.getCorDoEstado().equals(CorDoEstado.VERDE)) {
				numeroEstadosCorVerde++;
			} else {
				numeroEstadosCorVermelha++;
			}
		}
		System.out.println("");
		System.out.println("Número de estados pintados com Azul: " + numeroEstadosCorAzul);
		System.out.println("Número de estados pintados com Amarelo: " + numeroEstadosCorAmarela);
		System.out.println("Número de estados pintados com Verde: " + numeroEstadosCorVerde);
		System.out.println("Número de estados pintados com Vermelha: " + numeroEstadosCorVermelha);
	}

	public void imprimirEstadoCor() {
		System.out.println("");
		for (Estado estado : this.estados) {
			System.out.println("Estado: " + estado.getUf() + " | Cor: " + estado.getCorDoEstado());
		}
	}

	public void equilibrarCores() {
		limparCoresDosEstados();

		int mediaDeCores = this.estados.size() / this.coresDisponiveisParaPintura.size();
		int maximoDeCores = mediaDeCores + 1;

		List<Estado> estadosPintados = new ArrayList<Estado>();

		int contador = 0, posicaoEstado = 0;
		CorDoEstado corEstado = null, corDisponivel = null;

		Estado estadoAtual = null;

		Map<CorDoEstado, Integer> quantidadesPorCor = new HashMap<CorDoEstado, Integer>();
		quantidadesPorCor.put(CorDoEstado.AZUL, 0);
		quantidadesPorCor.put(CorDoEstado.AMARELO, 0);
		quantidadesPorCor.put(CorDoEstado.VERDE, 0);
		quantidadesPorCor.put(CorDoEstado.VERMELHO, 0);

		while (estadosPintados.size() != this.estados.size()) {
			estadoAtual = this.estados.get(posicaoEstado);

			for (int i = contador; i < this.coresDisponiveisParaPintura.size();) {
				corEstado = this.coresDisponiveisParaPintura.get(i);
				corDisponivel = this.obterCorDisponivel(quantidadesPorCor, maximoDeCores);
				if (estadoPodeSerPintado(estadosPintados, estadoAtual, corDisponivel)) {
					estadoAtual.setCorDoEstado(corDisponivel);
					this.estados.set(posicaoEstado, estadoAtual);
					estadosPintados.add(estadoAtual);
					quantidadesPorCor.put(corDisponivel, quantidadesPorCor.get(corDisponivel) + 1);
					posicaoEstado++;
				} else if (estadoPodeSerPintado(estadosPintados, estadoAtual, corEstado)) {
					estadoAtual.setCorDoEstado(corEstado);
					this.estados.set(posicaoEstado, estadoAtual);
					estadosPintados.add(estadoAtual);
					quantidadesPorCor.put(corEstado, quantidadesPorCor.get(corEstado) + 1);
					posicaoEstado++;
				}
				contador = ++i;
				break;
			}
			if (contador == this.coresDisponiveisParaPintura.size()) {
				contador = 0;
			}
		}
	}

	private void limparCoresDosEstados() {
		for (Estado estado : this.estados) {
			estado.setCorDoEstado(null);
		}
	}

	private CorDoEstado obterCorDisponivel( Map<CorDoEstado, Integer> mapCoresQuantidade, int maximoDeCores) {
		Integer quantidadeAzul = mapCoresQuantidade.get(CorDoEstado.AZUL);
		Integer quantidadeAmarelo = mapCoresQuantidade.get(CorDoEstado.AMARELO);
		Integer quantidadeVerde = mapCoresQuantidade.get(CorDoEstado.VERDE);

		if (quantidadeAzul < maximoDeCores) {
			return CorDoEstado.AZUL;
		} else if (quantidadeAmarelo < maximoDeCores) {
			return CorDoEstado.AMARELO;
		} else if (quantidadeVerde < maximoDeCores) {
			return CorDoEstado.VERDE;
		} else {
			return CorDoEstado.VERMELHO;
		}
	}

	private boolean estadoPodeSerPintado(List<Estado> estadosPintados, Estado estado, CorDoEstado corEstado) {
		boolean estadoPodeSerPintado = true;
		if (!estadosPintados.contains(estado)) {
			for (Estado vizinho : estado.getEstadosVizinhos()) {
				if (corEstado.equals(vizinho.getCorDoEstado())) {
					estadoPodeSerPintado = false;
				}
			}
		}
		return estadoPodeSerPintado;
	}
}