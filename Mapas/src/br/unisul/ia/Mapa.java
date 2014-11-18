package br.unisul.ia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapa {
	List<Estado> estados = new ArrayList<Estado>();
	List<Aresta> arestas = new ArrayList<Aresta>();
	List<CorEstado> coresEstados = Arrays.asList(CorEstado.values());

	public void popularEstados() {
		// Região Sul
		Estado rs = new Estado("Rio Grande do Sul", "RS");
		Estado sc = new Estado("Santa Catarina", "SC");
		Estado pr = new Estado("Paraná", "PR");

		// Região Sudeste
		Estado sp = new Estado("São Paulo", "SP");
		Estado mg = new Estado("Minas Gerais", "MG");
		Estado es = new Estado("Espírito Santo", "ES");
		Estado rj = new Estado("Rio de Janeiro", "RJ");

		// Região Centro-Oeste
		Estado ms = new Estado("Mato Grosso do Sul", "MS");
		Estado mt = new Estado("Mato Grosso", "MT");
		Estado go = new Estado("Goiás", "GO");
		Estado df = new Estado("Distrito Federal", "DF");

		// Região Nordeste
		Estado ba = new Estado("Bahia", "BA");
		Estado pe = new Estado("Pernambuco", "PE");
		Estado al = new Estado("Alagoas", "AL");
		Estado se = new Estado("Sergipe", "SE");
		Estado pb = new Estado("Paraíba", "PB");
		Estado pi = new Estado("Piauí", "PI");
		Estado ce = new Estado("Ceará", "CE");
		Estado rn = new Estado("Rio Grande do Norte", "RN");
		Estado ma = new Estado("Maranhão", "MA");

		// Região Norte
		Estado am = new Estado("Amazonas", "AM");
		Estado ap = new Estado("Amapá", "AP");
		Estado ac = new Estado("Acre", "AC");
		Estado pa = new Estado("Pará", "PA");
		Estado rr = new Estado("Roraima", "RR");
		Estado ro = new Estado("Rondônia", "RO");
		Estado to = new Estado("Tocantins", "TO");

		// RS -> SC
		List<Estado> vizinhosRS = new ArrayList<Estado>();
		vizinhosRS.add(sc);
		rs.setEstadosVizinhos(vizinhosRS);

		// SC -> RS, PR
		List<Estado> vizinhosSC = new ArrayList<Estado>();
		vizinhosSC.add(pr);
		vizinhosSC.add(rs);
		sc.setEstadosVizinhos(vizinhosSC);

		// PR -> SC, SP, MS
		List<Estado> vizinhosPR = new ArrayList<Estado>();
		vizinhosPR.add(sc);
		vizinhosPR.add(sp);
		vizinhosPR.add(ms);
		pr.setEstadosVizinhos(vizinhosPR);

		// SP -> PR, RJ, MG, MS
		List<Estado> vizinhosSP = new ArrayList<Estado>();
		vizinhosSP.add(pr);
		vizinhosSP.add(rj);
		vizinhosSP.add(mg);
		vizinhosSP.add(ms);
		sp.setEstadosVizinhos(vizinhosSP);

		// MG -> SP, RJ, ES, GO, BA, MS, DF
		List<Estado> vizinhosMG = new ArrayList<Estado>();
		vizinhosMG.add(sp);
		vizinhosMG.add(rj);
		vizinhosMG.add(es);
		vizinhosMG.add(go);
		vizinhosMG.add(ba);
		vizinhosMG.add(ms);
		vizinhosMG.add(df);
		mg.setEstadosVizinhos(vizinhosMG);

		// ES -> MG, RJ, BA
		List<Estado> vizinhosES = new ArrayList<Estado>();
		vizinhosES.add(mg);
		vizinhosES.add(rj);
		vizinhosES.add(ba);
		es.setEstadosVizinhos(vizinhosES);

		// RJ -> SP, MG, ES
		List<Estado> vizinhosRJ = new ArrayList<Estado>();
		vizinhosRJ.add(sp);
		vizinhosRJ.add(mg);
		vizinhosRJ.add(es);
		rj.setEstadosVizinhos(vizinhosRJ);

		// MS -> MT, SP, PR, GO, MG
		List<Estado> vizinhosMS = new ArrayList<Estado>();
		vizinhosMS.add(mt);
		vizinhosMS.add(sp);
		vizinhosMS.add(pr);
		vizinhosMS.add(go);
		vizinhosMS.add(mg);
		ms.setEstadosVizinhos(vizinhosMS);

		// MT -> RO, PA, AM, TO, GO, MS
		List<Estado> vizinhosMT = new ArrayList<Estado>();
		vizinhosMT.add(ro);
		vizinhosMT.add(pa);
		vizinhosMT.add(am);
		vizinhosMT.add(to);
		vizinhosMT.add(go);
		vizinhosMT.add(ms);
		mt.setEstadosVizinhos(vizinhosMT);

		// GO -> MS, MG, MT, DF, TO, BA
		List<Estado> vizinhosGO = new ArrayList<Estado>();
		vizinhosGO.add(df);
		vizinhosGO.add(ms);
		vizinhosGO.add(mg);
		vizinhosGO.add(mt);
		vizinhosGO.add(ba);
		vizinhosGO.add(to);
		go.setEstadosVizinhos(vizinhosGO);

		// DF -> GO, MG
		List<Estado> vizinhosDF = new ArrayList<Estado>();
		vizinhosDF.add(go);
		vizinhosDF.add(mg);
		df.setEstadosVizinhos(vizinhosDF);

		// BA -> TO, MG, GO, ES, SE, PI, PE, AL
		List<Estado> vizinhosBA = new ArrayList<Estado>();
		vizinhosBA.add(to);
		vizinhosBA.add(mg);
		vizinhosBA.add(go);
		vizinhosBA.add(es);
		vizinhosBA.add(se);
		vizinhosBA.add(pi);
		vizinhosBA.add(pe);
		vizinhosBA.add(al);
		ba.setEstadosVizinhos(vizinhosBA);

		// SE -> AL, BA
		List<Estado> vizinhosSE = new ArrayList<Estado>();
		vizinhosSE.add(al);
		vizinhosSE.add(ba);
		se.setEstadosVizinhos(vizinhosSE);

		// PE -> AL, PB, BA, PI, CE
		List<Estado> vizinhosPE = new ArrayList<Estado>();
		vizinhosPE.add(al);
		vizinhosPE.add(pb);
		vizinhosPE.add(ba);
		vizinhosPE.add(pi);
		vizinhosPE.add(ce);
		pe.setEstadosVizinhos(vizinhosPE);

		// AL -> SE, PE, BA
		List<Estado> vizinhosAL = new ArrayList<Estado>();
		vizinhosAL.add(se);
		vizinhosAL.add(pe);
		vizinhosAL.add(ba);
		al.setEstadosVizinhos(vizinhosAL);

		// CE -> PB, RN, PE, PI
		List<Estado> vizinhosCE = new ArrayList<Estado>();
		vizinhosCE.add(pb);
		vizinhosCE.add(rn);
		vizinhosCE.add(pe);
		vizinhosCE.add(pi);
		ce.setEstadosVizinhos(vizinhosCE);

		// PI -> BA, CE, PE, MA, TO
		List<Estado> vizinhosPI = new ArrayList<Estado>();
		vizinhosPI.add(ba);
		vizinhosPI.add(ce);
		vizinhosPI.add(pe);
		vizinhosPI.add(ma);
		vizinhosPI.add(to);
		pi.setEstadosVizinhos(vizinhosPI);

		// PB -> RN, PE, CE
		List<Estado> vizinhosPB = new ArrayList<Estado>();
		vizinhosPB.add(rn);
		vizinhosPB.add(pe);
		vizinhosPB.add(ce);
		pb.setEstadosVizinhos(vizinhosPB);

		// RN -> PB, CE
		List<Estado> vizinhosRN = new ArrayList<Estado>();
		vizinhosRN.add(pb);
		vizinhosRN.add(ce);
		rn.setEstadosVizinhos(vizinhosRN);

		// MA -> PI, TO, PA
		List<Estado> vizinhosMA = new ArrayList<Estado>();
		vizinhosMA.add(pi);
		vizinhosMA.add(to);
		vizinhosMA.add(pa);
		ma.setEstadosVizinhos(vizinhosMA);

		// AM -> PA, RR, AC, RO, MT
		List<Estado> vizinhosAM = new ArrayList<Estado>();
		vizinhosAM.add(pa);
		vizinhosAM.add(rr);
		vizinhosAM.add(ac);
		vizinhosAM.add(ro);
		vizinhosAM.add(mt);
		am.setEstadosVizinhos(vizinhosAM);

		// PA -> TO, MA, AP, AM, MT, RR
		List<Estado> vizinhosPA = new ArrayList<Estado>();
		vizinhosPA.add(to);
		vizinhosPA.add(ma);
		vizinhosPA.add(ap);
		vizinhosPA.add(am);
		vizinhosPA.add(mt);
		vizinhosPA.add(rr);
		pa.setEstadosVizinhos(vizinhosPA);

		// RR -> PA, AM
		List<Estado> vizinhosRR = new ArrayList<Estado>();
		vizinhosRR.add(pa);
		vizinhosRR.add(am);
		rr.setEstadosVizinhos(vizinhosRR);

		// AC -> AM, RO
		List<Estado> vizinhosAC = new ArrayList<Estado>();
		vizinhosAC.add(am);
		vizinhosAC.add(ro);
		ac.setEstadosVizinhos(vizinhosAC);

		// RO -> MT, AM, AC
		List<Estado> vizinhosRO = new ArrayList<Estado>();
		vizinhosRO.add(mt);
		vizinhosRO.add(am);
		vizinhosRO.add(ac);
		ro.setEstadosVizinhos(vizinhosRO);

		// AP -> PA
		List<Estado> vizinhosAP = new ArrayList<Estado>();
		vizinhosAP.add(pa);
		ap.setEstadosVizinhos(vizinhosAP);

		// TO -> MA, PI, BA, GO, MT, PA
		List<Estado> vizinhosTO = new ArrayList<Estado>();
		vizinhosTO.add(ma);
		vizinhosTO.add(pi);
		vizinhosTO.add(ba);
		vizinhosTO.add(go);
		vizinhosTO.add(mt);
		vizinhosTO.add(pa);
		to.setEstadosVizinhos(vizinhosTO);

		// Região Sul
		estados.add(rs);
		estados.add(sc);
		estados.add(pr);

		// Região Sudeste
		estados.add(sp);
		estados.add(mg);
		estados.add(es);
		estados.add(rj);

		// Região Centro-Oeste
		estados.add(ms);
		estados.add(mt);
		estados.add(go);
		estados.add(df);

		// Região Nordeste
		estados.add(ba);
		estados.add(pe);
		estados.add(al);
		estados.add(se);
		estados.add(pb);
		estados.add(pi);
		estados.add(ce);
		estados.add(rn);
		estados.add(ma);

		// Região Norte
		estados.add(am);
		estados.add(ap);
		estados.add(ac);
		estados.add(pa);
		estados.add(rr);
		estados.add(ro);
		estados.add(to);

		// Ordena os estados de forma decrescente em relação ao número de vizinhos
		Collections.sort(estados, new EstadoComparator());
		
		System.out.println("Populando arestas");
		for (Estado estado : estados) {
			for (Estado vizinho : estado.getEstadosVizinhos()) {
				popularArestas(estado, vizinho);
			}
		}
		System.out.println("");
	}

	public void colorirEstados() {
		for (Estado estado : estados) {
			colorirEstado(estado);
			for (Estado vizinho : estado.getEstadosVizinhos()) {
				colorirEstado(vizinho);
			}
		}
	}

	public void popularArestas(Estado estado, Estado vizinho) {
		String nome = estado.getSigla() + " -> " + vizinho.getSigla();
		
		System.out.println(nome);
		
		arestas.add(new Aresta(nome, estado, vizinho));

		Estado estadoOrigem = null;
		for (int i = 0; i < arestas.size(); i++) {
			estadoOrigem = arestas.get(i).getEstadoOrigem();
			if (vizinho.equals(estadoOrigem)) {
				arestas.remove(arestas.size() - 1);
				break;
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

	private class EstadoComparator implements Comparator<Estado> {
		@Override
		public int compare(Estado estado, Estado outroEstado) {
			return estado.getTotalVizinhos() > outroEstado.getTotalVizinhos() ? -1 : 1;
		}
	}

	public void contarEstadosColoridos() {
		int contadorAzul = 0;
		int contadorAmarelo = 0;
		int contadorVerde = 0;
		int contadorVermelho = 0;

		for (Estado estado : estados) {
			if (estado.getCorEstado().equals(CorEstado.AZUL)){
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
		System.out.println("Estados pintados com a cor Amarela: " + contadorAmarelo);
		System.out.println("Estados pintados com a cor Verde: " + contadorVerde);
		System.out.println("Estados pintados com a cor Vermelha: " + contadorVermelho);
	}

	public void gerarGrafo(boolean colorir, String nomeArquivo) {
		for (Estado estado : estados) {
			if (colorir) {
				System.out.println("Estado: " + estado.getSigla() + "/ Cor: " + estado.getCorEstado() );
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
				corDisponivel = this.obterCorDisponivel(quantidadesPorCor, maximoDeCores);
				if (estadoPodeSerPintado(estadosPintados, estadoVigente, corDisponivel)) {
					estadoVigente.setCorEstado(corDisponivel);
					estados.set(posicaoEstado, estadoVigente);
					estadosPintados.add(estadoVigente);
					quantidadesPorCor.put(corDisponivel, quantidadesPorCor.get(corDisponivel) + 1);
					posicaoEstado++;
				} else if (estadoPodeSerPintado(estadosPintados, estadoVigente, corEstado)) {
					estadoVigente.setCorEstado(corEstado);
					estados.set(posicaoEstado, estadoVigente);
					estadosPintados.add(estadoVigente);
					quantidadesPorCor.put(corEstado, quantidadesPorCor.get(corEstado) + 1);
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

	private CorEstado obterCorDisponivel(Map<CorEstado, Integer> mapCoresQuantidade, int maximoDeCores) {
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

	private boolean estadoPodeSerPintado(List<Estado> estadosPintados, Estado estado, CorEstado corEstado) {
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