package sb.classificacoes;

public enum tipoOperacao {
	
	SAQUE(0, "saque"), DEPOSITO(1, "deposito"), TRANSFERENCIA(2, "transfer�ncia"), PAGAMENTO(3, "pagamento");

	private String tipoDeOperacao;

	private tipoOperacao(Integer ordinal, String operacao) {
		this.tipoDeOperacao = operacao;
	}

	public String getTipoDeOperacao() {
		return tipoDeOperacao;
	}

	public void setTipoDeOperacao(String tipoDeOperacao) {
		this.tipoDeOperacao = tipoDeOperacao;
	}
		
	public String toString() {
		return getTipoDeOperacao();
	}
		
}
