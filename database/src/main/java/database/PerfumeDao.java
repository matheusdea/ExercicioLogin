package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO = Data Access Object.
 */
public class PerfumeDao {

	private static final String URL = "jdbc:derby:bd;create=true";

	public static void inclui(int id, String nome, String fabricante,
			String preco) {
		// Abrir uma conexão com o banco de dados.
		Connection conn;
		try {
			conn = DriverManager.getConnection(URL);
			String sql = "insert into perfume (id, nome, fabricante, preco) values (?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, nome);
			pstmt.setString(3, fabricante);
			pstmt.setString(4, preco);
			pstmt.executeUpdate();
			// Fechar sentença.
			pstmt.close();
			// Fechar conexão.
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block

		}
		// Executar instrução SQL.

	}

	public static void alterar(int id, String nome, String fabricante,
			String preco) throws SQLException {
		// Abrir uma conexão com o banco de dados.
		Connection conn = DriverManager.getConnection(URL);
		// Executar instrução SQL.
		String sql = "update perfume set nome = ?, fabricante = ?, preco = ? where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, nome);
		pstmt.setString(2, fabricante);
		pstmt.setString(3, preco);
		pstmt.setInt(4, id);

		pstmt.executeUpdate();
		// Fechar sentença.
		pstmt.close();
		// Fechar conexão.
		conn.close();
	}

	public static void excluir(int id) throws SQLException {
		// Abrir uma conexão com o banco de dados.
		Connection conn = DriverManager.getConnection(URL);
		// Executar instrução SQL.
		String sql = "delete from perfume where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		// Fechar sentença.
		pstmt.close();
		// Fechar conexão.
		conn.close();
	}

	public static List<Perfume> listar() throws SQLException {
		// Abrir uma conexão com o banco de dados.
		Connection conn = DriverManager.getConnection(URL);
		// Executar instrução SQL.
		String sql = "select * from perfume";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// Represneta o resultado da execução.
		ResultSet rs = pstmt.executeQuery();

		List<Perfume> perfumes = new ArrayList<>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			String fabricante = rs.getString("fabricante");
			String preco = rs.getString("preco");
			Perfume perfume = new Perfume(id, nome, fabricante, preco);
			perfumes.add(perfume);
		}

		// Fechar resultado.
		rs.close();
		// Fechar sentença.
		pstmt.close();
		// Fechar conexão.
		conn.close();

		return perfumes;
	}

	public static List<Perfume> consultar(int id) throws SQLException {
		// Abrir uma conexão com o banco de dados.
		Connection conn = DriverManager.getConnection(URL);
		// Executar instrução SQL.
		String sql = "select * from perfume where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);

		// Represneta o resultado da execução.
		ResultSet rs = pstmt.executeQuery();

		List<Perfume> perfumes = new ArrayList<>();
		while (rs.next()) {
			int Id = rs.getInt("id");
			String nome = rs.getString("nome");
			String fabricante = rs.getString("fabricante");
			String preco = rs.getString("preco");
			Perfume perfume = new Perfume(id, nome, fabricante, preco);
			perfumes.add(perfume);
		}

		// Fechar resultado.
		rs.close();
		// Fechar sentença.
		pstmt.close();
		// Fechar conexão.
		conn.close();

		return perfumes;
	}
}
