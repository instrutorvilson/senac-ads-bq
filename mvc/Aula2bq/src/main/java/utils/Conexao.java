package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public static Connection conectar() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aulas","root","root");			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		return con;		
	}
}
