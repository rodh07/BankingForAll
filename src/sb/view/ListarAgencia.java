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
import sb.model.ListaAgenciaM;

public class ListarAgencia extends CabecalhoBancario implements WindowListener {

	private JPanel contentPane;
	private JTable tblAgencia;
	private ListaAgenciaM model;
	private List<Agencia> agencias;

	public ListarAgencia() {
		super();
		addWindowListener(this);
		setTitle("Listar Agencias");
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane()
				.getLayout();
		gridBagLayout.columnWidths = new int[] { 372, 0, 73, 77 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0 };

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		tblAgencia = new JTable();
		scrollPane.setViewportView(tblAgencia);

		JButton btnAddAgencia = new JButton("Adicionar");
		btnAddAgencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				new CadastrarAgencia(null).setVisible(true);
			}
		});

		JButton btnEditAgencia = new JButton("Editar");
		btnEditAgencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				final Integer rowSelected = tblAgencia.getSelectedRow();

				if (rowSelected <= 0) {
					JOptionPane.showMessageDialog(ListarAgencia.this,
							"Selecione uma agencia para editar.", "Erro",
							JOptionPane.WARNING_MESSAGE);
				} else {
					final Integer rowIndex = tblAgencia
							.convertRowIndexToModel(rowSelected);
					final Integer idAgencia = (Integer) tblAgencia.getModel()
							.getValueAt(rowIndex, -1);
					new CadastrarAgencia(idAgencia).setVisible(true);
				}
			}
		});
		GridBagConstraints gbc_btnEditAgencia = new GridBagConstraints();
		gbc_btnEditAgencia.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditAgencia.fill = GridBagConstraints.BOTH;
		gbc_btnEditAgencia.gridwidth = 3;
		gbc_btnEditAgencia.gridx = 1;
		gbc_btnEditAgencia.gridy = 2;
		getContentPane().add(btnEditAgencia, gbc_btnEditAgencia);
		GridBagConstraints gbc_btnAddAgencia = new GridBagConstraints();
		gbc_btnAddAgencia.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddAgencia.fill = GridBagConstraints.BOTH;
		gbc_btnAddAgencia.gridwidth = 3;
		gbc_btnAddAgencia.gridx = 1;
		gbc_btnAddAgencia.gridy = 3;
		getContentPane().add(btnAddAgencia, gbc_btnAddAgencia);
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
		preencheTela();
	}

	private void preencheTela() {
		try {
			agencias = new AgenciaController().agencias();
			model = new ListaAgenciaM(agencias);
			tblAgencia.setModel(model);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
