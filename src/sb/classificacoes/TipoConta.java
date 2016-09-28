package sb.classificacoes;

public enum TipoConta {

	CC(0, "Conta Corrente"), 
	CP(1, "Conta Poupanca"), 
	CE(2, "Conta Eletronica");

	private String tipo;

	public String toString() {
		return getTipo();
	}
	
	private TipoConta(Integer numeracao, String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
