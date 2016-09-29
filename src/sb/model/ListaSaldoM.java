package sb.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ListaSaldoM extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	List<MovimentacaoDados> movimentacaoDados = new ArrayList<>();

	public ListaSaldoM(final List<MovimentacaoDados> movimentacao) {
		this.movimentacaoDados = movimentacao;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}
	@Override
	public int getRowCount() {
		return this.movimentacaoDados.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		final MovimentacaoDados movimentacao = this.movimentacaoDados.get(rowIndex);

		switch (columnIndex) {
		case -1:
			return movimentacao.getId();
		case 0:
			return movimentacao.getOperacao();
		case 1:
			return movimentacao.getData();
		case 2:

			switch (movimentacao.getOperacao()) {
			case "saque":
				return "R$ -" + movimentacao.getValor();
			case "tranferência":
				return "R$ -" + movimentacao.getValor();
			default:
				return "R$ " + movimentacao.getValor();
			}

		case 10:
			return movimentacao.getId();
		default:
			return "Erro";
		}
	}

	public void incluir(List<MovimentacaoDados> movimentacao) {
		this.movimentacaoDados = movimentacao;
		fireTableDataChanged();
	}

	@Override
	public String getColumnName(int col) {

		switch (col) {
		case 0:
			return "Operação";
		case 1:
			return "Data";
		case 2:
			return "Valor";
		default:
			return "Erro";
		}
	}

}
