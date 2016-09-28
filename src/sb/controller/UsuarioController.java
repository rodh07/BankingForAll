package sb.controller;

import java.util.List;

import sb.classificacoes.ClassificacaoUsuario;
import sb.dao.UsuarioDao;
import sb.model.Command;
import sb.model.MD5;
import sb.model.Sha256;
import sb.model.Usuario;


public class UsuarioController {

	public boolean acessoLogin(String usuario, String senha, ClassificacaoUsuario tipoUsuario) {

		UsuarioDao userDao = new UsuarioDao();
		boolean login = false;

		if (tipoUsuario == ClassificacaoUsuario.CLIENTE) {

			Command commandUser = new Sha256(usuario);
			String usuarioHash = commandUser.execute();

			Command commandPass = new Sha256(senha);
			String senhaHash = commandPass.execute();

			login = userDao.acessoLogin(usuarioHash, senhaHash);

		} else if (tipoUsuario == ClassificacaoUsuario.BANCARIO) {

			Command commandUser = new MD5(usuario);
			String usuarioHash = commandUser.execute();
			Command commandPass = new MD5(senha);
			String senhaHash = commandPass.execute();

			login = userDao.acessoLogin(usuarioHash, senhaHash);
		}

		return login;

	}

	public void add(Usuario usuario) {

		Command commandUser = new MD5(usuario.getUsuario());
		String usuarioHash = commandUser.execute();

		Command commandPass = new MD5(usuario.getSenha());
		String senhaHash = commandPass.execute();

		usuario.setId(usuario.getId());
		usuario.setUsuario(usuarioHash.toString());
		usuario.setSenha(senhaHash.toString());
		usuario.setTipoUsuario(usuario.getTipoUsuario());

		new UsuarioDao().add(usuario);

	}

}
