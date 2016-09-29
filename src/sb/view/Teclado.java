package sb.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sb.model.Movimentacao;
import sb.classificacoes.TipoOperacao;
import sb.controller.ContaController;
import sb.view.OperacaoConfirmada;
import sb.model.Conta;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Teclado extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private StringBuilder senhaTeclado;
	private JTextField txtSenhaOperacao;
	private Teclado teclado;


	public Teclado(final Conta conta, final BigDecimal valor, final Conta contaTransferir, final TipoOperacao operacao, final String codigoBarras,
			Movimentacao movimentacao) {
		setSize(176, 238);
		setTitle("Senha");
		teclado = this;
		senhaTeclado = new StringBuilder();
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("./Icones/Play.png"));

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 24, 7, 39, 39, 45, 19, 39, 0 };
		gbl_panel.rowHeights = new int[] { 32, 24, 25, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblTeclado = new JLabel("TECLADO VIRTUAL");
		lblTeclado.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_lblTeclado = new GridBagConstraints();
		gbc_lblTeclado.gridwidth = 3;
		gbc_lblTeclado.insets = new Insets(0, 0, 5, 5);
		gbc_lblTeclado.gridx = 2;
		gbc_lblTeclado.gridy = 0;
		panel.add(lblTeclado, gbc_lblTeclado);

		txtSenhaOperacao = new JTextField();
		GridBagConstraints gbc_txtSenhaOperacao = new GridBagConstraints();
		gbc_txtSenhaOperacao.gridwidth = 3;
		gbc_txtSenhaOperacao.fill = GridBagConstraints.BOTH;
		gbc_txtSenhaOperacao.insets = new Insets(0, 0, 5, 5);
		gbc_txtSenhaOperacao.gridx = 2;
		gbc_txtSenhaOperacao.gridy = 1;
		panel.add(txtSenhaOperacao, gbc_txtSenhaOperacao);
		txtSenhaOperacao.setColumns(10);
		txtSenhaOperacao.requestFocus();

		JButton btnSete = new JButton("7");
		btnSete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				senhaTeclado.append("7");
				SetarNumero(senhaTeclado);
			}
		});
		GridBagConstraints gbc_btnSete = new GridBagConstraints();
		gbc_btnSete.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSete.insets = new Insets(0, 0, 5, 5);
		gbc_btnSete.gridx = 2;
		gbc_btnSete.gridy = 2;
		panel.add(btnSete, gbc_btnSete);

		JButton btnOito = new JButton("8");
		btnOito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				senhaTeclado.append("8");
				SetarNumero(senhaTeclado);
			}
		});
		GridBagConstraints gbc_btnOito = new GridBagConstraints();
		gbc_btnOito.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnOito.insets = new Insets(0, 0, 5, 5);
		gbc_btnOito.gridx = 3;
		gbc_btnOito.gridy = 2;
		panel.add(btnOito, gbc_btnOito);

		JButton btnNove = new JButton("9");
		btnNove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				senhaTeclado.append("9");
				SetarNumero(senhaTeclado);
			}
		});
		GridBagConstraints gbc_btnNove = new GridBagConstraints();
		gbc_btnNove.insets = new Insets(0, 0, 5, 5);
		gbc_btnNove.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNove.gridx = 4;
		gbc_btnNove.gridy = 2;
		panel.add(btnNove, gbc_btnNove);

		JButton btnQuatro = new JButton("4");
		btnQuatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				senhaTeclado.append("4");
				SetarNumero(senhaTeclado);
			}
		});
		GridBagConstraints gbc_btnQuatro = new GridBagConstraints();
		gbc_btnQuatro.anchor = GridBagConstraints.WEST;
		gbc_btnQuatro.insets = new Insets(0, 0, 5, 5);
		gbc_btnQuatro.gridx = 2;
		gbc_btnQuatro.gridy = 3;
		panel.add(btnQuatro, gbc_btnQuatro);

		JButton btnCinco = new JButton("5");
		btnCinco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				senhaTeclado.append("5");
				SetarNumero(senhaTeclado);
			}
		});
		GridBagConstraints gbc_btnCinco = new GridBagConstraints();
		gbc_btnCinco.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCinco.insets = new Insets(0, 0, 5, 5);
		gbc_btnCinco.gridx = 3;
		gbc_btnCinco.gridy = 3;
		panel.add(btnCinco, gbc_btnCinco);

		JButton btnSeis = new JButton("6");
		btnSeis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				senhaTeclado.append("6");
				SetarNumero(senhaTeclado);
			}
		});
		GridBagConstraints gbc_btnSeis = new GridBagConstraints();
		gbc_btnSeis.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSeis.insets = new Insets(0, 0, 5, 5);
		gbc_btnSeis.gridx = 4;
		gbc_btnSeis.gridy = 3;
		panel.add(btnSeis, gbc_btnSeis);

		JButton btnUm = new JButton("1");
		btnUm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				senhaTeclado.append("1");
				SetarNumero(senhaTeclado);
			}
		});
		GridBagConstraints gbc_btnUm = new GridBagConstraints();
		gbc_btnUm.anchor = GridBagConstraints.WEST;
		gbc_btnUm.insets = new Insets(0, 0, 5, 5);
		gbc_btnUm.gridx = 2;
		gbc_btnUm.gridy = 4;
		panel.add(btnUm, gbc_btnUm);

		JButton btnDois = new JButton("2");
		btnDois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				senhaTeclado.append("2");
				SetarNumero(senhaTeclado);
			}
		});
		GridBagConstraints gbc_btnDois = new GridBagConstraints();
		gbc_btnDois.anchor = GridBagConstraints.WEST;
		gbc_btnDois.insets = new Insets(0, 0, 5, 5);
		gbc_btnDois.gridx = 3;
		gbc_btnDois.gridy = 4;
		panel.add(btnDois, gbc_btnDois);

		JButton btnTres = new JButton("3");
		btnTres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				senhaTeclado.append("3");
				SetarNumero(senhaTeclado);
			}
		});
		GridBagConstraints gbc_btnTres = new GridBagConstraints();
		gbc_btnTres.anchor = GridBagConstraints.WEST;
		gbc_btnTres.insets = new Insets(0, 0, 5, 5);
		gbc_btnTres.gridx = 4;
		gbc_btnTres.gridy = 4;
		panel.add(btnTres, gbc_btnTres);

		JButton button = new JButton("-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				senhaTeclado.append("0");
				SetarNumero(senhaTeclado);
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 2;
		gbc_button.gridy = 5;
		panel.add(button, gbc_button);

		JButton btnZero = new JButton("0");
		btnZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				senhaTeclado.append("0");
				SetarNumero(senhaTeclado);
			}
		});
		GridBagConstraints gbc_btnZero = new GridBagConstraints();
		gbc_btnZero.anchor = GridBagConstraints.WEST;
		gbc_btnZero.insets = new Insets(0, 0, 5, 5);
		gbc_btnZero.gridx = 3;
		gbc_btnZero.gridy = 5;
		panel.add(btnZero, gbc_btnZero);

		JButton button_1 = new JButton("-");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					limparCampos();
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.anchor = GridBagConstraints.WEST;
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 4;
		gbc_button_1.gridy = 5;
		panel.add(button_1, gbc_button_1);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				senhaTeclado = new StringBuilder();
				senhaTeclado.append(txtSenhaOperacao.getText());

				if (conta.getSenhaOperacoes().equals(senhaTeclado.toString())) {

					switch (operacao) {
					case SAQUE:
						validacaoSaque(conta, valor);
						break;
					case TRANSFERENCIA:
						validacaoTransferencia(conta, contaTransferir, valor);
						break;
					case PAGAMENTO:
						validacaoPagamento(conta, valor, operacao, codigoBarras);
						break;
					default:
						break;
					}
				}
			}
		});
		GridBagConstraints gbc_btnConfirmar = new GridBagConstraints();
		gbc_btnConfirmar.gridwidth = 3;
		gbc_btnConfirmar.gridheight = 2;
		gbc_btnConfirmar.fill = GridBagConstraints.BOTH;
		gbc_btnConfirmar.insets = new Insets(0, 0, 0, 5);
		gbc_btnConfirmar.gridx = 2;
		gbc_btnConfirmar.gridy = 6;
		panel.add(btnConfirmar, gbc_btnConfirmar);
	}

	protected void SetarNumero(StringBuilder senha) {

		txtSenhaOperacao.setText(senha.toString());
	}
	
	private void limparCampos() {
		senhaTeclado = new StringBuilder();
		SetarNumero(senhaTeclado);
	}
	
	protected void validacaoPagamento(Conta conta, BigDecimal valor,
			TipoOperacao operacao, String codBarras) {

		boolean pagou = new sb.controller.ContaController()
				.pagamento(conta, valor, codBarras);
		limparCampos();
		if (pagou) {
			OperacaoConfirmada operacaoConfirmada = new OperacaoConfirmada(conta,
					TipoOperacao.PAGAMENTO, valor);
			operacaoConfirmada.setVisible(true);
			teclado.setVisible(false);
		}

	}

	protected void validacaoTransferencia(Conta conta, Conta contaTransferir,
			BigDecimal valor) {

		boolean transferiu = new sb.controller.ContaController().transferencia(conta,
				contaTransferir, valor);

		limparCampos();

		if (transferiu) {
			OperacaoConfirmada operacaoConfirmada = new OperacaoConfirmada(
					contaTransferir, TipoOperacao.TRANSFERENCIA, valor);
			operacaoConfirmada.setVisible(true);
			teclado.setVisible(false);
		}
	}
	protected void validacaoSaque(Conta conta, BigDecimal valorSaque) {
		boolean sacou = new ContaController().saque(conta, valorSaque,
				senhaTeclado.toString());

		limparCampos();

		if (sacou) {
			OperacaoConfirmada opRealizada = new OperacaoConfirmada(conta,
					TipoOperacao.SAQUE, valorSaque);
			opRealizada.setVisible(true);
			teclado.setVisible(false);
		}
	}

}
