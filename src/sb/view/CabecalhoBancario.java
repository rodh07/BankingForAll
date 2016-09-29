package sb.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

//import sb.model.HorarioCorreto;

import java.awt.Color;

public class CabecalhoBancario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected JLabel lblData;

	public CabecalhoBancario() {
		setSize(553, 310);
		setIconImage(Toolkit.getDefaultToolkit().
				getImage("./Icones/Play256x256.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 77, 103, 414, 0 };
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
		gbl_cabecalho.rowHeights = new int[] { 26, 0, 26, 0 };
		gbl_cabecalho.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_cabecalho.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		cabecalho.setLayout(gbl_cabecalho);

		JLabel lblNomeBanco = new JLabel("Banking For All");
		lblNomeBanco.setForeground(Color.BLACK);
		lblNomeBanco.setFont(new Font("Times New Roman", Font.BOLD, 18));
		GridBagConstraints gbc_lblNomeBanco = new GridBagConstraints();
		gbc_lblNomeBanco.fill = GridBagConstraints.BOTH;
		gbc_lblNomeBanco.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeBanco.gridx = 1;
		gbc_lblNomeBanco.gridy = 0;
		cabecalho.add(lblNomeBanco, gbc_lblNomeBanco);

		lblData = new JLabel("");
		lblData.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblData.setForeground(Color.BLACK);
		lblData.setText(HorarioCorreto());
		GridBagConstraints gbc_lblDataHoraAtual = new GridBagConstraints();
		gbc_lblDataHoraAtual.anchor = GridBagConstraints.EAST;
		gbc_lblDataHoraAtual.fill = GridBagConstraints.VERTICAL;
		gbc_lblDataHoraAtual.insets = new Insets(0, 0, 5, 0);
		gbc_lblDataHoraAtual.gridx = 2;
		gbc_lblDataHoraAtual.gridy = 0;
		cabecalho.add(lblData, gbc_lblDataHoraAtual);

		JLabel imagem = new JLabel("");
		imagem.setIcon(new ImageIcon("./Icones/Play256x256.png"));
		GridBagConstraints gbc_imagem = new GridBagConstraints();
		gbc_imagem.gridheight = 3;
		gbc_imagem.insets = new Insets(0, 0, 0, 5);
		gbc_imagem.gridx = 0;
		gbc_imagem.gridy = 0;
		cabecalho.add(imagem, gbc_imagem);

		JLabel lblFrase = new JLabel("It's free, go go!!");
		lblFrase.setForeground(Color.BLACK);
		lblFrase.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GridBagConstraints gbc_lblFrase = new GridBagConstraints();
		gbc_lblFrase.fill = GridBagConstraints.BOTH;
		gbc_lblFrase.insets = new Insets(0, 0, 0, 5);
		gbc_lblFrase.gridx = 1;
		gbc_lblFrase.gridy = 2;
		cabecalho.add(lblFrase, gbc_lblFrase);
	}
	
	public JLabel getLblData() {
		return lblData;
	}

	protected void setLblData(String lblData) {
		this.lblData.setText(lblData);
	}
	
	public String HorarioCorreto(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Calendar calendario = Calendar.getInstance();
		return dateFormat.format(calendario.getTime());
	}
}
