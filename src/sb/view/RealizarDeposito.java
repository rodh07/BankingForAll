package sb.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import sb.classificacoes.TipoConta;
import sb.controller.ContaController;
import sb.model.Conta;

public class RealizarDeposito extends CabecalhoCliente {

	private JPanel contentPane;
	private JTextField txtAgencia;
	private JTextField txtConta;
	private JTextField txtTitular;
	private JTextField txtValorDeposito;
	private JCheckBox contaLogada;
	private Conta conta;
	private JComboBox cmbTipoConta;

	public RealizarDeposito(final Conta conta) {
		super(conta);
		this.conta = conta;
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane()
				.getLayout();
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0 };
		setTitle("Dep�sito");
		setLocationRelativeTo(null);
		setResizable(false);

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
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblAg = new JLabel("AG:");
		GridBagConstraints gbc_lblAg = new GridBagConstraints();
		gbc_lblAg.anchor = GridBagConstraints.WEST;
		gbc_lblAg.insets = new Insets(0, 0, 5, 5);
		gbc_lblAg.gridx = 1;
		gbc_lblAg.gridy = 0;
		panel.add(lblAg, gbc_lblAg);

		JLabel lblNewLabel = new JLabel("Conta:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblInformeOValor = new JLabel(
				"Informe o valor a ser depositado:");
		GridBagConstraints gbc_lblInformeOValor = new GridBagConstraints();
		gbc_lblInformeOValor.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformeOValor.gridx = 4;
		gbc_lblInformeOValor.gridy = 0;
		panel.add(lblInformeOValor, gbc_lblInformeOValor);

		txtAgencia = new JTextField();
		txtAgencia.setToolTipText("Agencia da conta");
		GridBagConstraints gbc_txtAgencia = new GridBagConstraints();
		gbc_txtAgencia.insets = new Insets(0, 0, 5, 5);
		gbc_txtAgencia.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAgencia.gridx = 1;
		gbc_txtAgencia.gridy = 1;
		panel.add(txtAgencia, gbc_txtAgencia);
		txtAgencia.setColumns(10);

		txtConta = new JTextField();
		txtConta.setToolTipText("Conta a ser depositado");
		GridBagConstraints gbc_txtConta = new GridBagConstraints();
		gbc_txtConta.insets = new Insets(0, 0, 5, 5);
		gbc_txtConta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtConta.gridx = 2;
		gbc_txtConta.gridy = 1;
		panel.add(txtConta, gbc_txtConta);
		txtConta.setColumns(10);
		txtValorDeposito = new JFormattedTextField();
		((JFormattedTextField) txtValorDeposito)
				.setFormatterFactory(new DefaultFormatterFactory());
		txtValorDeposito.setText(new DecimalFormat("R$ #,##0.00").format(0.00));
		txtValorDeposito.setToolTipText("Valor a ser depositado na conta");
		GridBagConstraints gbc_txtValorDeposito = new GridBagConstraints();
		gbc_txtValorDeposito.insets = new Insets(0, 0, 5, 5);
		gbc_txtValorDeposito.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtValorDeposito.gridx = 4;
		gbc_txtValorDeposito.gridy = 1;
		panel.add(txtValorDeposito, gbc_txtValorDeposito);
		txtValorDeposito.setColumns(10);

		JLabel lblTipoConta = new JLabel("Tipo Conta");
		GridBagConstraints gbc_lblTipoConta = new GridBagConstraints();
		gbc_lblTipoConta.anchor = GridBagConstraints.WEST;
		gbc_lblTipoConta.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoConta.gridx = 1;
		gbc_lblTipoConta.gridy = 2;
		panel.add(lblTipoConta, gbc_lblTipoConta);

		DecimalFormat dFormat = new DecimalFormat("#,###,###.00");
		NumberFormatter formatter = new NumberFormatter(dFormat);
		formatter.setFormat(dFormat);
		formatter.setAllowsInvalid(false);

		cmbTipoConta = new JComboBox(TipoConta.values());
		cmbTipoConta.setToolTipText("Tipo da conta aonde ser depositado");
		GridBagConstraints gbc_cmbTipoConta = new GridBagConstraints();
		gbc_cmbTipoConta.insets = new Insets(0, 0, 5, 5);
		gbc_cmbTipoConta.gridwidth = 2;
		gbc_cmbTipoConta.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbTipoConta.gridx = 1;
		gbc_cmbTipoConta.gridy = 3;
		panel.add(cmbTipoConta, gbc_cmbTipoConta);

