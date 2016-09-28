package sb.controller;

import java.sql.SQLException;
import java.util.List;

import sb.dao.AgenciaDao;
import sb.model.Agencia;


public class AgenciaController {

	public void add(Agencia agencia) {

		try {
			new AgenciaDao().adicionaAgencia(agencia);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Agencia get(Integer idAgencia) throws SQLException {

		return new AgenciaDao().get(idAgencia);
	}

	public void edit(Agencia agencia) {

		new AgenciaDao().edit(agencia);

	}

	public List<Agencia> buscarAgencias() throws SQLException {

		return new AgenciaDao().buscarAgencias();
	}

}
