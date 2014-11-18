package br.unisul.ia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapa {
	List<Estado> estados = EstadoFactory.popularEstados();
	List<CorEstado> coresEstados = Arrays.asList(CorEstado.values());

	public void colorirEstados() {
		for (Estado estado : estados) {
			colorirEstado(estado);
			for (Estado vizinho : estado.getEstadosVizinhos()) {
				colorirEstado(vizinho);
			}
		}
	}

	public void colorirEstado(Estado estado) {
		CorEstado corEstado = null;
		for (CorEstado cor : coresEstados) {
			boolean podeSerColorido = true;
			for (Estado vizinho : estado.getEstadosVizinhos()) {
				if (vizinho.isColorido()) {
					if (vizinho.getCorEstado().equals(cor)) {
						podeSerColorido = false;
						break;
					}
				}
			}
			if (podeSerColorido) {
				corEstado = cor;
				break;
			}
		}
		estado.setCorEstado(corEstado);
	}

	public void contarEstadosColoridos() {
		int contadorAzul = 0;
		int contadorAmarelo = 0;
		int contadorVerde = 0;
		int contadorVermelho = 0;

		for (Estado estado : estados) {
			if (estado.getCorEstado().equals(CorEstado.AZUL)) {
				contadorAzul++;
			} else if (estado.getCorEstado().equals(CorEstado.AMARELO)) {
				contadorAmarelo++;
			} else if (estado.getCorEstado().equals(CorEstado.VERDE)) {
				contadorVerde++;
			} else {
				contadorVermelho++;
			}
		}

		System.out.println("Estados pintados com a cor Azul: " + contadorAzul);
		System.out.println("Estados pintados com a cor Amarela: "
				+ contadorAmarelo);
		System.out
				.println("Estados pintados com a cor Verde: " + contadorVerde);
		System.out.println("Estados pintados com a cor Vermelha: "
				+ contadorVermelho);
	}

	public void gerarGrafo(boolean colorir, String nomeArquivo) {
		for (Estado estado : estados) {
			if (colorir) {
				System.out.println("Estado: " + estado.getSigla() + "/ Cor: "
						+ estado.getCorEstado());
			}
		}
	}

	public void equilibrarCores() {
		limparCoresDosEstados();

		int mediaDeCores = estados.size() / coresEstados.size();
		int maximoDeCores = mediaDeCores + 1;

		List<Estado> estadosPintados = new ArrayList<Estado>();

		int contador = 0, posicaoEstado = 0;
		CorEstado corEstado = null, corDisponivel = null;

		Estado estadoVigente = null;

		Map<CorEstado, Integer> quantidadesPorCor = new HashMap<CorEstado, Integer>();
		quantidadesPorCor.put(CorEstado.AZUL, 0);
		quantidadesPorCor.put(CorEstado.AMARELO, 0);
		quantidadesPorCor.put(CorEstado.VERDE, 0);
		quantidadesPorCor.put(CorEstado.VERMELHO, 0);

		while (estadosPintados.size() != estados.size()) {
			estadoVigente = estados.get(posicaoEstado);

			for (int i = contador; i < coresEstados.size();) {
				corEstado = coresEstados.get(i);
				corDisponivel = this.obterCorDisponivel(quantidadesPorCor,
						maximoDeCores);
				if (estadoPodeSerPintado(estadosPintados, estadoVigente,
						corDisponivel)) {
					estadoVigente.setCorEstado(corDisponivel);
					estados.set(posicaoEstado, estadoVigente);
					estadosPintados.add(estadoVigente);
					quantidadesPorCor.put(corDisponivel,
							quantidadesPorCor.get(corDisponivel) + 1);
					posicaoEstado++;
				} else if (estadoPodeSerPintado(estadosPintados, estadoVigente,
						corEstado)) {
					estadoVigente.setCorEstado(corEstado);
					estados.set(posicaoEstado, estadoVigente);
					estadosPintados.add(estadoVigente);
					quantidadesPorCor.put(corEstado,
							quantidadesPorCor.get(corEstado) + 1);
					posicaoEstado++;
				}
				contador = ++i;
				break;
			}
			if (contador == coresEstados.size())
				contador = 0;
		}
	}

	private void limparCoresDosEstados() {
		for (Estado estado : estados) {
			estado.setCorEstado(null);
		}
	}

	private CorEstado obterCorDisponivel(
			Map<CorEstado, Integer> mapCoresQuantidade, int maximoDeCores) {
		Integer quantidadeAzul = mapCoresQuantidade.get(CorEstado.AZUL);
		Integer quantidadeAmarelo = mapCoresQuantidade.get(CorEstado.AMARELO);
		Integer quantidadeVerde = mapCoresQuantidade.get(CorEstado.VERDE);

		if (quantidadeAzul < maximoDeCores)
			return CorEstado.AZUL;
		else if (quantidadeAmarelo < maximoDeCores)
			return CorEstado.AMARELO;
		else if (quantidadeVerde < maximoDeCores)
			return CorEstado.VERDE;
		else
			return CorEstado.VERMELHO;
	}

	private boolean estadoPodeSerPintado(List<Estado> estadosPintados,
			Estado estado, CorEstado corEstado) {
		if (!estadosPintados.contains(estado)) {
			for (Estado vizinho : estado.getEstadosVizinhos()) {
				if (corEstado.equals(vizinho.getCorEstado()))
					return false;
			}
		} else {
			return false;
		}
		return true;
	}
}