		JLabel lblTitular = new JLabel("Titular");
		GridBagConstraints gbc_lblTitular = new GridBagConstraints();
		gbc_lblTitular.anchor = GridBagConstraints.WEST;
		gbc_lblTitular.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitular.gridx = 1;
		gbc_lblTitular.gridy = 4;
		panel.add(lblTitular, gbc_lblTitular);

		txtTitular = new JTextField();
		txtTitular.setToolTipText("Titular da conta a ser depositado");
		GridBagConstraints gbc_txtTitular = new GridBagConstraints();
		gbc_txtTitular.gridwidth = 2;
		gbc_txtTitular.insets = new Insets(0, 0, 5, 5);
		gbc_txtTitular.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTitular.gridx = 1;
		gbc_txtTitular.gridy = 5;
		panel.add(txtTitular, gbc_txtTitular);
		txtTitular.setColumns(10);

		contaLogada = new JCheckBox("Conta logada");
		contaLogada.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (contaLogada.isSelected()) {
					validaContaDeposito(contaLogada);
				} else {
					validaContaDeposito(contaLogada);
				}

			}
		});
		GridBagConstraints gbc_chckbxContaLogada = new GridBagConstraints();
		gbc_chckbxContaLogada.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxContaLogada.gridx = 1;
		gbc_chckbxContaLogada.gridy = 6;
		panel.add(contaLogada, gbc_chckbxContaLogada);

		validaContaDeposito(contaLogada);

		JButton btnDepositar = new JButton("Depositar");
		btnDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (txtAgencia.getText().equals("")
						|| txtConta.getText().equals("")
						|| txtTitular.getText().equals("")
						|| txtValorDeposito.getText().equals("")) {
					JOptionPane
							.showMessageDialog(
									null,
									"Existem campos vazios. Preencha todos para realizar a��o!",
									"Aten��o", JOptionPane.WARNING_MESSAGE);
				} else {

					BigDecimal valorDeposito = new BigDecimal(txtValorDeposito
							.getText().replaceAll(",", "."));

					if (contaLogada.isSelected()) {
						new ContaController().deposito(conta, valorDeposito);
						limparCampos();
						contaLogada.setSelected(false);

					} else {
						Conta contaDeposito = new Conta();
						contaDeposito.setAgencia(txtAgencia.getText().trim());
						contaDeposito.setNome(txtTitular.getText().trim());
						contaDeposito.setNumeroConta(txtConta.getText().trim());
						limparCampos();
						cmbTipoConta.setEnabled(true);
						new ContaController().deposito(contaDeposito,
								valorDeposito);
					}
				}
			}
		});
		GridBagConstraints gbc_btnDepositar = new GridBagConstraints();
		gbc_btnDepositar.fill = GridBagConstraints.BOTH;
		gbc_btnDepositar.gridheight = 2;
		gbc_btnDepositar.insets = new Insets(0, 0, 0, 5);
		gbc_btnDepositar.gridx = 4;
		gbc_btnDepositar.gridy = 6;
		panel.add(btnDepositar, gbc_btnDepositar);

	}

	public void validaContaDeposito(JCheckBox ckbContaLogada) {

		if (ckbContaLogada.isSelected()) {

			txtAgencia.setText(conta.getAgencia());
			txtAgencia.setEnabled(false);
			txtConta.setText(conta.getNumeroConta());
			txtConta.setEnabled(false);
			txtTitular.setText(conta.getNome());
			txtTitular.setEnabled(false);
			cmbTipoConta.setSelectedItem(validaTipoConta(conta.getTipoConta()));
			cmbTipoConta.setEnabled(false);
		} else {
			limparCampos();
		}
	}
	private Object validaTipoConta(final String tipoConta) {
		switch (tipoConta) {
		case MainCliente.CONTA_CORRENTE:
			return TipoConta.CC;
		case MainCliente.CONTA_POUPANCA:
			return TipoConta.CP;
		case MainCliente.CONTA_ELETRONICA:
			return TipoConta.CE;
		default:
			break;
		}
		return TipoConta.CE;
	}

	private void limparCampos() {
		txtAgencia.setEnabled(true);
		txtAgencia.setText("");
		txtConta.setEnabled(true);
		txtConta.setText("");
		txtTitular.setEnabled(true);
		txtTitular.setText("");
		cmbTipoConta.setEnabled(true);
		cmbTipoConta.setSelectedItem(TipoConta.CC);
		txtValorDeposito.setText("00.00");

	}
}
