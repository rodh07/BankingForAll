package sb.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ListaAgenciaM extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Agencia> listaAgencias = new ArrayList<>();

	public ListaAgenciaM(final List<Agencia> agencias) {
		this.listaAgencias = agencias;
	}

	public void inclusao(List<Agencia> listaAgencias) {
		this.listaAgencias = listaAgencias;
		fireTableDataChanged();
	}
	
	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return this.listaAgencias.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		final Agencia agencia = this.listaAgencias.get(rowIndex);

		switch (columnIndex) {
		case -1:
			return agencia.getId();
		case 0:
			return agencia.getNome();
		case 1:
			return agencia.getNumeroAgencia();
		case 2:
			return agencia.getCidade();
		case 10:
			return agencia.getId();
		default:
			return "Erro";
		}
	}


	@Override
	public String getColumnName(int coluna) {

		switch (coluna) {
		case 0:
			return "Agencia";
		case 1:
			return "Numero";
		case 2:
			return "Cidade";
		case 3:
			return "";
		default:
			return "XXX";
		}
	}

}
