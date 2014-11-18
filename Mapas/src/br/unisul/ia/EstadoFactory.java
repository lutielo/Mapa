package br.unisul.ia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EstadoFactory {

	static List<Estado> estados = new ArrayList<Estado>();
	static List<Aresta> arestas = new ArrayList<Aresta>();

	public static List<Estado> popularEstados() {
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

		ordenaEstados();

		return estados;

	}

	public static void ordenaEstados() {
		// Ordena os estados de forma decrescente em relação ao número de
		// vizinhos
		Collections.sort(estados, new ComparadorEstado());

		System.out.println("Populando arestas");
		for (Estado estado : estados) {
			for (Estado vizinho : estado.getEstadosVizinhos()) {
				popularArestas(estado, vizinho);
			}
		}
		System.out.println("");
	}

	public static void popularArestas(Estado estado, Estado vizinho) {
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
}