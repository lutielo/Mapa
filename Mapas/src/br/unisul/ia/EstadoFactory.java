package br.unisul.ia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EstadoFactory {

	static List<Estado> estados = new ArrayList<Estado>();
	static List<Fronteira> fronteiras = new ArrayList<Fronteira>();

	public static List<Estado> popularEstados() {
		Estado rs = criaRioGrandeDoSul();
		Estado sc = criaSantaCatarina();
		Estado pr = criaParaná();
		Estado sp = criaSaoPaulo();
		Estado mg = criaMinasGerais();
		Estado es = criaEspiritoSanto();
		Estado rj = criaRioDeJaneiro();
		Estado ms = criaMatoGrossoDoSul();
		Estado mt = criaMatoGrosso();
		Estado go = criaGoias();
		Estado df = criaDistritoFederal();
		Estado ba = criaBahia();
		Estado pe = criaPernambuco();
		Estado al = criaAlagoas();
		Estado se = criaSergipe();
		Estado pb = criaParaiba();
		Estado pi = criaPiaui();
		Estado ce = criaCeara();
		Estado rn = criaRioGrandeDoNorte();
		Estado ma = criaMaranhao();
		Estado am = criaAmazonas();
		Estado ap = criaAmapa();
		Estado ac = criaAcre();
		Estado pa = criaPara();
		Estado rr = criaRoraima();
		Estado ro = criaRondonia();
		Estado to = criaTocantins();

		relacionaEstadosVizinhos(rs, sc, pr, sp, mg, es, rj, ms, mt, go, df, ba, pe, al, se, pb, pi, ce, rn, ma, am, ap, ac, pa, rr, ro, to);
		adicionaEstadosComVizinhosNaLista(rs, sc, pr, sp, mg, es, rj, ms, mt, go, df, ba, pe, al, se, pb, pi, ce, rn, ma, am, ap, ac, pa, rr, ro, to);
		ordenaEstados();
		return estados;
	}

	private static Estado criaMatoGrosso() {
		return new Estado("Mato Grosso", "MT");
	}

	private static Estado criaRioGrandeDoSul() {
		return new Estado("Rio Grande do Sul", "RS");
	}
	
	private static Estado criaSantaCatarina() {
		return new Estado("Santa Catarina", "SC");
	}
	
	private static Estado criaParaná() {
		return new Estado("Paraná", "PR");
	}
	
	private static Estado criaSaoPaulo() {
		return new Estado("São Paulo", "SP");
	}
	
	private static Estado criaMinasGerais() {
		return new Estado("Minas Gerais", "MG");
	}
	
	private static Estado criaEspiritoSanto() {
		return new Estado("Espírito Santo", "ES");
	}
	
	private static Estado criaRioDeJaneiro() {
		return new Estado("Rio de Janeiro", "RJ");
	}
	
	private static Estado criaMatoGrossoDoSul() {
		return new Estado("Mato Grosso do Sul", "MS");
	}
	
	private static Estado criaGoias() {
		return new Estado("Goiás", "GO");
	}
	
	private static Estado criaDistritoFederal() {
		return new Estado("Distrito Federal", "DF");
	}
	
	private static Estado criaBahia() {
		return new Estado("Bahia", "BA");
	}
	
	private static Estado criaPernambuco() {
		return new Estado("Pernambuco", "PE");
	}
	
	private static Estado criaAlagoas() {
		return new Estado("Alagoas", "AL");
	}
	
	private static Estado criaSergipe() {
		return new Estado("Sergipe", "SE");
	}
	
	private static Estado criaParaiba() {
		return new Estado("Paraíba", "PB");
	}

	private static Estado criaPiaui() {
		return new Estado("Piauí", "PI");
	}
	
	private static Estado criaCeara() {
		return new Estado("Ceará", "CE");
	}
	
	private static Estado criaRioGrandeDoNorte() {
		return new Estado("Rio Grande do Norte", "RN");
	}
	
	private static Estado criaMaranhao() {
		return new Estado("Maranhão", "MA");
	}
	
	private static Estado criaAmazonas() {
		return new Estado("Amazonas", "AM");
	}
	
	private static Estado criaAmapa() {
		return new Estado("Amapá", "AP");
	}
	
	private static Estado criaAcre() {
		return new Estado("Acre", "AC");
	}
	
	private static Estado criaPara() {
		return new Estado("Pará", "PA");
	}
	
	private static Estado criaRoraima() {
		return new Estado("Roraima", "RR");
	}
	
	private static Estado criaRondonia() {
		return new Estado("Rondônia", "RO");
	}
	
	private static Estado criaTocantins() {
		return new Estado("Tocantins", "TO");
	}

	private static void relacionaEstadosVizinhos(Estado rs, Estado sc,
			Estado pr, Estado sp, Estado mg, Estado es, Estado rj, Estado ms,
			Estado mt, Estado go, Estado df, Estado ba, Estado pe, Estado al,
			Estado se, Estado pb, Estado pi, Estado ce, Estado rn, Estado ma,
			Estado am, Estado ap, Estado ac, Estado pa, Estado rr, Estado ro,
			Estado to) {

		List<Estado> vizinhosRS = new ArrayList<Estado>();
		vizinhosRS.add(sc);
		rs.setEstadosVizinhos(vizinhosRS);

		List<Estado> vizinhosSC = new ArrayList<Estado>();
		vizinhosSC.add(pr);
		vizinhosSC.add(rs);
		sc.setEstadosVizinhos(vizinhosSC);

		List<Estado> vizinhosPR = new ArrayList<Estado>();
		vizinhosPR.add(sc);
		vizinhosPR.add(sp);
		vizinhosPR.add(ms);
		pr.setEstadosVizinhos(vizinhosPR);

		List<Estado> vizinhosSP = new ArrayList<Estado>();
		vizinhosSP.add(pr);
		vizinhosSP.add(rj);
		vizinhosSP.add(mg);
		vizinhosSP.add(ms);
		sp.setEstadosVizinhos(vizinhosSP);

		List<Estado> vizinhosMG = new ArrayList<Estado>();
		vizinhosMG.add(sp);
		vizinhosMG.add(rj);
		vizinhosMG.add(es);
		vizinhosMG.add(go);
		vizinhosMG.add(ba);
		vizinhosMG.add(ms);
		vizinhosMG.add(df);
		mg.setEstadosVizinhos(vizinhosMG);

		List<Estado> vizinhosES = new ArrayList<Estado>();
		vizinhosES.add(mg);
		vizinhosES.add(rj);
		vizinhosES.add(ba);
		es.setEstadosVizinhos(vizinhosES);

		List<Estado> vizinhosRJ = new ArrayList<Estado>();
		vizinhosRJ.add(sp);
		vizinhosRJ.add(mg);
		vizinhosRJ.add(es);
		rj.setEstadosVizinhos(vizinhosRJ);

		List<Estado> vizinhosMS = new ArrayList<Estado>();
		vizinhosMS.add(mt);
		vizinhosMS.add(sp);
		vizinhosMS.add(pr);
		vizinhosMS.add(go);
		vizinhosMS.add(mg);
		ms.setEstadosVizinhos(vizinhosMS);

		List<Estado> vizinhosMT = new ArrayList<Estado>();
		vizinhosMT.add(ro);
		vizinhosMT.add(pa);
		vizinhosMT.add(am);
		vizinhosMT.add(to);
		vizinhosMT.add(go);
		vizinhosMT.add(ms);
		mt.setEstadosVizinhos(vizinhosMT);

		List<Estado> vizinhosGO = new ArrayList<Estado>();
		vizinhosGO.add(df);
		vizinhosGO.add(ms);
		vizinhosGO.add(mg);
		vizinhosGO.add(mt);
		vizinhosGO.add(ba);
		vizinhosGO.add(to);
		go.setEstadosVizinhos(vizinhosGO);

		List<Estado> vizinhosDF = new ArrayList<Estado>();
		vizinhosDF.add(go);
		vizinhosDF.add(mg);
		df.setEstadosVizinhos(vizinhosDF);

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

		List<Estado> vizinhosSE = new ArrayList<Estado>();
		vizinhosSE.add(al);
		vizinhosSE.add(ba);
		se.setEstadosVizinhos(vizinhosSE);

		List<Estado> vizinhosPE = new ArrayList<Estado>();
		vizinhosPE.add(al);
		vizinhosPE.add(pb);
		vizinhosPE.add(ba);
		vizinhosPE.add(pi);
		vizinhosPE.add(ce);
		pe.setEstadosVizinhos(vizinhosPE);

		List<Estado> vizinhosAL = new ArrayList<Estado>();
		vizinhosAL.add(se);
		vizinhosAL.add(pe);
		vizinhosAL.add(ba);
		al.setEstadosVizinhos(vizinhosAL);

		List<Estado> vizinhosCE = new ArrayList<Estado>();
		vizinhosCE.add(pb);
		vizinhosCE.add(rn);
		vizinhosCE.add(pe);
		vizinhosCE.add(pi);
		ce.setEstadosVizinhos(vizinhosCE);

		List<Estado> vizinhosPI = new ArrayList<Estado>();
		vizinhosPI.add(ba);
		vizinhosPI.add(ce);
		vizinhosPI.add(pe);
		vizinhosPI.add(ma);
		vizinhosPI.add(to);
		pi.setEstadosVizinhos(vizinhosPI);

		List<Estado> vizinhosPB = new ArrayList<Estado>();
		vizinhosPB.add(rn);
		vizinhosPB.add(pe);
		vizinhosPB.add(ce);
		pb.setEstadosVizinhos(vizinhosPB);

		List<Estado> vizinhosRN = new ArrayList<Estado>();
		vizinhosRN.add(pb);
		vizinhosRN.add(ce);
		rn.setEstadosVizinhos(vizinhosRN);

		List<Estado> vizinhosMA = new ArrayList<Estado>();
		vizinhosMA.add(pi);
		vizinhosMA.add(to);
		vizinhosMA.add(pa);
		ma.setEstadosVizinhos(vizinhosMA);

		List<Estado> vizinhosAM = new ArrayList<Estado>();
		vizinhosAM.add(pa);
		vizinhosAM.add(rr);
		vizinhosAM.add(ac);
		vizinhosAM.add(ro);
		vizinhosAM.add(mt);
		am.setEstadosVizinhos(vizinhosAM);

		List<Estado> vizinhosPA = new ArrayList<Estado>();
		vizinhosPA.add(to);
		vizinhosPA.add(ma);
		vizinhosPA.add(ap);
		vizinhosPA.add(am);
		vizinhosPA.add(mt);
		vizinhosPA.add(rr);
		pa.setEstadosVizinhos(vizinhosPA);

		List<Estado> vizinhosRR = new ArrayList<Estado>();
		vizinhosRR.add(pa);
		vizinhosRR.add(am);
		rr.setEstadosVizinhos(vizinhosRR);

		List<Estado> vizinhosAC = new ArrayList<Estado>();
		vizinhosAC.add(am);
		vizinhosAC.add(ro);
		ac.setEstadosVizinhos(vizinhosAC);

		List<Estado> vizinhosRO = new ArrayList<Estado>();
		vizinhosRO.add(mt);
		vizinhosRO.add(am);
		vizinhosRO.add(ac);
		ro.setEstadosVizinhos(vizinhosRO);

		List<Estado> vizinhosAP = new ArrayList<Estado>();
		vizinhosAP.add(pa);
		ap.setEstadosVizinhos(vizinhosAP);

		List<Estado> vizinhosTO = new ArrayList<Estado>();
		vizinhosTO.add(ma);
		vizinhosTO.add(pi);
		vizinhosTO.add(ba);
		vizinhosTO.add(go);
		vizinhosTO.add(mt);
		vizinhosTO.add(pa);
		to.setEstadosVizinhos(vizinhosTO);
	}
	
	private static void adicionaEstadosComVizinhosNaLista(Estado rs, Estado sc,
			Estado pr, Estado sp, Estado mg, Estado es, Estado rj, Estado ms,
			Estado mt, Estado go, Estado df, Estado ba, Estado pe, Estado al,
			Estado se, Estado pb, Estado pi, Estado ce, Estado rn, Estado ma,
			Estado am, Estado ap, Estado ac, Estado pa, Estado rr, Estado ro,
			Estado to) {
		
		estados.add(rs);
		estados.add(sc);
		estados.add(pr);
		estados.add(sp);
		estados.add(mg);
		estados.add(es);
		estados.add(rj);
		estados.add(ms);
		estados.add(mt);
		estados.add(go);
		estados.add(df);
		estados.add(ba);
		estados.add(pe);
		estados.add(al);
		estados.add(se);
		estados.add(pb);
		estados.add(pi);
		estados.add(ce);
		estados.add(rn);
		estados.add(ma);
		estados.add(am);
		estados.add(ap);
		estados.add(ac);
		estados.add(pa);
		estados.add(rr);
		estados.add(ro);
		estados.add(to);
	}
	
	public static void ordenaEstados() {
		Collections.sort(estados, new ComparadorEstado());

		System.out.println("Populando fronteiras");
		for (Estado estado : estados) {
			for (Estado vizinho : estado.getEstadosVizinhos()) {
				popularFronteiras(estado, vizinho);
			}
		}
	}

	public static void popularFronteiras(Estado estado, Estado vizinho) {
		String nome = estado.getUf() + " ~ " + vizinho.getUf();
		System.out.println(nome);

		fronteiras.add(new Fronteira(nome, estado, vizinho));

		Estado estadoOrigem = null;
		for (int i = 0; i < fronteiras.size(); i++) {
			estadoOrigem = fronteiras.get(i).getEstado();
			if (vizinho.equals(estadoOrigem)) {
				fronteiras.remove(fronteiras.size() - 1);
				break;
			}
		}
	}
}