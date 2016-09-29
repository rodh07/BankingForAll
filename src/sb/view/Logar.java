package sb.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import sb.controller.ContaController;
import sb.controller.UsuarioController;
import sb.classificacoes.ClassificacaoUsuario;
import sb.model.Conta;
import sb.view.MainBancario;
import sb.view.MainCliente;

public class Logar extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JComboBox cbmAcesso;
	private JLabel lblNomeBanco;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logar login = new Logar();
					login.setVisible(true);
					login.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Logar() {
		setResizable(false);
		setTitle("Banking For All!!!");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./Icones/Play.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 254, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 203, 0 };
		gbl_contentPane.rowHeights = new int[] { 53, 20, 20, 23, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		lblNomeBanco = new JLabel("Banking For All");
		lblNomeBanco.setForeground(Color.BLACK);
		lblNomeBanco.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNomeBanco = new GridBagConstraints();
		gbc_lblNomeBanco.insets = new Insets(0, 0, 5, 0);
		gbc_lblNomeBanco.gridx = 0;
		gbc_lblNomeBanco.gridy = 0;
		contentPane.add(lblNomeBanco, gbc_lblNomeBanco);

		txtLogin = new JTextField("admin");
		txtLogin.setToolTipText("Usu\u00E1rio");
		GridBagConstraints gbc_txtLogin = new GridBagConstraints();
		gbc_txtLogin.anchor = GridBagConstraints.NORTH;
		gbc_txtLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLogin.insets = new Insets(0, 0, 5, 0);
		gbc_txtLogin.gridx = 0;
		gbc_txtLogin.gridy = 1;
		contentPane.add(txtLogin, gbc_txtLogin);
		txtLogin.setColumns(10);

		txtSenha = new JTextField("admin");
		txtSenha.setToolTipText("Senha");
		txtSenha.setColumns(10);
		GridBagConstraints gbc_txtSenha = new GridBagConstraints();
		gbc_txtSenha.anchor = GridBagConstraints.NORTH;
		gbc_txtSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSenha.insets = new Insets(0, 0, 5, 0);
		gbc_txtSenha.gridx = 0;
		gbc_txtSenha.gridy = 2;
		contentPane.add(txtSenha, gbc_txtSenha);

		JButton btnLogin = new JButton("Login");
		btnLogin.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					acessoBankingForAll();
				}
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				acessoBankingForAll();
			}

		});

		cbmAcesso = new JComboBox(ClassificacaoUsuario.values());
		GridBagConstraints gbc_cbmAcesso = new GridBagConstraints();
		gbc_cbmAcesso.insets = new Insets(0, 0, 5, 0);
		gbc_cbmAcesso.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbmAcesso.gridx = 0;
		gbc_cbmAcesso.gridy = 3;
		contentPane.add(cbmAcesso, gbc_cbmAcesso);
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLogin.anchor = GridBagConstraints.NORTH;
		gbc_btnLogin.gridx = 0;
		gbc_btnLogin.gridy = 4;
		contentPane.add(btnLogin, gbc_btnLogin);
	}

	protected void limpaCampos() {

		txtLogin.setText("");
		txtSenha.setText("");
		cbmAcesso.setSelectedIndex(0);
	}

	protected void acessoBankingForAll() {

		UsuarioController usuarioController = new UsuarioController();
		String usuario = txtLogin.getText().trim();
		String senha = txtSenha.getText().trim();
		ClassificacaoUsuario tipoUsuario = (ClassificacaoUsuario) cbmAcesso.getSelectedItem();

		boolean logar = usuarioController.acessoLogin(usuario, senha, tipoUsuario);

		if (logar && tipoUsuario == ClassificacaoUsuario.BANCARIO) {

			MainBancario main = new MainBancario();
			main.setVisible(true);
			setVisible(false);

		} else if (logar && tipoUsuario == ClassificacaoUsuario.CLIENTE) {
			Conta conta = new ContaController().get(usuario, senha);
			MainCliente mainCliente = new MainCliente(conta);
			JOptionPane.showMessageDialog(Logar.this, "Bem vindo ao sistema do Banking For All!!!");
			mainCliente.setVisible(true);
			setVisible(false);
		} else {
			JOptionPane.showMessageDialog(Logar.this, "Dados incorretos, tente novamente!!!");
			limpaCampos();
		}
	}
}
