package sb.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import sb.classificacoes.TipoOperacao;
import sb.model.Conta;

import java.awt.Font;

public class RealizarPagamento extends CabecalhoCliente {

	private static final long serialVersionUID = 1L;
	public JTextField txtCodbarras;
	public JTextField txtValorPag;

	public RealizarPagamento(final Conta conta) {
		super(conta);
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane()
				.getLayout();
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0 };
		setTitle("Pagamento de Contas");

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 313, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 42, 32, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblCodigoBarras = new JLabel("C\u00F3digo de Barras");
		lblCodigoBarras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCodigoBarras = new GridBagConstraints();
		gbc_lblCodigoBarras.anchor = GridBagConstraints.WEST;
		gbc_lblCodigoBarras.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigoBarras.gridx = 3;
		gbc_lblCodigoBarras.gridy = 1;
		panel.add(lblCodigoBarras, gbc_lblCodigoBarras);

		DecimalFormat dFormat = new DecimalFormat("#,###,###.00");
		NumberFormatter formatter = new NumberFormatter(dFormat);
		formatter.setFormat(dFormat);
		formatter.setAllowsInvalid(false);

		txtCodbarras = new JTextField();
		GridBagConstraints gbc_txtCodbarras = new GridBagConstraints();
		gbc_txtCodbarras.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodbarras.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodbarras.gridx = 3;
		gbc_txtCodbarras.gridy = 2;
		panel.add(txtCodbarras, gbc_txtCodbarras);
		txtCodbarras.setColumns(10);

		JLabel lblValorPagar = new JLabel("Valor");
		lblValorPagar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblValorPagar = new GridBagConstraints();
		gbc_lblValorPagar.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorPagar.anchor = GridBagConstraints.WEST;
		gbc_lblValorPagar.gridx = 3;
		gbc_lblValorPagar.gridy = 3;
		panel.add(lblValorPagar, gbc_lblValorPagar);
		txtValorPag = new JFormattedTextField();
		((JFormattedTextField) txtValorPag)
				.setFormatterFactory(new DefaultFormatterFactory(formatter));
		txtValorPag.setText(new DecimalFormat("R$ #,##0.00").format(0.00));
		GridBagConstraints gbc_txtValorPag = new GridBagConstraints();
		gbc_txtValorPag.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtValorPag.insets = new Insets(0, 0, 5, 5);
		gbc_txtValorPag.gridx = 3;
		gbc_txtValorPag.gridy = 4;
		panel.add(txtValorPag, gbc_txtValorPag);
		txtValorPag.setColumns(10);

		JButton btnConfirmarPagamento = new JButton("Pagar");
		btnConfirmarPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtValorPag.getText().equals("")
						|| txtCodbarras.getText().equals("")) {
					JOptionPane
							.showMessageDialog(
									RealizarPagamento.this,
									"Informe o codigo de barras e o valor do documento.",
									"Erro", JOptionPane.WARNING_MESSAGE);
					txtCodbarras.requestFocus();
				} else {

					BigDecimal valorPag = new BigDecimal(txtValorPag.getText()
							.replace(".", "").replace(",", "."));

					txtCodbarras.setText("");
					txtValorPag.setText("0.00");

					new Teclado(conta, valorPag, null, TipoOperacao.PAGAMENTO,
							txtCodbarras.getText(), null).setVisible(true);
				}
			}
		});
		GridBagConstraints gbc_btnConfirmarPagamento = new GridBagConstraints();
		gbc_btnConfirmarPagamento.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfirmarPagamento.fill = GridBagConstraints.VERTICAL;
		gbc_btnConfirmarPagamento.gridx = 3;
		gbc_btnConfirmarPagamento.gridy = 5;
		panel.add(btnConfirmarPagamento, gbc_btnConfirmarPagamento);

	}

	@Override
	public void contaAlterada(Conta conta) {
		MainCliente.populaTelaInfConta(conta);
	}

	@Override
	public void deposito(Conta conta, BigDecimal valorDeposito) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean saque(Conta conta, BigDecimal valorSaque,
			String senhaInformada) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean transferencia(Conta conta, Conta contaRecebeTransf,
			BigDecimal valorTransf) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void finalizarConta(Conta conta) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean pagamento(Conta conta, BigDecimal valorPagamento,
			String codigoDeBarras) {
		// TODO Auto-generated method stub
		return false;
	}

}
