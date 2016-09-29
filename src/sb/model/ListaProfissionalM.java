package sb.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ListaProfissionalM extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Profissional> listaProfissionais = new ArrayList<>();

	public ListaProfissionalM(List<Profissional> profissionais) {
		this.listaProfissionais = profissionais;
	}
	
	public void incluir(List<Profissional> listaProfissionais) {
		this.listaProfissionais = listaProfissionais;
		fireTableDataChanged();
	}
	
	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return this.listaProfissionais.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		final Profissional profissional = this.listaProfissionais.get(rowIndex);

		switch (columnIndex) {
		case -1:
			return profissional.getId();
		case 0:
			return profissional.getNome();
		case 1:
			return profissional.getUserName();

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
			return "Usuario";

		default:
			return "XXX";
		}
	}
}
