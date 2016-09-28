package sb.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sb.model.Conta;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;

public class OperacaoConfirmada extends CabecalhoCliente {

	public OperacaoConfirmada(final Conta conta) {
		super(conta);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainCliente telaCliente = new MainCliente(conta);
				telaCliente.setVisible(true);
				telaCliente.dispose();
				telaCliente.setLocationRelativeTo(null);
				
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 1;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		// TODO Auto-generated constructor stub
	}

	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();


	public static void main(String[] args) {
		try {
			OperacaoConfirmada dialog = new OperacaoConfirmada(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deposito(Conta conta, BigDecimal valorDeposito) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean saque(Conta conta, BigDecimal valorSaque,
			String senhaInformada) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean transferencia(Conta conta, Conta contaRecebeTransf,
			BigDecimal valorTransf) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void finalizarConta(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contaAlterada(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean pagamento(Conta conta, BigDecimal valorPagamento,
			String codigoDeBarras) {
		// TODO Auto-generated method stub
		return false;
	}

}
