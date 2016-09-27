package sb.controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import sb.classificacoes.ClassificacaoUsuario;
import sb.model.Command;
import sb.model.Conta;
import sb.model.Funcionalidades;
import sb.model.Sha256;
import sb.model.Usuario;

import br.univel.dao.AgenciaDao;
import br.univel.dao.ContaDao;
import br.univel.dao.UsuarioDao;

public class ContaController implements Funcionalidades {

	public void add(Conta conta) {

		Integer agExiste = new AgenciaDao().getNumero(conta.getAgencia());

		if (agExiste > 0) {

			Command commandUser = new Sha256(conta.getUsuarioAcesso());
			String userAcessoHash = commandUser.execute();

			Command commandSenha = new Sha256(conta.getAcesso());
			String senhaAcessoHash = commandSenha.execute();

			Usuario usuario = new Usuario(userAcessoHash, senhaAcessoHash, ClassificacaoUsuario.CLIENTE);

			conta.setUsuarioAcesso(userAcessoHash);
			conta.setAcesso(senhaAcessoHash);

			try {

				new ContaDao().add(conta);
				new UsuarioDao().add(usuario);

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			String mensagem = "Ag�ncia " + conta.getAgencia() + " inexistente!!!";
			JOptionPane.showMessageDialog(null, mensagem, "Aten��o", JOptionPane.ERROR_MESSAGE);
		}

	}

	public List<Conta> buscarContas() throws SQLException {

		return new ContaDao().buscarContas();
	}

	public Conta get(String usuario, String senha) {

		Command commandUser = new Sha256(usuario);
		String userAcessoHash = commandUser.execute();

		Command commandSenha = new Sha256(senha);
		String senhaAcessoHash = commandSenha.execute();

		return new ContaDao().get(userAcessoHash, senhaAcessoHash);
	}

	public Conta getContaDeposito(String agencia, String numero, String titular) {

		return new ContaDao().getContaDeposito(agencia, numero, titular);
	}

	@Override
	public void deposito(Conta conta, BigDecimal valorDeposito) {

		conta = new ContaDao().getContaDeposito(conta.getAgencia(), conta.getNumeroConta(), conta.getNome());

		if (conta.getId() == null) {
			JOptionPane.showMessageDialog(null, "Conta n�o localizada. Verifique!", "Aten��o",
					JOptionPane.WARNING_MESSAGE);
		} else {


		}
	}

	@Override
	public void saque(Conta conta, BigDecimal valorSaque) {

		
		
		
	}

	@Override
	public void transferencia(Conta conta, Conta contaRecebeTransf, BigDecimal valorTransf) {

	}

	@Override
	public void pagamento(Conta conta, BigDecimal valorPagam) {

	}

	@Override
	public void finalizarConta(Conta conta) {

	}

}
