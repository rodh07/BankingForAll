package sb.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sb.view.MainCliente;
import sb.model.Conta;

public class MainCliente extends CabecalhoCliente {

	private static final long serialVersionUID = 1L;
	private JButton btnSaque;
	private JButton btnTransferncia;
	private JButton btnSaldo;
	private JButton btnPagamentos;
	private JButton btnDeposito;
	private JButton btnFinaliza;
	static final String CONTA_ELETRONICA = "Conta Eletronica";
	static final String CONTA_POUPANCA = "Conta Poupanca";
	static final String CONTA_CORRENTE = "Conta Corrente";

	public MainCliente(final Conta conta) {
		super(conta);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Sistema Banking For All");
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane().getLayout();
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 1.0 };
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 290, 31, 292, 0 };
		gbl_panel.rowHeights = new int[] { 67, 77, 64, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		btnSaque = new JButton("1- Saque");
		btnSaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RealizarSaque realizarSaque = new RealizarSaque(conta, null);
				realizarSaque.setVisible(true);
				realizarSaque.setLocationRelativeTo(null);
			}
		});
		GridBagConstraints gbc_btnSaque = new GridBagConstraints();
		gbc_btnSaque.fill = GridBagConstraints.BOTH;
		gbc_btnSaque.insets = new Insets(0, 0, 5, 5);
		gbc_btnSaque.gridx = 0;
		gbc_btnSaque.gridy = 0;
		panel.add(btnSaque, gbc_btnSaque);

		btnTransferncia = new JButton("4- Transferencia");
		GridBagConstraints gbc_btnTransferncia = new GridBagConstraints();
		gbc_btnTransferncia.fill = GridBagConstraints.BOTH;
		gbc_btnTransferncia.insets = new Insets(0, 0, 5, 0);
		gbc_btnTransferncia.gridx = 2;
		gbc_btnTransferncia.gridy = 0;
		panel.add(btnTransferncia, gbc_btnTransferncia);

		btnSaldo = new JButton("2- Saldo");
		btnSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SaldoCliente saldoCliente = new SaldoCliente(conta);
				saldoCliente.setVisible(true);
				saldoCliente.setLocationRelativeTo(null);
			}
		});
		GridBagConstraints gbc_btnSaldo = new GridBagConstraints();
		gbc_btnSaldo.fill = GridBagConstraints.BOTH;
		gbc_btnSaldo.insets = new Insets(0, 0, 5, 5);
		gbc_btnSaldo.gridx = 0;
		gbc_btnSaldo.gridy = 1;
		panel.add(btnSaldo, gbc_btnSaldo);

		btnPagamentos = new JButton("5- Pagamentos");
		btnPagamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RealizarPagamento realizarPagamento = new RealizarPagamento(conta);
				realizarPagamento.setVisible(true);
				realizarPagamento.setLocationRelativeTo(null);
				realizarPagamento.setResizable(false);
			}
		});
		GridBagConstraints gbc_btnPagamentos = new GridBagConstraints();
		gbc_btnPagamentos.fill = GridBagConstraints.BOTH;
		gbc_btnPagamentos.insets = new Insets(0, 0, 5, 0);
		gbc_btnPagamentos.gridx = 2;
		gbc_btnPagamentos.gridy = 1;
		panel.add(btnPagamentos, gbc_btnPagamentos);

		btnDeposito = new JButton("3- Deposito");
		btnDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				RealizarDeposito realizarDeposito = new RealizarDeposito(conta);
				realizarDeposito.setVisible(true);
				realizarDeposito.setResizable(false);
				realizarDeposito.setLocationRelativeTo(null);
			}
		});

		GridBagConstraints gbc_btnDepsito = new GridBagConstraints();
		gbc_btnDepsito.fill = GridBagConstraints.BOTH;
		gbc_btnDepsito.insets = new Insets(0, 0, 0, 5);
		gbc_btnDepsito.gridx = 0;
		gbc_btnDepsito.gridy = 2;
		panel.add(btnDeposito, gbc_btnDepsito);

		btnFinaliza = new JButton("6- Finalizar");
		btnFinaliza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Integer finalizarConta = JOptionPane.showConfirmDialog(
						MainCliente.this, "Deseja finalizar esta conta?", "",
						JOptionPane.YES_NO_OPTION);

				if (finalizarConta.equals(0)) {
					new sb.controller.ContaController().finalizarConta(conta);
				}
			}
		});
		GridBagConstraints gbc_btnFinaliza = new GridBagConstraints();
		gbc_btnFinaliza.fill = GridBagConstraints.BOTH;
		gbc_btnFinaliza.gridx = 2;
		gbc_btnFinaliza.gridy = 2;
		panel.add(btnFinaliza, gbc_btnFinaliza);
		validaTipodaConta(conta);
	}

	private void validaTipodaConta(final Conta conta) {
		if (conta.getId() == null) {
			JOptionPane.showMessageDialog(MainCliente.this,
					"Usuario sem conta cadastrada. Verifique!", "Erro!",
					JOptionPane.ERROR_MESSAGE);
		} else {
			switch (conta.getTipoConta()) {
			case CONTA_POUPANCA:
				btnPagamentos.setEnabled(false);
				break;
			case CONTA_ELETRONICA:
				btnSaque.setEnabled(false);
				btnDeposito.setEnabled(false);
				break;
			default:
				//CONTA_CORRENTE LIBERADO TODAS AS OPÇÕES.
				break;
			}
		}
	}
	@Override
	public void deposito(Conta conta, BigDecimal valorDeposito) {
	}

	@Override
	public boolean saque(Conta conta, BigDecimal valorSaque,
			String senhaInformada) {
		return false;
	}

	@Override
	public boolean transferencia(Conta conta, Conta contaRecebeTransf,
			BigDecimal valorTransf) {
		return false;
	}

	@Override
	public void finalizarConta(Conta conta) {
	}

	@Override
	public void contaAlterada(Conta conta) {		
	}

	@Override
	public boolean pagamento(Conta conta, BigDecimal valorPagamento,
			String codigoDeBarras) {
		return false;
	}
}
