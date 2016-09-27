package sb.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.PrimitiveIterator.OfDouble;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import sb.classificacoes.ClassificacaoUsuario;
import sb.controller.ProfissionalController;
import sb.model.Profissional;

public class CadastroProfissional extends CabecalhoBancario implements
		WindowListener {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtOperacoesSenhas;
	private JTextField txtUsuario;
	private JTextField txtSenha;
	private JComboBox cmbTipoProfissional;
	private Integer idProfissional;
	private String sql = "";

	public CadastroProfissional(final Integer idProfissional) {
		super();
		this.idProfissional = idProfissional;
		addWindowListener(this);
		setResizable(false);
		setTitle("Cadastro de Profissionais");
		setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane()
				.getLayout();
		gridBagLayout.columnWidths = new int[] { 36, 530, 0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 0.0 };

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 64, 63, 123, 207, 0 };
		gbl_panel.rowHeights = new int[] { 20, 0, 0, 14, 20, 14, 20, 38, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.NORTH;
		gbc_lblNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 1;
		gbc_lblNome.gridy = 1;
		panel.add(lblNome, gbc_lblNome);

		txtNome = new JTextField();
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.insets = new Insets(0, 0, 5, 0);
		gbc_txtNome.gridwidth = 3;
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 2;
		panel.add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);

		JLabel lblIdade = new JLabel("Idade");
		GridBagConstraints gbc_lblIdade = new GridBagConstraints();
		gbc_lblIdade.anchor = GridBagConstraints.NORTH;
		gbc_lblIdade.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIdade.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdade.gridx = 1;
		gbc_lblIdade.gridy = 3;
		panel.add(lblIdade, gbc_lblIdade);

		JLabel lblSenhaOperaes = new JLabel("Senha Opera\u00E7\u00F5es");
		GridBagConstraints gbc_lblSenhaOperaes = new GridBagConstraints();
		gbc_lblSenhaOperaes.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblSenhaOperaes.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenhaOperaes.gridx = 2;
		gbc_lblSenhaOperaes.gridy = 3;
		panel.add(lblSenhaOperaes, gbc_lblSenhaOperaes);

		JLabel lblSenha = new JLabel("Senha Acesso");
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 0);
		gbc_lblSenha.gridx = 3;
		gbc_lblSenha.gridy = 3;
		panel.add(lblSenha, gbc_lblSenha);

		try {
			txtIdade = new JFormattedTextField(new MaskFormatter("##"));
			GridBagConstraints gbc_txtIdade = new GridBagConstraints();
			gbc_txtIdade.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtIdade.insets = new Insets(0, 0, 5, 5);
			gbc_txtIdade.gridx = 1;
			gbc_txtIdade.gridy = 4;
			panel.add(txtIdade, gbc_txtIdade);
			txtIdade.setColumns(10);
		} catch (ParseException e2) {
			e2.printStackTrace();
		}

		try {
			txtOperacoesSenhas = new JFormattedTextField(new MaskFormatter(
					"########"));
			GridBagConstraints gbc_txtOperacoesSenhas = new GridBagConstraints();
			gbc_txtOperacoesSenhas.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtOperacoesSenhas.insets = new Insets(0, 0, 5, 5);
			gbc_txtOperacoesSenhas.gridx = 2;
			gbc_txtOperacoesSenhas.gridy = 4;
			panel.add(txtOperacoesSenhas, gbc_txtOperacoesSenhas);
			txtOperacoesSenhas.setColumns(10);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		txtSenha = new JTextField();
		GridBagConstraints gbc_txtSenha = new GridBagConstraints();
		gbc_txtSenha.insets = new Insets(0, 0, 5, 0);
		gbc_txtSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSenha.gridx = 3;
		gbc_txtSenha.gridy = 4;
		panel.add(txtSenha, gbc_txtSenha);
		txtSenha.setColumns(10);

		JLabel lblUsername = new JLabel("Usuario");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.NORTH;
		gbc_lblUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 5;
		panel.add(lblUsername, gbc_lblUsername);

		JLabel lblTipoProfissional = new JLabel("Tipo Profissional");
		GridBagConstraints gbc_lblTipoProfissional = new GridBagConstraints();
		gbc_lblTipoProfissional.anchor = GridBagConstraints.WEST;
		gbc_lblTipoProfissional.insets = new Insets(0, 0, 5, 0);
		gbc_lblTipoProfissional.gridx = 3;
		gbc_lblTipoProfissional.gridy = 5;
		panel.add(lblTipoProfissional, gbc_lblTipoProfissional);

		txtUsuario = new JTextField();
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.gridwidth = 2;
		gbc_txtUsuario.gridx = 1;
		gbc_txtUsuario.gridy = 6;
		panel.add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);

		cmbTipoProfissional = new JComboBox(ClassificacaoUsuario.values());
		GridBagConstraints gbc_cmbTipoProfissional = new GridBagConstraints();
		gbc_cmbTipoProfissional.insets = new Insets(0, 0, 5, 0);
		gbc_cmbTipoProfissional.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbTipoProfissional.gridx = 3;
		gbc_cmbTipoProfissional.gridy = 6;
		panel.add(cmbTipoProfissional, gbc_cmbTipoProfissional);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtNome.getText().equals("")
						|| txtIdade.getText().equals("")
						|| txtSenha.getText().equals("")
						|| txtOperacoesSenhas.getText().equals("")
						|| txtUsuario.getText().equals("")) {

					JOptionPane.showMessageDialog(CadastroProfissional.this,
							"Campos incorretos, tente novamente!",
							"Erro!", JOptionPane.WARNING_MESSAGE, null);
					txtNome.requestFocus();
				} else {

					Profissional pro = new Profissional();
					pro.setId(idProfissional);
					pro.setIdade(Integer.parseInt(txtIdade.getText()));
					pro.setNome(txtNome.getText().trim());
					pro.setAcesso(txtSenha.getText());
					pro.setSenhaOperacoes(txtOperacoesSenhas.getText());
					pro.setUserName(txtUsuario.getText());
					pro
							.setTipoProfissional((ClassificacaoUsuario) cmbTipoProfissional
									.getSelectedItem());
					if (sql.equals("update")) {
						new ProfissionalController().edit(pro);
						limparCampos();
					} else {
						new ProfissionalController().add(pro);
						limparCampos();

					}
				}
			}
		});
		GridBagConstraints gbc_btnConfirmar = new GridBagConstraints();
		gbc_btnConfirmar.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnConfirmar.gridx = 3;
		gbc_btnConfirmar.gridy = 7;
		panel.add(btnConfirmar, gbc_btnConfirmar);
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

		Profissional profissional = null;

		if (this.idProfissional != null && this.idProfissional >= 0) {
			try {

				final ProfissionalController controller = new ProfissionalController();

				profissional = controller.get(this.idProfissional);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		populaTela(profissional);

	}

	private void populaTela(Profissional profissional) {

		if (profissional == null) {
			txtIdade.setText("");
			txtNome.setText("");
			txtSenha.setText("");
			txtOperacoesSenhas.setText("");
			txtUsuario.setText("");

		} else {
			this.sql = "update";
			txtIdade.setText(profissional.getIdade().toString());
			txtNome.setText(profissional.getNome());
			txtSenha.setText(profissional.getAcesso());
			txtOperacoesSenhas.setText(profissional.getSenhaOperacoes());
			txtUsuario.setText(profissional.getUserName());
			cmbTipoProfissional.setSelectedItem(profissional
			.getTipoProfissional().getNumeracao());
		}
	}
	protected void limparCampos() {
		txtIdade.setText("");
		txtNome.setText("");
		txtSenha.setText("");
		txtOperacoesSenhas.setText("");
		txtUsuario.setText("");
		cmbTipoProfissional.setSelectedItem(0);
	}
}
