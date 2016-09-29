package sb.view;

import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import sb.controller.AgenciaController;
import sb.dao.AgenciaDao;
import sb.model.Agencia;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CadastrarAgencia extends CabecalhoBancario implements	WindowListener {

	private static final long serialVersionUID = 1L;
	private static final int criarIDAgencia = 0;
	private JTextField txtNome;
	private JTextField txtNumeroAgencia;
	private JTextField txtCidade;
	private Integer idAgencia;
	private String sql = "";

	public CadastrarAgencia(final Integer idAgencia) {
		super();
		setAutoRequestFocus(false);
		this.idAgencia = idAgencia;
		setLocationRelativeTo(null);
		addWindowListener(this);
		setResizable(false);
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane()
				.getLayout();
		gridBagLayout.columnWidths = new int[] { 0, 41, 0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0 };
		setLocationRelativeTo(null);
		setTitle("Cadastro de Agencias");

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 120, 342, 93, 0 };
		gbl_panel.rowHeights = new int[] { 0, 18, 14, 0, 0, 12, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.anchor = GridBagConstraints.NORTH;
		gbc_lblNome.gridx = 1;
		gbc_lblNome.gridy = 1;
		panel.add(lblNome, gbc_lblNome);

		txtNome = new JTextField();
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.insets = new Insets(0, 0, 5, 5);
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 2;
		panel.add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel = new JLabel("N\u00FAmero");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		txtNumeroAgencia = new JTextField();
		GridBagConstraints gbc_txtNumero = new GridBagConstraints();
		gbc_txtNumero.insets = new Insets(0, 0, 5, 5);
		gbc_txtNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumero.gridx = 1;
		gbc_txtNumero.gridy = 4;
		panel.add(txtNumeroAgencia, gbc_txtNumero);
		txtNumeroAgencia.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Cidade");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 5;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtCidade = new JTextField();
		GridBagConstraints gbc_txtCidade = new GridBagConstraints();
		gbc_txtCidade.insets = new Insets(0, 0, 5, 5);
		gbc_txtCidade.anchor = GridBagConstraints.NORTH;
		gbc_txtCidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCidade.gridx = 1;
		gbc_txtCidade.gridy = 6;
		panel.add(txtCidade, gbc_txtCidade);
		txtCidade.setColumns(10);

		JButton btnConfirma = new JButton("Confirme");
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nomeAgenc = txtNome.getText().trim();
				String numero = txtNumeroAgencia.getText().trim();
				String cidade = txtCidade.getText().trim();

				if (nomeAgenc.equals("") || numero.equals("")
						|| cidade.equals("")) {
					JOptionPane.showMessageDialog(CadastrarAgencia.this,
							"Informe todos os campos para gravar!", "Erro!",
							JOptionPane.WARNING_MESSAGE);
				} else if (sql.equals("update")) {
					final Agencia agencia = new Agencia(idAgencia, nomeAgenc,
							numero, cidade);
					new AgenciaController().editar(agencia);
					sql = "";
					limparCampos();
				} else {
					int numeroAgencia = new AgenciaDao()
							.getNumero(txtNumeroAgencia.getText());
					if (numeroAgencia <= 0) {
						final Agencia agencia = new Agencia(criarIDAgencia,
								nomeAgenc, numero, cidade);
						new AgenciaController().add(agencia);
						limparCampos();
					} else {
						JOptionPane.showMessageDialog(CadastrarAgencia.this,
								"Numero de agencia ja utilizado, tente novamente!",
										"Erro!", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		GridBagConstraints gbc_btnConfirma = new GridBagConstraints();
		gbc_btnConfirma.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnConfirma.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfirma.gridx = 1;
		gbc_btnConfirma.gridy = 7;
		panel.add(btnConfirma, gbc_btnConfirma);
	}

	private void populaTela(Agencia agencia) {

		if (agencia == null) {
			txtCidade.setText("");
			txtNome.setText("");
			txtNumeroAgencia.setText("");
		} else {
			this.sql = "update";
			txtCidade.setText(agencia.getCidade());
			txtNome.setText(agencia.getNome());
			txtNumeroAgencia.setText(agencia.getNumeroAgencia());
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
		Agencia agencia = null;
		if (this.idAgencia != null && this.idAgencia >= 0) {
			try {
				final AgenciaController agenciaController = new AgenciaController();
				agencia = agenciaController.get(this.idAgencia);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		populaTela(agencia);
	}

	protected void limparCampos() {
		txtNome.setText("");
		txtCidade.setText("");
		txtNumeroAgencia.setText("");
	}
}
