package sb.controller;

import java.sql.SQLException;
import java.util.List;

import sb.classificacoes.ClassificacaoUsuario;
import sb.model.Command;
import sb.model.MD5;
import sb.model.Profissional;
import sb.model.Sha256;
import sb.model.Usuario;

import br.univel.dao.ProfissionalDao;
import br.univel.dao.UsuarioDao;

public class ProfissionalController {

	public void add(Profissional profisisonal) {

		if (profisisonal.getTipoProfissional().equals(ClassificacaoUsuario.CLIENTE)) {

			Command commandUser = new Sha256(profisisonal.getUserName());
			String usuarioHash = commandUser.execute();

			Command commandSenha = new Sha256(profisisonal.getSenhaAcesso());
			String senhaHash = commandSenha.execute();

			profisisonal.setSenhaAcesso(senhaHash);
			profisisonal.setUserName(usuarioHash);

			Usuario usuario = new Usuario(usuarioHash, senhaHash, profisisonal.getTipoProfissional());

			new ProfissionalDao().add(profisisonal);

			new UsuarioDao().add(usuario);

		} else if (profisisonal.getTipoProfissional().equals(ClassificacaoUsuario.BANCARIO)) {

			Command commandUser = new MD5(profisisonal.getUserName());
			String usuarioHash = commandUser.execute();

			Command commandSenha = new MD5(profisisonal.getSenhaAcesso());
			String senhaHash = commandSenha.execute();

			Usuario usuario = new Usuario(usuarioHash, senhaHash, profisisonal.getTipoProfissional());

			profisisonal.setSenhaAcesso(senhaHash);
			profisisonal.setUserName(usuarioHash);

			new ProfissionalDao().add(profisisonal);

			new UsuarioDao().add(usuario);

		}

	}

	public List<Profissional> buscarProfissionais() {

		return new ProfissionalDao().buscarProfissionais();
	}

	public Profissional get(Integer idProfissional) throws SQLException {

		return new ProfissionalDao().get(idProfissional);
	}

	public void edit(Profissional profissional) {

		if (profissional.getTipoProfissional().equals(ClassificacaoUsuario.CLIENTE)) {

			Command commandUser = new Sha256(profissional.getUserName());
			String usuarioHash = commandUser.execute();

			Command commandSenha = new Sha256(profissional.getSenhaAcesso());
			String senhaHash = commandSenha.execute();

			profissional.setSenhaAcesso(senhaHash);
			profissional.setUserName(usuarioHash);
			
			new UsuarioDao().edit(new Usuario(usuarioHash, senhaHash, ClassificacaoUsuario.CLIENTE), profissional.getId());
			new ProfissionalDao().edit(profissional);

		} else if (profissional.getTipoProfissional().equals(ClassificacaoUsuario.BANCARIO)) {

			Command commandUser = new MD5(profissional.getUserName());
			String usuarioHash = commandUser.execute();

			Command commandSenha = new MD5(profissional.getSenhaAcesso());
			String senhaHash = commandSenha.execute();

			new UsuarioDao().edit(new Usuario(usuarioHash, senhaHash, ClassificacaoUsuario.BANCARIO), profissional.getId());

			new ProfissionalDao().edit(profissional);
		}

	}

}
