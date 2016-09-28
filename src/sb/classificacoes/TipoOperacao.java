package sb.classificacoes;

public enum TipoOperacao {
	
	SAQUE(0, "saque"), 
	DEPOSITO(1, "deposito"), 
	TRANSFERENCIA(2, "transfer�ncia"), 
	PAGAMENTO(3, "pagamento");

	private String tipoDeOperacao;

	private TipoOperacao(Integer numeracao, String tipoDeOperacao) {
		this.tipoDeOperacao = tipoDeOperacao;
	}
	
	public String toString() {
		return getTipoDeOperacao();
	}

	public String getTipoDeOperacao() {
		return tipoDeOperacao;
	}

	public void setTipoDeOperacao(String tipoDeOperacao) {
		this.tipoDeOperacao = tipoDeOperacao;
	}	
}
