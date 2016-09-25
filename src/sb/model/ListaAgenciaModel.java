package sb.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

public class ListaAgenciaModel extends AbstractTableModel {

	List<Agencia> agencias = new ArrayList<>();

	public ListaAgenciaModel(final List<Agencia> agencias) {
		this.agencias = agencias;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return this.agencias.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		final Agencia agencia = this.agencias.get(rowIndex);

		switch (columnIndex) {
		case -1:
			return agencia.getId();
		case 0:
			return agencia.getNome();
		case 1:
			return agencia.getNumero();
		case 2:
			return agencia.getCidade();
		case 10:
			return agencia.getId();
		default:
			return "Erro";
		}
	}

	public void incluir(List<Agencia> agencia) {
		this.agencias = agencia;
		fireTableDataChanged();
	}

	@Override
	public String getColumnName(int col) {

		switch (col) {
		case 0:
			return "Ag�ncia";
		case 1:
			return "N�mero";
		case 2:
			return "Cidade";
		case 3:
			return "";
		default:
			return "Erro";
		}
	}

}
