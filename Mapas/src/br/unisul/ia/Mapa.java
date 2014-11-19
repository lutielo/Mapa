package br.unisul.ia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapa {
	List<Estado> estados = EstadoFactory.popularEstados();
	List<CorDoEstado> coresEstados = Arrays.asList(CorDoEstado.values());

	public void colorirEstados() {
		for (Estado estado : estados) {
			colorirEstado(estado);
			for (Estado vizinho : estado.getEstadosVizinhos()) {
				colorirEstado(vizinho);
			}
		}
	}

	public void colorirEstado(Estado estado) {
		CorDoEstado corDoEstado = null;
		for (CorDoEstado cor : coresEstados) {
			boolean podeSerColorido = true;
			for (Estado vizinho : estado.getEstadosVizinhos()) {
				if (vizinho.isColorido()) {
					if (vizinho.getCorDoEstado().equals(cor)) {
						podeSerColorido = false;
						break;
					}
				}
			}
			if (podeSerColorido) {
				corDoEstado = cor;
				break;
			}
		}
		estado.setCorDoEstado(corDoEstado);
	}

	public void contarEstadosColoridos() {
		int contadorAzul = 0;
		int contadorAmarelo = 0;
		int contadorVerde = 0;
		int contadorVermelho = 0;

		for (Estado estado : estados) {
			if (estado.getCorDoEstado().equals(CorDoEstado.AZUL)) {
				contadorAzul++;
			} else if (estado.getCorDoEstado().equals(CorDoEstado.AMARELO)) {
				contadorAmarelo++;
			} else if (estado.getCorDoEstado().equals(CorDoEstado.VERDE)) {
				contadorVerde++;
			} else {
				contadorVermelho++;
			}
		}

		System.out.println("Estados pintados com a cor Azul: " + contadorAzul);
		System.out.println("Estados pintados com a cor Amarela: " + contadorAmarelo);
		System.out.println("Estados pintados com a cor Verde: " + contadorVerde);
		System.out.println("Estados pintados com a cor Vermelha: " + contadorVermelho);
	}

	public void gerarGrafo(boolean colorir, String nomeArquivo) {
		for (Estado estado : estados) {
			if (colorir) {
				System.out.println("Estado: " + estado.getUf() + " | Cor: " + estado.getCorDoEstado());
			}
		}
	}

	public void equilibrarCores() {
		limparCoresDosEstados();

		int mediaDeCores = estados.size() / coresEstados.size();
		int maximoDeCores = mediaDeCores + 1;

		List<Estado> estadosPintados = new ArrayList<Estado>();

		int contador = 0, posicaoEstado = 0;
		CorDoEstado corEstado = null, corDisponivel = null;

		Estado estadoVigente = null;

		Map<CorDoEstado, Integer> quantidadesPorCor = new HashMap<CorDoEstado, Integer>();
		quantidadesPorCor.put(CorDoEstado.AZUL, 0);
		quantidadesPorCor.put(CorDoEstado.AMARELO, 0);
		quantidadesPorCor.put(CorDoEstado.VERDE, 0);
		quantidadesPorCor.put(CorDoEstado.VERMELHO, 0);

		while (estadosPintados.size() != estados.size()) {
			estadoVigente = estados.get(posicaoEstado);

			for (int i = contador; i < coresEstados.size();) {
				corEstado = coresEstados.get(i);
				corDisponivel = this.obterCorDisponivel(quantidadesPorCor, maximoDeCores);
				if (estadoPodeSerPintado(estadosPintados, estadoVigente, corDisponivel)) {
					estadoVigente.setCorDoEstado(corDisponivel);
					estados.set(posicaoEstado, estadoVigente);
					estadosPintados.add(estadoVigente);
					quantidadesPorCor.put(corDisponivel, quantidadesPorCor.get(corDisponivel) + 1);
					posicaoEstado++;
				} else if (estadoPodeSerPintado(estadosPintados, estadoVigente,	corEstado)) {
					estadoVigente.setCorDoEstado(corEstado);
					estados.set(posicaoEstado, estadoVigente);
					estadosPintados.add(estadoVigente);
					quantidadesPorCor.put(corEstado, quantidadesPorCor.get(corEstado) + 1);
					posicaoEstado++;
				}
				contador = ++i;
				break;
			}
			if (contador == coresEstados.size()) {
				contador = 0;
			}
		}
	}

	private void limparCoresDosEstados() {
		for (Estado estado : estados) {
			estado.setCorDoEstado(null);
		}
	}

	private CorDoEstado obterCorDisponivel(Map<CorDoEstado, Integer> mapCoresQuantidade, int maximoDeCores) {
		Integer quantidadeAzul = mapCoresQuantidade.get(CorDoEstado.AZUL);
		Integer quantidadeAmarelo = mapCoresQuantidade.get(CorDoEstado.AMARELO);
		Integer quantidadeVerde = mapCoresQuantidade.get(CorDoEstado.VERDE);

		if (quantidadeAzul < maximoDeCores)
			return CorDoEstado.AZUL;
		else if (quantidadeAmarelo < maximoDeCores)
			return CorDoEstado.AMARELO;
		else if (quantidadeVerde < maximoDeCores)
			return CorDoEstado.VERDE;
		else
			return CorDoEstado.VERMELHO;
	}

	private boolean estadoPodeSerPintado(List<Estado> estadosPintados, Estado estado, CorDoEstado corEstado) {
		if (!estadosPintados.contains(estado)) {
			for (Estado vizinho : estado.getEstadosVizinhos()) {
				if (corEstado.equals(vizinho.getCorDoEstado())) return false;
			}
		} else {
			return false;
		}
		return true;
	}
}