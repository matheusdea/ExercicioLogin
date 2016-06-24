package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	private static final String URL = "jdbc:derby:bd;create=true";

	public static boolean comparar(String usuario, String senha) throws SQLException {
		boolean autenticador = false;
		// Abrir uma conexão com o banco de dados.
		Connection conn = DriverManager.getConnection(URL);
		// Executar instrução SQL.
		String sql = "select login, pw FROM users WHERE login=? AND pw=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, usuario);
		pstmt.setString(2, senha);
		ResultSet rs;
		rs = pstmt.executeQuery();
		if (rs.next()) {
			String user = rs.getString("login");
			String password = rs.getString("pw");
			autenticador = true;
		} else {
			// Fechar sentença.
			pstmt.close();
			// Fechar conexão.
			conn.close();
			return autenticador;
		}
		return autenticador;
	}
}
