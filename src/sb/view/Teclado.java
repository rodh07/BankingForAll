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

import sb.classificacoes.tipoOperacao;
import sb.model.Conta;

import java.awt.Font;


public class Teclado extends JFrame {

	private JPanel contentPane;
	private JTextField txtSenha;

	public Teclado(Conta conta, BigDecimal valor, Conta contaTransferir, tipoOperacao operacao, String codBarras) {
		setSize(176, 238);
		setTitle("Senha");
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("./Imagens/Play.png"));

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 24, 7, 39, 39, 45, 19, 39, 0 };
		gbl_panel.rowHeights = new int[] { 32, 24, 25, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("TECLADO VIRTUAL");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
												
		txtSenha = new JTextField();
		GridBagConstraints gbc_txtSenha = new GridBagConstraints();
		gbc_txtSenha.gridwidth = 3;
		gbc_txtSenha.fill = GridBagConstraints.BOTH;
		gbc_txtSenha.insets = new Insets(0, 0, 5, 5);
		gbc_txtSenha.gridx = 2;
		gbc_txtSenha.gridy = 1;
		panel.add(txtSenha, gbc_txtSenha);
		txtSenha.setColumns(10);
		txtSenha.requestFocus();
										
		JButton btnSete = new JButton("7");
						GridBagConstraints gbc_btnSete = new GridBagConstraints();
						gbc_btnSete.anchor = GridBagConstraints.NORTHWEST;
						gbc_btnSete.insets = new Insets(0, 0, 5, 5);
						gbc_btnSete.gridx = 2;
						gbc_btnSete.gridy = 2;
						panel.add(btnSete, gbc_btnSete);
								
										JButton btnOito = new JButton("8");
										GridBagConstraints gbc_btnOito = new GridBagConstraints();
										gbc_btnOito.anchor = GridBagConstraints.NORTHWEST;
										gbc_btnOito.insets = new Insets(0, 0, 5, 5);
										gbc_btnOito.gridx = 3;
										gbc_btnOito.gridy = 2;
										panel.add(btnOito, gbc_btnOito);
														
																JButton btnNove = new JButton("9");
																GridBagConstraints gbc_btnNove = new GridBagConstraints();
																gbc_btnNove.insets = new Insets(0, 0, 5, 5);
																gbc_btnNove.anchor = GridBagConstraints.NORTHWEST;
																gbc_btnNove.gridx = 4;
																gbc_btnNove.gridy = 2;
																panel.add(btnNove, gbc_btnNove);
												
														JButton btnQuatro = new JButton("4");
														GridBagConstraints gbc_btnQuatro = new GridBagConstraints();
														gbc_btnQuatro.anchor = GridBagConstraints.WEST;
														gbc_btnQuatro.insets = new Insets(0, 0, 5, 5);
														gbc_btnQuatro.gridx = 2;
														gbc_btnQuatro.gridy = 3;
														panel.add(btnQuatro, gbc_btnQuatro);
										
												JButton btnCinco = new JButton("5");
												GridBagConstraints gbc_btnCinco = new GridBagConstraints();
												gbc_btnCinco.anchor = GridBagConstraints.NORTHWEST;
												gbc_btnCinco.insets = new Insets(0, 0, 5, 5);
												gbc_btnCinco.gridx = 3;
												gbc_btnCinco.gridy = 3;
												panel.add(btnCinco, gbc_btnCinco);
												
														JButton btnSeis = new JButton("6");
														GridBagConstraints gbc_btnSeis = new GridBagConstraints();
														gbc_btnSeis.anchor = GridBagConstraints.NORTHWEST;
														gbc_btnSeis.insets = new Insets(0, 0, 5, 5);
														gbc_btnSeis.gridx = 4;
														gbc_btnSeis.gridy = 3;
														panel.add(btnSeis, gbc_btnSeis);
																
																		JButton btnUm = new JButton("1");
																		GridBagConstraints gbc_btnUm = new GridBagConstraints();
																		gbc_btnUm.anchor = GridBagConstraints.WEST;
																		gbc_btnUm.insets = new Insets(0, 0, 5, 5);
																		gbc_btnUm.gridx = 2;
																		gbc_btnUm.gridy = 4;
																		panel.add(btnUm, gbc_btnUm);
														
																JButton btnDois = new JButton("2");
																GridBagConstraints gbc_btnDois = new GridBagConstraints();
																gbc_btnDois.anchor = GridBagConstraints.WEST;
																gbc_btnDois.insets = new Insets(0, 0, 5, 5);
																gbc_btnDois.gridx = 3;
																gbc_btnDois.gridy = 4;
																panel.add(btnDois, gbc_btnDois);
														
																JButton btnTres = new JButton("3");
																GridBagConstraints gbc_btnTres = new GridBagConstraints();
																gbc_btnTres.anchor = GridBagConstraints.WEST;
																gbc_btnTres.insets = new Insets(0, 0, 5, 5);
																gbc_btnTres.gridx = 4;
																gbc_btnTres.gridy = 4;
																panel.add(btnTres, gbc_btnTres);
														
														JButton button = new JButton("-");
														GridBagConstraints gbc_button = new GridBagConstraints();
														gbc_button.insets = new Insets(0, 0, 5, 5);
														gbc_button.gridx = 2;
														gbc_button.gridy = 5;
														panel.add(button, gbc_button);
												
														JButton btnZero = new JButton("0");
														GridBagConstraints gbc_btnZero = new GridBagConstraints();
														gbc_btnZero.anchor = GridBagConstraints.WEST;
														gbc_btnZero.insets = new Insets(0, 0, 5, 5);
														gbc_btnZero.gridx = 3;
														gbc_btnZero.gridy = 5;
														panel.add(btnZero, gbc_btnZero);
																		
																		JButton button_1 = new JButton("-");
																		GridBagConstraints gbc_button_1 = new GridBagConstraints();
																		gbc_button_1.anchor = GridBagConstraints.WEST;
																		gbc_button_1.insets = new Insets(0, 0, 5, 5);
																		gbc_button_1.gridx = 4;
																		gbc_button_1.gridy = 5;
																		panel.add(button_1, gbc_button_1);
																
																		JButton btnConfirmar = new JButton("Confirmar");
																		GridBagConstraints gbc_btnConfirmar = new GridBagConstraints();
																		gbc_btnConfirmar.gridwidth = 3;
																		gbc_btnConfirmar.anchor = GridBagConstraints.SOUTH;
																		gbc_btnConfirmar.gridheight = 2;
																		gbc_btnConfirmar.fill = GridBagConstraints.HORIZONTAL;
																		gbc_btnConfirmar.insets = new Insets(0, 0, 0, 5);
																		gbc_btnConfirmar.gridx = 2;
																		gbc_btnConfirmar.gridy = 6;
																		panel.add(btnConfirmar, gbc_btnConfirmar);

	}

	
}
