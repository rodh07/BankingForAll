package sb.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ListaClienteModel extends AbstractTableModel {

	List<Conta> contas = new ArrayList<>();

	public ListaClienteModel(List<Conta> contas) {
		this.contas = contas;

	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return this.contas.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		final Conta conta = this.contas.get(rowIndex);

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
	public String getColumnName(int column) {

		switch (column) {
		case 0:
			return "Nome";
		case 1:
			return "Idade";
		case 2:
			return "CPF";
		case 3:
			return "Ag�ncia";
		case 4:
			return "Tipo Conta";

		default:
			return "Erro";
		}

	}

	public void incluir(List<Conta> contas) {
		this.contas = contas;
		fireTableDataChanged();
	}

}
