package sb.classificacoes;

public enum ClassificacaoUsuario {

	CLIENTE(0),

	BANCARIO(1);

	private Integer numeracao;
	
	public Integer getNumeracao() {
		return numeracao;
	}

	public void setNumeracao(Integer numeracao) {
		this.numeracao = numeracao;
	}

	private ClassificacaoUsuario(Integer numeracao) {
		this.numeracao = numeracao;
	}
}
