package br.unisul.ia;

enum CorDoEstado {
	AZUL("Azul"), AMARELO("Amarelo"), VERDE("Verde"), VERMELHO("Vermelho");
	private String cor;

	CorDoEstado(String cor) {
		this.cor = cor;
	}

	public String getCor() {
		return this.cor;
	}
}