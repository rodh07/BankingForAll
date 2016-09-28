package sb.controller;

import java.sql.SQLException;
import java.util.List;

import sb.dao.AgenciaDao;
import sb.model.Agencia;

public class AgenciaController {

	public void add(Agencia agencia) {

		try {
			new AgenciaDao().adicionarAgencia(agencia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Agencia get(Integer idAgencia) throws SQLException {

		return new AgenciaDao().get(idAgencia);
	}

	public void editar(Agencia agencia) {
		new AgenciaDao().edit(agencia);
	}

	public List<Agencia> agencias() throws SQLException {

		return new AgenciaDao().agencias();
	}

}
