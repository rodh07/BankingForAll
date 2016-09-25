package sb.classificacoes;

public enum TipoConta {

	CC(0, "Conta Corrente"), 
	CP(1, "Conta Poupan�a"), 
	CE(2, "Conta Eletr�nica");

	private String descricao;

	private TipoConta(Integer ordinal, String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public String toString() {
		return getDescricao();
	}

}
