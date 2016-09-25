package sb.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import sb.model.Conta;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class TelaSaque extends PadraoCliente {

	private JPanel contentPane;
	private JTextField txtValor;

	public TelaSaque(final Conta conta) {
		super(conta);
		setTitle("Saque");
		setResizable(false);
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane().getLayout();
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0 };

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 4;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 253, -19, 239, 0, 82, 0 };
		gbl_panel.rowHeights = new int[] { 63, 63, 6, 48, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JButton btnValor = new JButton("R$ 50,00");
		btnValor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Teclado senhaConfirme = new Teclado(conta, new BigDecimal(50.00));
				senhaConfirme.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnCinquenta = new GridBagConstraints();
		gbc_btnCinquenta.fill = GridBagConstraints.BOTH;
		gbc_btnCinquenta.insets = new Insets(0, 0, 5, 5);
		gbc_btnCinquenta.gridx = 0;
		gbc_btnCinquenta.gridy = 0;
		panel.add(btnValor, gbc_btnCinquenta);

		JButton btnCem = new JButton("R$ 100,00");
		btnCem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Teclado senhaConfirme = new Teclado(conta, new BigDecimal(100.00));
				senhaConfirme.setVisible(true);
			}
		});
		
		GridBagConstraints gbc_btnCem = new GridBagConstraints();
		gbc_btnCem.fill = GridBagConstraints.BOTH;
		gbc_btnCem.insets = new Insets(0, 0, 5, 5);
		gbc_btnCem.gridx = 2;
		gbc_btnCem.gridy = 0;
		panel.add(btnCem, gbc_btnCem);

		JButton btnDuzentos = new JButton("R$ 200,00");
		btnDuzentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Teclado senhaConfirme = new Teclado(conta, new BigDecimal(200.00));
				senhaConfirme.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnDuzentos = new GridBagConstraints();
		gbc_btnDuzentos.fill = GridBagConstraints.BOTH;
		gbc_btnDuzentos.insets = new Insets(0, 0, 5, 5);
		gbc_btnDuzentos.gridx = 0;
		gbc_btnDuzentos.gridy = 1;
		panel.add(btnDuzentos, gbc_btnDuzentos);

		JButton btnTrezentos = new JButton("R$ 300,00");
		btnTrezentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Teclado senhaConfirme = new Teclado(conta, new BigDecimal(300.00));
				senhaConfirme.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnTrezentos = new GridBagConstraints();
		gbc_btnTrezentos.fill = GridBagConstraints.BOTH;
		gbc_btnTrezentos.insets = new Insets(0, 0, 5, 5);
		gbc_btnTrezentos.gridx = 2;
		gbc_btnTrezentos.gridy = 1;
		panel.add(btnTrezentos, gbc_btnTrezentos);

		JButton btnQuinhentos = new JButton("R$ 500,00");
		btnQuinhentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Teclado senhaConfirme = new Teclado(conta, new BigDecimal(100.00));
				senhaConfirme.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnQuinhentos = new GridBagConstraints();
		gbc_btnQuinhentos.fill = GridBagConstraints.BOTH;
		gbc_btnQuinhentos.insets = new Insets(0, 0, 0, 5);
		gbc_btnQuinhentos.gridheight = 2;
		gbc_btnQuinhentos.gridx = 0;
		gbc_btnQuinhentos.gridy = 2;
		panel.add(btnQuinhentos, gbc_btnQuinhentos);

		JLabel lblNewValor = new JLabel("Informe valor:");
		lblNewValor.setEnabled(false);
		GridBagConstraints gbc_lblNewValor = new GridBagConstraints();
		gbc_lblNewValor.anchor = GridBagConstraints.NORTH;
		gbc_lblNewValor.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewValor.gridx = 2;
		gbc_lblNewValor.gridy = 2;
		panel.add(lblNewValor, gbc_lblNewValor);

		DecimalFormat dFormat = new DecimalFormat("#,###,###.00");
		NumberFormatter formatter = new NumberFormatter(dFormat);
		formatter.setFormat(dFormat);
		formatter.setAllowsInvalid(false);
		txtValor = new JFormattedTextField();
		((JFormattedTextField) txtValor).setFormatterFactory(new DefaultFormatterFactory(formatter));
		txtValor.setText(new DecimalFormat("R$ #,##0.00").format(0.00));
		GridBagConstraints gbc_txtValor = new GridBagConstraints();
		gbc_txtValor.fill = GridBagConstraints.BOTH;
		gbc_txtValor.insets = new Insets(0, 0, 0, 5);
		gbc_txtValor.gridx = 2;
		gbc_txtValor.gridy = 3;
		panel.add(txtValor, gbc_txtValor);
		txtValor.setColumns(10);
						
								JButton btnSacar = new JButton("Sacar");
								btnSacar.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										
										if (txtValor.getText().equals("0.00")) {
											JOptionPane.showMessageDialog(TelaSaque.this, "Informe um valor para reaizar o saque!!!", "Atenção",
													JOptionPane.WARNING_MESSAGE);
										} else {

											new Teclado(conta, new BigDecimal(txtValor.getText()));
										}

									}
								});
								GridBagConstraints gbc_btnSacar = new GridBagConstraints();
								gbc_btnSacar.gridwidth = 2;
								gbc_btnSacar.insets = new Insets(0, 0, 0, 5);
								gbc_btnSacar.fill = GridBagConstraints.BOTH;
								gbc_btnSacar.gridx = 3;
								gbc_btnSacar.gridy = 3;
								panel.add(btnSacar, gbc_btnSacar);

	}
}
