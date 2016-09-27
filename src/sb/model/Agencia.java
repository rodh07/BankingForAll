package sb.model;

public class Agencia {

	private Integer id;
	private String nome;
	private String numeroAgencia;
	private String cidade;

	public Agencia(Integer id, String nome, String numero, String cidade) {
		this.id = id;
		this.nome = nome;
		this.numeroAgencia = numero;
		this.cidade = cidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(String numero) {
		this.numeroAgencia = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
