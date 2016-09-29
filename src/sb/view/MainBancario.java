package sb.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import sb.view.PopupConta;

public class MainBancario extends CabecalhoBancario {

	private JPanel contentPane;

	public MainBancario() {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Administracao Banking For All");
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane()
				.getLayout();
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0 };

		JPanel newPainel = new JPanel();
		GridBagConstraints gbc_newPainel = new GridBagConstraints();
		gbc_newPainel.insets = new Insets(0, 0, 0, 5);
		gbc_newPainel.gridheight = 2;
		gbc_newPainel.gridwidth = 3;
		gbc_newPainel.fill = GridBagConstraints.BOTH;
		gbc_newPainel.gridx = 0;
		gbc_newPainel.gridy = 1;
		getContentPane().add(newPainel, gbc_newPainel);
		GridBagLayout gbl_newPainel = new GridBagLayout();
		gbl_newPainel.columnWidths = new int[] { 1, 0, 0 };
		gbl_newPainel.rowHeights = new int[] { 1, 0, 0, 0 };
		gbl_newPainel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_newPainel.rowWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		newPainel.setLayout(gbl_newPainel);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.gridheight = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		newPainel.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 279, 243, 0 };
		gbl_panel.rowHeights = new int[] { 76, 76, 75, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JButton btnPopUpConta = new JButton("1 - Informacoes de Contas");
		btnPopUpConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				PopupConta popupConta = new PopupConta();
				popupConta.setVisible(true);
				popupConta.setLocationRelativeTo(null);
			}
		});
		GridBagConstraints gbc_btnInfo = new GridBagConstraints();
		gbc_btnInfo.fill = GridBagConstraints.BOTH;
		gbc_btnInfo.insets = new Insets(0, 0, 5, 5);
		gbc_btnInfo.gridx = 0;
		gbc_btnInfo.gridy = 0;
		panel.add(btnPopUpConta, gbc_btnInfo);

		JButton btnProfissional = new JButton("4 - Profissionais");
		btnProfissional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarProfissionais listarProfissionais = new ListarProfissionais();
				listarProfissionais.setVisible(true);
				listarProfissionais.setResizable(false);
			}
		});
		GridBagConstraints gbc_btnProfissional = new GridBagConstraints();
		gbc_btnProfissional.fill = GridBagConstraints.BOTH;
		gbc_btnProfissional.insets = new Insets(0, 0, 5, 0);
		gbc_btnProfissional.gridx = 1;
		gbc_btnProfissional.gridy = 0;
		panel.add(btnProfissional, gbc_btnProfissional);

		JButton btnBalanco = new JButton("5 - Balanco");
		GridBagConstraints gbc_btnBalanco = new GridBagConstraints();
		gbc_btnBalanco.fill = GridBagConstraints.BOTH;
		gbc_btnBalanco.insets = new Insets(0, 0, 5, 0);
		gbc_btnBalanco.gridx = 1;
		gbc_btnBalanco.gridy = 1;
		panel.add(btnBalanco, gbc_btnBalanco);
		
		JButton btnNovaConta = new JButton("2 - Nova Conta");
		btnNovaConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				CadastrarConta cadastrarConta = new CadastrarConta();
				cadastrarConta.setVisible(true);
				cadastrarConta.setResizable(false);
			}
		});
		GridBagConstraints gbc_btnNovaConta = new GridBagConstraints();
		gbc_btnNovaConta.fill = GridBagConstraints.BOTH;
		gbc_btnNovaConta.insets = new Insets(0, 0, 5, 5);
		gbc_btnNovaConta.gridx = 0;
		gbc_btnNovaConta.gridy = 1;
		panel.add(btnNovaConta, gbc_btnNovaConta);

		JButton btnClientes = new JButton("3 - Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCliente listaClientes = new ListarCliente();
				listaClientes.setVisible(true);
				listaClientes.setResizable(false);
			}
		});
		GridBagConstraints gbc_btnClientes = new GridBagConstraints();
		gbc_btnClientes.fill = GridBagConstraints.BOTH;
		gbc_btnClientes.insets = new Insets(0, 0, 0, 5);
		gbc_btnClientes.gridx = 0;
		gbc_btnClientes.gridy = 2;
		panel.add(btnClientes, gbc_btnClientes);

		JButton btnAgencias = new JButton("6 - Agencias");
		btnAgencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarAgencia listaAgencia = new ListarAgencia();
				listaAgencia.setVisible(true);
				listaAgencia.setResizable(false);
			}
		});
		GridBagConstraints gbc_btnAgencias = new GridBagConstraints();
		gbc_btnAgencias.fill = GridBagConstraints.BOTH;
		gbc_btnAgencias.gridx = 1;
		gbc_btnAgencias.gridy = 2;
		panel.add(btnAgencias, gbc_btnAgencias);
	}
}
