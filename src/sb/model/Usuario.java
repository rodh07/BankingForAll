package sb.model;

import sb.classificacoes.ClassificacaoUsuario;

public class Usuario {

	private int id;
	private String usuario;
	private String senha;
	private ClassificacaoUsuario tipoUsuario;

	public Usuario(String usuario, String senha, ClassificacaoUsuario tipoUsuario) {
		this.usuario = usuario;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ClassificacaoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(ClassificacaoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}
