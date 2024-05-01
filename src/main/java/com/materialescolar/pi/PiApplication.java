package com.materialescolar.pi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class PiApplication {


	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		String url = "jdbc:postgresql://localhost:5432/pi";
		String user = "postgres";
		String password =  "19872010";

		SpringApplication.run(PiApplication.class, args);
		Connection conexao = null;
		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pi", "postgres", "19872010");
			System.out.println("Conexão Realizada!");
		} catch (SQLException ex) {
			System.out.println("Erro ao acessar o banco: " + ex.getMessage());
		} finally {
			if (conexao != null){
				conexao.close();
			}
		}
	}

}
