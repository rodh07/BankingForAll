package sb.view;

import javax.swing.JPanel;

import sb.classificacoes.TipoOperacao;
import sb.model.Conta;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class OperacaoConfirmada extends CabecalhoCliente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblValor;
	private JLabel lblOperacaoRealizada;
	private TipoOperacao operacao;
	private BigDecimal vlrOperacao;

	public OperacaoConfirmada(final Conta conta, TipoOperacao operacao,
			BigDecimal vlrOperacao) {
		super(conta);
		this.operacao = operacao;
		this.vlrOperacao = vlrOperacao;
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Opera��o " + operacao.getTipoDeOperacao()
				+ " realizada com sucesso");
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane()
				.getLayout();
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0 };

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 58, 59, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblOperacaoRealizada = new JLabel("");
		lblOperacaoRealizada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblOperacaoRealizada = new GridBagConstraints();
		gbc_lblOperacaoRealizada.gridwidth = 17;
		gbc_lblOperacaoRealizada.insets = new Insets(0, 0, 5, 0);
		gbc_lblOperacaoRealizada.gridx = 0;
		gbc_lblOperacaoRealizada.gridy = 1;
		panel.add(lblOperacaoRealizada, gbc_lblOperacaoRealizada);

		JLabel lblInformVlr = new JLabel("Valor:");
		lblInformVlr.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblInformVlr = new GridBagConstraints();
		gbc_lblInformVlr.anchor = GridBagConstraints.EAST;
		gbc_lblInformVlr.gridwidth = 2;
		gbc_lblInformVlr.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformVlr.gridx = 5;
		gbc_lblInformVlr.gridy = 2;
		panel.add(lblInformVlr, gbc_lblInformVlr);

		lblValor = new JLabel("");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblValor = new GridBagConstraints();
		gbc_lblValor.anchor = GridBagConstraints.WEST;
		gbc_lblValor.gridwidth = 3;
		gbc_lblValor.insets = new Insets(0, 0, 5, 5);
		gbc_lblValor.gridx = 7;
		gbc_lblValor.gridy = 2;
		panel.add(lblValor, gbc_lblValor);

		JButton btnRetornar = new JButton("Retornar");
		btnRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainCliente(conta).setVisible(true);
			}
		});
		GridBagConstraints gbc_btnRetornar = new GridBagConstraints();
		gbc_btnRetornar.anchor = GridBagConstraints.WEST;
		gbc_btnRetornar.insets = new Insets(0, 0, 5, 5);
		gbc_btnRetornar.gridx = 8;
		gbc_btnRetornar.gridy = 3;
		panel.add(btnRetornar, gbc_btnRetornar);

		setInformacoes();

	}

	private void setInformacoes() {

		lblOperacaoRealizada.setText("Opera��o " + operacao.getTipoDeOperacao()
				+ " realizada com sucesso");
		lblValor.setText(NumberFormat.getCurrencyInstance().format(vlrOperacao));

	}

	@Override
	public void contaAlterada(Conta conta) {

		CabecalhoCliente.populaTelaInfConta(conta);

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
