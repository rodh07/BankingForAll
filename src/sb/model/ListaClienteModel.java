package sb.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ListaClienteModel extends AbstractTableModel {

	List<Conta> listaContas = new ArrayList<>();

	public ListaClienteModel(List<Conta> contas) {
		this.listaContas = contas;
	}

	public void incluir(List<Conta> contas) {
		this.listaContas = contas;
		fireTableDataChanged();
	}
	
	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return this.listaContas.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		final Conta conta = this.listaContas.get(rowIndex);

		switch (columnIndex) {
		case -1:
			return conta.getId();
		case 0:
			return conta.getNome();
		case 1:
			return conta.getIdade();
		case 2:
			return conta.getCpf();
		case 3:
			return conta.getAgencia();
		case 4:
			return conta.getTipoConta();

		default:
			return "Erro";
		}
	}
	@Override
	public String getColumnName(int coluna) {

		switch (coluna) {
		case 0:
			return "Nome";
		case 1:
			return "Idade";
		case 2:
			return "CPF";
		case 3:
			return "Agencia";
		case 4:
			return "Tipo Conta";
		default:
			return "XXX";
		}

	}
}
