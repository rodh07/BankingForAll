package sb.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sb.model.Conta;
//import sb.model.HorarioCorreto;


public abstract class PadraoCliente extends JFrame {

	private JPanel contentPane;
	protected JLabel lblDataAcess;
	private JLabel lblAgencia;
	private JLabel lblTipoConta;
	private JLabel lblNumConta;
	private JLabel lblSaldo;

	public JLabel getLblDataAcess() {
		return lblDataAcess;
	}

	protected void setLblDataAcess(String lblDataAcess) {
		this.lblDataAcess.setText(lblDataAcess);
	}

	public JLabel getLblAgencia() {
		return lblAgencia;
	}

	public void setLblAgencia(JLabel lblAgencia) {
		this.lblAgencia = lblAgencia;
	}

	public JLabel getLblTipoConta() {
		return lblTipoConta;
	}

	public void setLblTipoConta(JLabel lblTipoConta) {
		this.lblTipoConta = lblTipoConta;
	}

	public JLabel getLblNumConta() {
		return lblNumConta;
	}

	public void setLblNumConta(JLabel lblNumConta) {
		this.lblNumConta = lblNumConta;
	}

	public JLabel getLblSaldo() {
		return lblSaldo;
	}

	public void setLblSaldo(JLabel lblSaldo) {
		this.lblSaldo = lblSaldo;
	}

