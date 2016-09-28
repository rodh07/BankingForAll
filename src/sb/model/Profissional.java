package sb.model;

import sb.classificacoes.ClassificacaoUsuario;

public class Profissional {

	private Integer id;
	private String nome;
	private Integer idade;
	private String usuario;
	private String acesso;
	private String senhaOperacoes;
	private ClassificacaoUsuario tipoProfissional;

	public Profissional(Integer id, String nome, String usuario, Integer idade, String acesso,
			String senhaOperacoes, ClassificacaoUsuario tipoProfissional) {
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.idade = idade;
		this.acesso = acesso;
		this.senhaOperacoes = senhaOperacoes;
		this.tipoProfissional = tipoProfissional;
	}

	public Profissional() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getUserName() {
		return usuario;
	}

	public void setUserName(String userName) {
		this.usuario = userName;
	}

	public String getAcesso() {
		return acesso;
	}

	public void setAcesso(String Acesso) {
		this.acesso = Acesso;
	}

	public String getSenhaOperacoes() {
		return senhaOperacoes;
	}

	public void setSenhaOperacoes(String senhaOperacoes) {
		this.senhaOperacoes = senhaOperacoes;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public ClassificacaoUsuario getTipoProfissional() {
		return tipoProfissional;
	}

	public void setTipoProfissional(ClassificacaoUsuario tipoProfissional) {
		this.tipoProfissional = tipoProfissional;
	}
	
}
