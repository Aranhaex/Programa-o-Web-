package Model;

import java.sql.*;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class UsuarioDAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/loginapp";
	private String user = "root";
	private String password = "12345";

	// Conexão do banco de dados

	private Connection conectar() {
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println(e);
			return null;

		}

	}

	public boolean validarLogin(String username, String senha) {
		String sql = "SELECT * FROM usuarios where username=? AND senha=?";
		try {
			Connection con = conectar();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, senha);

			ResultSet rs = stmt.executeQuery();

			return rs.next(); // Se encontrou registro, login é liberado
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	// Cadastrar novo usuário
	public boolean cadastrarUsuario(String username, String senha) {
		String sql = "INSERT INTO usuarios (username, senha) VALUES (?, ?)";

		try {
			Connection con = conectar();
			if (con == null)
				return false; // Segurança se falhar conexão

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, senha);

			stmt.execute();
			stmt.close();
			con.close();

			return true; // Sucesso
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar: " + e);
			return false; // Falha (ex: usuário já existe)
		}
	}
}
