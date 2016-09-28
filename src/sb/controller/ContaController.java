package sb.controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import sb.classificacoes.ClassificacaoUsuario;
import sb.model.Command;
import sb.model.Conta;
import sb.model.Funcionalidades;
import sb.model.Movimentacao;
import sb.model.Sha256;
import sb.model.Usuario;

import sb.dao.AgenciaDao;
import sb.dao.ContaDao;
import sb.dao.UsuarioDao;
import sb.model.Movimentacao;

public class ContaController implements Funcionalidades {

	public void add(Conta conta) {

		Integer agExiste = new AgenciaDao().getNumero(conta.getAgencia());

		if (agExiste > 0) {

			Command commandUser = new Sha256(conta.getUsuarioAcesso());
			String userAcessoHash = commandUser.execute();

			Command commandSenha = new Sha256(conta.getAcesso());
			String senhaAcessoHash = commandSenha.execute();

			Usuario usuario = new Usuario(userAcessoHash, senhaAcessoHash,
					ClassificacaoUsuario.CLIENTE);

			conta.setUsuarioAcesso(userAcessoHash);
			conta.setAcesso(senhaAcessoHash);

			new ContaDao().add(conta);
			new UsuarioDao().add(usuario);

		} else {
			String mensagem = "AG: " + conta.getAgencia() + " não existe!";
			JOptionPane.showMessageDialog(null, mensagem, "Atencao",
					JOptionPane.ERROR_MESSAGE);
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

		return new ContaDao().getConta(agencia, numero, titular);
	}

	@Override
	public void deposito(Conta conta, BigDecimal valorDeposito) {

		conta = new ContaDao().getConta(conta.getAgencia(),
				conta.getNumeroConta(), conta.getNome());

		if (conta.getId() == null) {
			JOptionPane.showMessageDialog(null,
					"Conta nao localizada. Verifique!", "Erro!",
					JOptionPane.WARNING_MESSAGE);
		} else {

		}
	}

	@Override
	public boolean saque(Conta conta, BigDecimal valorSaque,
			String senhaInformada) {

		return new Movimentacao().saque(conta, valorSaque, senhaInformada);

	}

	@Override
	public boolean transferencia(Conta conta, Conta contaRecebeTransf,
			BigDecimal valorTransf) {

		return new Movimentacao().transferencia(conta, contaRecebeTransf,
				valorTransf);
	}

	@Override
	public boolean pagamento(Conta conta, BigDecimal valorPagam,
			String codigoDeBarras) {

		return new Movimentacao().pagamento(conta, valorPagam, codigoDeBarras);
	}

	@Override
	public void finalizarConta(Conta conta) {

		new Movimentacao().finalizarConta(conta);
	}

	@Override
	public void contaAlterada(Conta conta) {
		// TODO Auto-generated method stub

	}

	public Conta openBancario(String agencia, String numeroConta,
			String tipoConta, String titular) {

		Conta conta = new ContaDao().getConta(agencia, numeroConta, titular);

		return conta;
	}
}
