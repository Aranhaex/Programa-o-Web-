package Model;
import java.sql.*;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class UsuarioDAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql//localhost:3306/loginapp";
	private String user = "root";
	private String password = "12345";
	
	//Conexão do banco de dados
	
	private Connection conectar() {
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, user, password);
		}catch(Exception e){
			System.out.println(e);
			return null;
			
		}
		
	}
	public boolean validarLogin(String username, String senha){
		String sql = "SELECT * FROM usuarios where username=? AND senha=?";
		try{
			Connection con = conectar();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, senha);
			
			ResultSet rs = stmt.executeQuery();
			
			return rs.next(); //Se encontrou registro, login é liberado
		}catch(SQLException e){
			System.out.println(e);
			return false;
		}
	}
}
