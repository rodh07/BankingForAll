package sb.view;

import javax.swing.JPanel;

import sb.classificacoes.tipoOperacao;
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

public class ConfirmacaoOperacao extends CabecalhoCliente {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblValor;
	private JLabel lblOperacao;
	private tipoOperacao operacao;
	private BigDecimal vlrOperacao;

	public ConfirmacaoOperacao(final Conta conta, tipoOperacao operacao,
			BigDecimal vlrOperacao) {
		super(conta);
		this.operacao = operacao;
		this.vlrOperacao = vlrOperacao;
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Operação " + operacao.getTipoDeOperacao()
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
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 58, 59, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblOperacao = new JLabel("");
		lblOperacao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblOperacao = new GridBagConstraints();
		gbc_lblOperacao.anchor = GridBagConstraints.WEST;
		gbc_lblOperacao.gridwidth = 18;
		gbc_lblOperacao.insets = new Insets(0, 0, 5, 0);
		gbc_lblOperacao.gridx = 3;
		gbc_lblOperacao.gridy = 2;
		panel.add(lblOperacao, gbc_lblOperacao);

		JLabel lblValue = new JLabel("Valor:");
		lblValue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblValue = new GridBagConstraints();
		gbc_lblValue.anchor = GridBagConstraints.EAST;
		gbc_lblValue.gridwidth = 2;
		gbc_lblValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblValue.gridx = 4;
		gbc_lblValue.gridy = 3;
		panel.add(lblValue, gbc_lblValue);

		lblValor = new JLabel("");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblValor = new GridBagConstraints();
		gbc_lblValor.anchor = GridBagConstraints.WEST;
		gbc_lblValor.gridwidth = 4;
		gbc_lblValor.insets = new Insets(0, 0, 5, 5);
		gbc_lblValor.gridx = 6;
		gbc_lblValor.gridy = 3;
		panel.add(lblValor, gbc_lblValor);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainCliente(conta).setVisible(true);
			}
		});
		GridBagConstraints gbc_btnVoltar = new GridBagConstraints();
		gbc_btnVoltar.anchor = GridBagConstraints.WEST;
		gbc_btnVoltar.insets = new Insets(0, 0, 0, 5);
		gbc_btnVoltar.gridx = 7;
		gbc_btnVoltar.gridy = 4;
		panel.add(btnVoltar, gbc_btnVoltar);

		setInformacoes();
	}
	
	private void setInformacoes() {

		lblOperacao.setText("Operação " + operacao.getTipoDeOperacao()
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
