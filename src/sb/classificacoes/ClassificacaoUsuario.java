package sb.classificacoes;

public enum ClassificacaoUsuario {

	CLIENTE(0),

	BANCARIO(1);

	private Integer ordinal;

	private ClassificacaoUsuario(Integer ordinal) {
		this.ordinal = ordinal;
	}

	public Integer getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(Integer ordinal) {
		this.ordinal = ordinal;
	}

}
