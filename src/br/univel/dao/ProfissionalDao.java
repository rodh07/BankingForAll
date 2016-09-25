package br.univel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.swing.JOptionPane;

import sb.classificacoes.ClassificacaoUsuario;
import sb.model.Profissional;


public class ProfissionalDao {

	private static String SQL_UPDATE = "UPDATE PROFISSIONAL SET NOME = ?, IDADE =?,  USUARIO = ?, SENHAACESSO = ? ,SENHAOPERACOES = ? , TIPOPROFISSIONAL = ? WHERE ID = ?";
	private static String SQL_GET_PROFISS_ID = "SELECT * FROM PROFISSIONAL WHERE ID = ?";
	private static String SQL_SELECT_ALL = "select * from profissional order by id";
	private static String SQL_INSERT = "INSERT INTO PROFISSIONAL (nome, idade, usuario, senhaAcesso, senhaOperacoes, tipoProfissional) VALUES (?,?,?,?,?,?)";

	public void add(Profissional profisisonal) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = Conexao.getConnection();

			stmt = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			writeStatement(profisisonal, stmt);

			int newLinhas = stmt.executeUpdate();

			if (newLinhas == 0) {
				throw new RuntimeErrorException(null, "Falha ao inserir dados na tabela Profissionais!");
			}

			rs = stmt.getGeneratedKeys();
			rs.next();

			profisisonal.setId(rs.getInt(1));
			JOptionPane.showMessageDialog(null, "Profissional inserido com sucesso!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, stmt, con);
		}

	}

	private void writeStatement(Profissional profissional, PreparedStatement stmt) throws SQLException {

		stmt.setString(1, profissional.getNome());
		stmt.setInt(2, profissional.getIdade());
		stmt.setString(3, profissional.getUserName());
		stmt.setString(4, profissional.getSenhaAcesso());
		stmt.setString(5, profissional.getSenhaOperacoes());
		stmt.setString(6, profissional.getTipoProfissional().toString());
	}

	protected void close(ResultSet set, Statement stmt, Connection conn) {
		try {
			if (set != null && !set.isClosed())
				set.close();
			if (stmt != null && !stmt.isClosed())
				stmt.close();
			if (conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Profissional> buscarProfissionais() {

		List<Profissional> profissionais = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = Conexao.getConnection();

			stmt = con.prepareStatement(SQL_SELECT_ALL);
			rs = stmt.executeQuery();

			while (rs.next()) {
				profissionais.add(readResultSet(rs));
			}

			return profissionais;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, stmt, con);
		}
		return profissionais;
	}

	private Profissional readResultSet(ResultSet rs) throws SQLException {

		Integer id = rs.getInt("id");
		String nome = rs.getString("nome");
		String usuario = rs.getString("usuario");
		Integer idade = rs.getInt("idade");
		String senhaOperacoes = rs.getString("senhaOperacoes");
		String senhaAcesso = rs.getString("senhaAcesso");
		String tipo = rs.getString("tipoProfissional");

		ClassificacaoUsuario tipoProf = ClassificacaoUsuario.CLIENTE;
		if (tipo == "CLIENTE") {
			tipoProf = ClassificacaoUsuario.CLIENTE;
		} else if (tipo == "BANCARIO") {
			tipoProf = ClassificacaoUsuario.BANCARIO;
		}

		return new Profissional(id, nome, usuario, idade, senhaAcesso, senhaOperacoes, tipoProf);

	}

	public Profissional get(Integer idProfissional) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = Conexao.getConnection();

			stmt = con.prepareStatement(SQL_GET_PROFISS_ID);

			stmt.setInt(1, idProfissional);

			rs = stmt.executeQuery();

			rs.next();

			return readResultSet(rs);

		} finally {
			close(rs, stmt, con);

		}
	}

	public void edit(Profissional profissional) {

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement(SQL_UPDATE);
			writeStatement(profissional, stmt);

			stmt.setInt(7, profissional.getId());

			int linhasInseridas = stmt.executeUpdate();

			if (linhasInseridas == 0)
				throw new RuntimeException("Falha ao inserir dados na tabela Profissional");

			JOptionPane.showMessageDialog(null, "Profissional atualizado com sucesso!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
