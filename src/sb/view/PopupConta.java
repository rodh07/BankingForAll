package sb.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import sb.controller.ContaController;
import sb.model.Conta;

import java.awt.Font;

public class PopupConta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAgencia;
	private JTextField txtConta;
	private JTextField txtTitular;

	@SuppressWarnings("unchecked")
	public PopupConta() {
		setTitle("Popup Conta");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Seven\\git\\BankingForAll\\Icones\\Play.png"));
		setBounds(100, 100, 274, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 27, 82, 116, 0, 0 };
		gbl_panel.rowHeights = new int[] { 17, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblAg = new JLabel("Agencia");
		lblAg.setForeground(Color.BLACK);
		GridBagConstraints gbc_lblAg = new GridBagConstraints();
		gbc_lblAg.anchor = GridBagConstraints.WEST;
		gbc_lblAg.insets = new Insets(0, 0, 5, 5);
		gbc_lblAg.gridx = 1;
		gbc_lblAg.gridy = 1;
		panel.add(lblAg, gbc_lblAg);

		JLabel lblConta = new JLabel("Conta");
		lblConta.setForeground(Color.BLACK);
		GridBagConstraints gbc_lblConta = new GridBagConstraints();
		gbc_lblConta.anchor = GridBagConstraints.WEST;
		gbc_lblConta.insets = new Insets(0, 0, 5, 5);
		gbc_lblConta.gridx = 2;
		gbc_lblConta.gridy = 1;
		panel.add(lblConta, gbc_lblConta);

		try {
			txtAgencia = new JFormattedTextField(new MaskFormatter("#####-##"));
			GridBagConstraints gbc_txtAgencia = new GridBagConstraints();
			gbc_txtAgencia.insets = new Insets(0, 0, 5, 5);
			gbc_txtAgencia.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtAgencia.gridx = 1;
			gbc_txtAgencia.gridy = 2;
			panel.add(txtAgencia, gbc_txtAgencia);
			txtAgencia.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			txtConta = new JFormattedTextField(new MaskFormatter("#####-##"));
			GridBagConstraints gbc_txtConta = new GridBagConstraints();
			gbc_txtConta.insets = new Insets(0, 0, 5, 5);
			gbc_txtConta.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtConta.gridx = 2;
			gbc_txtConta.gridy = 2;
			panel.add(txtConta, gbc_txtConta);
			txtConta.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JLabel lblTipoConta = new JLabel("Tipo Conta");
		lblTipoConta.setForeground(Color.BLACK);
		GridBagConstraints gbc_lblTipoConta = new GridBagConstraints();
		gbc_lblTipoConta.anchor = GridBagConstraints.WEST;
		gbc_lblTipoConta.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoConta.gridx = 1;
		gbc_lblTipoConta.gridy = 3;
		panel.add(lblTipoConta, gbc_lblTipoConta);

		@SuppressWarnings("rawtypes")
		final JComboBox cmbTipoConta = new JComboBox(
				sb.classificacoes.TipoConta.values());
		cmbTipoConta.setForeground(Color.BLACK);
		GridBagConstraints gbc_cmbTipoConta = new GridBagConstraints();
		gbc_cmbTipoConta.insets = new Insets(0, 0, 5, 5);
		gbc_cmbTipoConta.gridwidth = 2;
		gbc_cmbTipoConta.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbTipoConta.gridx = 1;
		gbc_cmbTipoConta.gridy = 4;
		panel.add(cmbTipoConta, gbc_cmbTipoConta);

		JLabel lblTitular = new JLabel("Titular");
		lblTitular.setForeground(Color.BLACK);
		GridBagConstraints gbc_lblTitular = new GridBagConstraints();
		gbc_lblTitular.anchor = GridBagConstraints.WEST;
		gbc_lblTitular.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitular.gridx = 1;
		gbc_lblTitular.gridy = 5;
		panel.add(lblTitular, gbc_lblTitular);

		txtTitular = new JTextField();
		GridBagConstraints gbc_txtTitular = new GridBagConstraints();
		gbc_txtTitular.insets = new Insets(0, 0, 5, 5);
		gbc_txtTitular.gridwidth = 2;
		gbc_txtTitular.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTitular.gridx = 1;
		gbc_txtTitular.gridy = 6;
		panel.add(txtTitular, gbc_txtTitular);
		txtTitular.setColumns(10);

		JButton btnSelecaoConta = new JButton("Selecionar Conta");
		btnSelecaoConta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSelecaoConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String agencia = txtAgencia.getText().replace("-", "");
				String numeroConta = txtConta.getText().replace("-", "");
				String tipoConta = cmbTipoConta.getSelectedItem().toString();
				String titular = txtTitular.getText().trim();

				Conta conta = new ContaController().contaBancario(agencia,
						numeroConta, tipoConta, titular);
				if (conta != null) {
					new MainCliente(conta).setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null,
							"Erro na selecao da conta!");
				}
			}
		});
		btnSelecaoConta.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnSelecaoConta = new GridBagConstraints();
		gbc_btnSelecaoConta.gridheight = 2;
		gbc_btnSelecaoConta.gridwidth = 2;
		gbc_btnSelecaoConta.insets = new Insets(0, 0, 0, 5);
		gbc_btnSelecaoConta.fill = GridBagConstraints.BOTH;
		gbc_btnSelecaoConta.gridx = 1;
		gbc_btnSelecaoConta.gridy = 7;
		panel.add(btnSelecaoConta, gbc_btnSelecaoConta);
	}

}