	public PadraoCliente(Conta conta) {
		setSize(800, 375);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 370);
		setIconImage(Toolkit.getDefaultToolkit().getImage("./Imagens/Icone.png"));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 77, 0, 414, 0 };
		gbl_contentPane.rowHeights = new int[] { 89, 253, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel cabecalho = new JPanel();
		cabecalho.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		GridBagConstraints gbc_cabecalho = new GridBagConstraints();
		gbc_cabecalho.gridwidth = 3;
		gbc_cabecalho.fill = GridBagConstraints.BOTH;
		gbc_cabecalho.insets = new Insets(0, 0, 5, 0);
		gbc_cabecalho.gridx = 0;
		gbc_cabecalho.gridy = 0;
		contentPane.add(cabecalho, gbc_cabecalho);
		GridBagLayout gbl_cabecalho = new GridBagLayout();
		gbl_cabecalho.columnWidths = new int[] { 94, 208, 90, 0 };
		gbl_cabecalho.rowHeights = new int[] { 67, 0, 0 };
		gbl_cabecalho.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_cabecalho.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		cabecalho.setLayout(gbl_cabecalho);

		JLabel lblNomeBanco = new JLabel("Banking For All");
		lblNomeBanco.setForeground(Color.BLACK);
		lblNomeBanco.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNomeBanco = new GridBagConstraints();
		gbc_lblNomeBanco.fill = GridBagConstraints.BOTH;
		gbc_lblNomeBanco.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeBanco.gridx = 1;
		gbc_lblNomeBanco.gridy = 0;
		cabecalho.add(lblNomeBanco, gbc_lblNomeBanco);

		lblDataAcess = new JLabel("");
		lblDataAcess.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDataAcess.setForeground(Color.BLACK);
		lblDataAcess.setText(HorarioCorreto());
		GridBagConstraints gbc_lblDataAcess = new GridBagConstraints();
		gbc_lblDataAcess.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDataAcess.insets = new Insets(0, 0, 5, 0);
		gbc_lblDataAcess.gridx = 2;
		gbc_lblDataAcess.gridy = 0;
		cabecalho.add(lblDataAcess, gbc_lblDataAcess);

		JLabel imagem = new JLabel("");
		imagem.setIcon(new ImageIcon("C:\\Users\\Help Desk\\Desktop\\BankingForAll\\Imagens\\Play.png"));
		GridBagConstraints gbc_imagem = new GridBagConstraints();
		gbc_imagem.gridheight = 2;
		gbc_imagem.insets = new Insets(0, 0, 0, 5);
		gbc_imagem.gridx = 0;
		gbc_imagem.gridy = 0;
		cabecalho.add(imagem, gbc_imagem);

		JLabel lblSubtitulo = new JLabel("It's free, go go!");
		lblSubtitulo.setForeground(Color.BLACK);
		lblSubtitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblSubtitulo = new GridBagConstraints();
		gbc_lblSubtitulo.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblSubtitulo.insets = new Insets(0, 0, 0, 5);
		gbc_lblSubtitulo.gridx = 1;
		gbc_lblSubtitulo.gridy = 1;
		cabecalho.add(lblSubtitulo, gbc_lblSubtitulo);

		JPanel panel = new JPanel();
		panel.setForeground(Color.GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 1;
		cabecalho.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 124, 25, 46, 0 };
		gbl_panel.rowHeights = new int[] { 26, 15, 10, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblAg = new JLabel("AG:");
		lblAg.setForeground(Color.BLACK);
		GridBagConstraints gbc_lblAg = new GridBagConstraints();
		gbc_lblAg.anchor = GridBagConstraints.WEST;
		gbc_lblAg.insets = new Insets(0, 0, 5, 5);
		gbc_lblAg.gridx = 1;
		gbc_lblAg.gridy = 0;
		panel.add(lblAg, gbc_lblAg);

		lblAgencia = new JLabel("");
		lblAgencia.setForeground(Color.BLACK);
		GridBagConstraints gbc_lblAgencia = new GridBagConstraints();
		gbc_lblAgencia.anchor = GridBagConstraints.WEST;
		gbc_lblAgencia.insets = new Insets(0, 0, 5, 0);
		gbc_lblAgencia.fill = GridBagConstraints.VERTICAL;
		gbc_lblAgencia.gridx = 2;
		gbc_lblAgencia.gridy = 0;
		panel.add(lblAgencia, gbc_lblAgencia);

		lblTipoConta = new JLabel("");
		lblTipoConta.setForeground(Color.BLACK);
		GridBagConstraints gbc_lblTipoConta = new GridBagConstraints();
		gbc_lblTipoConta.gridwidth = 2;
		gbc_lblTipoConta.anchor = GridBagConstraints.EAST;
		gbc_lblTipoConta.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoConta.gridx = 0;
		gbc_lblTipoConta.gridy = 1;
		panel.add(lblTipoConta, gbc_lblTipoConta);

		lblNumConta = new JLabel("");
		lblNumConta.setForeground(Color.BLACK);
		GridBagConstraints gbc_lblNumConta = new GridBagConstraints();
		gbc_lblNumConta.anchor = GridBagConstraints.WEST;
		gbc_lblNumConta.insets = new Insets(0, 0, 5, 0);
		gbc_lblNumConta.gridx = 2;
		gbc_lblNumConta.gridy = 1;
		panel.add(lblNumConta, gbc_lblNumConta);

		JLabel Saldo = new JLabel("Saldo:");
		Saldo.setForeground(Color.BLACK);
		GridBagConstraints gbc_Saldo = new GridBagConstraints();
		gbc_Saldo.anchor = GridBagConstraints.EAST;
		gbc_Saldo.insets = new Insets(0, 0, 0, 5);
		gbc_Saldo.gridx = 0;
		gbc_Saldo.gridy = 2;
		panel.add(Saldo, gbc_Saldo);

		JLabel lblR = new JLabel("R$");
		lblR.setForeground(Color.BLACK);
		GridBagConstraints gbc_lblR = new GridBagConstraints();
		gbc_lblR.anchor = GridBagConstraints.WEST;
		gbc_lblR.insets = new Insets(0, 0, 0, 5);
		gbc_lblR.gridx = 1;
		gbc_lblR.gridy = 2;
		panel.add(lblR, gbc_lblR);

		lblSaldo = new JLabel("");
		lblSaldo.setForeground(Color.BLACK);
		GridBagConstraints gbc_lblSaldo = new GridBagConstraints();
		gbc_lblSaldo.anchor = GridBagConstraints.WEST;
		gbc_lblSaldo.gridx = 2;
		gbc_lblSaldo.gridy = 2;
		panel.add(lblSaldo, gbc_lblSaldo);

		// populaTelaInfConta(conta);

	}

	private void populaTelaInfConta(Conta conta) {
		lblSaldo.setText(String.valueOf(conta.getSaldo()));
		lblNumConta.setText(conta.getNumeroConta());
		lblAgencia.setText(conta.getAgencia());
		lblTipoConta.setText(conta.getTipoConta());
	}

	public String HorarioCorreto(){
		DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Calendar calendario = Calendar.getInstance();
		
		return dataFormatada.format(calendario.getTime());
	}
}
