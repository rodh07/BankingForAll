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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import sb.classificacoes.TipoOperacao;
import sb.model.Conta;

public class RealizarPagamento extends CabecalhoCliente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCodbarras;
	private JTextField txtValorPag;

	/**
	 * Create the frame.
	 */
	public RealizarPagamento(final Conta conta) {
		super(conta);
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane().getLayout();
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
		gbl_panel.columnWidths = new int[] { 0, 0, 313, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblCdigoDeBarras = new JLabel("C\u00F3digo de Barras");
		GridBagConstraints gbc_lblCdigoDeBarras = new GridBagConstraints();
		gbc_lblCdigoDeBarras.anchor = GridBagConstraints.WEST;
		gbc_lblCdigoDeBarras.insets = new Insets(0, 0, 5, 0);
		gbc_lblCdigoDeBarras.gridx = 2;
		gbc_lblCdigoDeBarras.gridy = 1;
		panel.add(lblCdigoDeBarras, gbc_lblCdigoDeBarras);

		txtCodbarras = new JTextField();
		GridBagConstraints gbc_txtCodbarras = new GridBagConstraints();
		gbc_txtCodbarras.insets = new Insets(0, 0, 5, 0);
		gbc_txtCodbarras.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodbarras.gridx = 2;
		gbc_txtCodbarras.gridy = 2;
		panel.add(txtCodbarras, gbc_txtCodbarras);
		txtCodbarras.setColumns(10);

		JLabel lblValaorASer = new JLabel("Valaor a ser pago");
		GridBagConstraints gbc_lblValaorASer = new GridBagConstraints();
		gbc_lblValaorASer.insets = new Insets(0, 0, 5, 0);
		gbc_lblValaorASer.anchor = GridBagConstraints.WEST;
		gbc_lblValaorASer.gridx = 2;
		gbc_lblValaorASer.gridy = 3;
		panel.add(lblValaorASer, gbc_lblValaorASer);

		DecimalFormat dFormat = new DecimalFormat("#,###,###.00");
		NumberFormatter formatter = new NumberFormatter(dFormat);
		formatter.setFormat(dFormat);
		formatter.setAllowsInvalid(false);
		txtValorPag = new JFormattedTextField();
		((JFormattedTextField) txtValorPag).setFormatterFactory(new DefaultFormatterFactory(formatter));
		txtValorPag.setText(new DecimalFormat("R$ #,##0.00").format(0.00));
		GridBagConstraints gbc_txtValorPag = new GridBagConstraints();
		gbc_txtValorPag.insets = new Insets(0, 0, 5, 0);
		gbc_txtValorPag.anchor = GridBagConstraints.WEST;
		gbc_txtValorPag.gridx = 2;
		gbc_txtValorPag.gridy = 4;
		panel.add(txtValorPag, gbc_txtValorPag);
		txtValorPag.setColumns(10);

		JButton btnConfirme = new JButton("Confirme");
		btnConfirme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BigDecimal valorPag = new BigDecimal(txtValorPag.getText().replace(".", "").replace(",", "."));

				txtCodbarras.setText("");
				txtValorPag.setText("0.00");

				new Teclado(conta, valorPag, null, TipoOperacao.PAGAMENTO, txtCodbarras.getText()).setVisible(true);

			}
		});
		GridBagConstraints gbc_btnConfirme = new GridBagConstraints();
		gbc_btnConfirme.insets = new Insets(0, 0, 5, 0);
		gbc_btnConfirme.anchor = GridBagConstraints.EAST;
		gbc_btnConfirme.gridx = 2;
		gbc_btnConfirme.gridy = 5;
		panel.add(btnConfirme, gbc_btnConfirme);

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
