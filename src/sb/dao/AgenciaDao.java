package sb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import sb.model.Agencia;

public class AgenciaDao {

	private static String SQL_SELECT_AGENCIA = "SELECT COUNT(*) FROM AGENCIA WHERE NUMERO = ?";
	private static String SQL_UPDATE = "UPDATE AGENCIA SET NOME = ?, NUMERO = ?, CIDADE = ? WHERE ID = ?";
	private static String SQL_GETAGENCIAID_ = "SELECT * FROM AGENCIA WHERE ID = ?";
	private static String SQL_SELECT_ALL = "SELECT * FROM AGENCIA ORDER BY ID";
	private static String SQL_INSERT = "INSERT INTO AGENCIA (NOME, NUMERO, CIDADE) VALUES (?,?,?)";

	public void adicionarAgencia(Agencia agencia) throws SQLException {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs;

		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement(SQL_INSERT,
					Statement.RETURN_GENERATED_KEYS);
			writeStatement(agencia, stmt);

			int newLinhas = stmt.executeUpdate();

			if (newLinhas == 0)
				throw new RuntimeException(
						"Falha ao inserir dados na tabela Agencia");

			rs = stmt.getGeneratedKeys();
			rs.next();
			agencia.setId(rs.getInt(1));
			JOptionPane.showMessageDialog(null,
					"Ag�ncia inserida com sucesso!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, stmt, con);
		}

	}

	private void writeStatement(Agencia agencia, PreparedStatement stmt)
			throws SQLException {

		stmt.setString(1, agencia.getNome());
		stmt.setString(2, agencia.getNumeroAgencia());
		stmt.setString(3, agencia.getCidade());

	}

	public List<Agencia> agencias() throws SQLException {

		List<Agencia> agencia = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement(SQL_SELECT_ALL);
			rs = stmt.executeQuery();

			while (rs.next()) {
				agencia.add(readResultSet(rs));
			}
			return agencia;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, stmt, con);
		}

		return agencia;
	}

	private void close(ResultSet rs, PreparedStatement stmt, Connection con)
			throws SQLException {
		if (rs != null && !rs.isClosed())
			rs.close();
		if (stmt != null && !stmt.isClosed())
			stmt.close();
		if (con != null && !con.isClosed())
			con.close();

	}

	private Agencia readResultSet(ResultSet rs) throws SQLException {
		Integer id = rs.getInt("id");
		String nome = rs.getString("nome");
		String numero = rs.getString("numero");
		String cidade = rs.getString("cidade");

		return new Agencia(id, nome, numero, cidade);
	}

	public Agencia get(Integer idAgencia) throws SQLException {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			con = Conexao.getConnection();

			stmt = con.prepareStatement(SQL_GETAGENCIAID_);
			stmt.setInt(1, idAgencia);

			rs = stmt.executeQuery();
			rs.next();

			return readResultSet(rs);
		} finally {
			close(rs, stmt, con);
		}

	}

	public void edit(Agencia agencia) {

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement(SQL_UPDATE);
			writeStatement(agencia, stmt);

			stmt.setInt(4, agencia.getId());

			int newLinhas = stmt.executeUpdate();

			if (newLinhas == 0)
				throw new RuntimeException(
						"Falha ao inserir dados na tabela Agencia");

			JOptionPane.showMessageDialog(null,
					"Ag�ncia atualizada com sucesso!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Integer getNumero(String nAgencia) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs;
		int newAgencias = 0;
		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement(SQL_SELECT_AGENCIA);

			stmt.setString(1, nAgencia);

			rs = stmt.executeQuery();

			if (rs.next()) {
				newAgencias = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newAgencias;
	}

}
