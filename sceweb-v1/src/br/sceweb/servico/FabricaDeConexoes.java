package br.sceweb.servico;

import java.sql.DriverManager;
import com.mysql.jdbc.Connection;
import org.apache.log4j.Logger;

public class FabricaDeConexoes {
	Logger logger = Logger.getLogger(FabricaDeConexoes.class);
	public Connection getConnection() {
		String url = "jdbc:mysql://localhost/sceweb";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return (Connection) DriverManager.getConnection(url, "root", "aluno");
		} catch (Exception e) {
			logger.info("SQLException na classe FabricaDeConexoes causa: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}
}



