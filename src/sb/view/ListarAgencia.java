package sb.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import sb.controller.AgenciaController;
import sb.model.Agencia;
import sb.model.ListaAgenciaModel;


public class ListarAgencia extends CabecalhoBancario implements WindowListener {

	private JPanel contentPane;
	private JTable tblAgencia;
	private ListaAgenciaModel model;
	private List<Agencia> agencias;

	public ListarAgencia() {
		super();
		addWindowListener(this);
		setTitle("Listagem de Ag�ncias");
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane().getLayout();
		gridBagLayout.columnWidths = new int[] { 372, 73, 77 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0 };

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		tblAgencia = new JTable();
		scrollPane.setViewportView(tblAgencia);

		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				final Integer rowSelected = tblAgencia.getSelectedRow();
				
				if (rowSelected <= 0) {
					JOptionPane.showMessageDialog(ListarAgencia.this, "Selecione uma ag�ncia para editar.", "Aten��o",
							JOptionPane.WARNING_MESSAGE);
				} else {
					final Integer rowIndex = tblAgencia.convertRowIndexToModel(rowSelected);
					final Integer idAgencia = (Integer) tblAgencia.getModel().getValueAt(rowIndex, -1);
					new CadastroAgencia(idAgencia).setVisible(true);
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		getContentPane().add(btnNewButton, gbc_btnNewButton);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				new CadastroAgencia(null).setVisible(true);
			}
		});
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnAdicionar.gridx = 2;
		gbc_btnAdicionar.gridy = 2;
		getContentPane().add(btnAdicionar, gbc_btnAdicionar);

	}

	private void preencheTela() {
		try {
			agencias = new AgenciaController().buscarAgencias();
			model = new ListaAgenciaModel(agencias);
			tblAgencia.setModel(model);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		preencheTela();
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
		/**
		 * M�todo respons�vel por setar o modelo a tabela e setar os valores
		 */
		preencheTela();
	}

}
