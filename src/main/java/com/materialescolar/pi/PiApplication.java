package com.materialescolar.pi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class PiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiApplication.class, args);
//		Connection conexao = null;
//		try {
//			String url = "jdbc:postgresql://localhost:5432/pi";
//			String user = "postgres";
//			String password = "19872010";
//
//			Class.forName("org.postgresql.Driver");
//			conexao = DriverManager.getConnection(url, user, password);
//			System.out.println("Conexão realizada!");
//		} catch (ClassNotFoundException | SQLException ex) {
//			System.out.println("Erro ao acessar o banco: " + ex.getMessage());
//		} finally {
//			try {
//				if (conexao != null) {
//					conexao.close();
//				}
//			} catch (SQLException ex) {
//				System.out.println("Erro ao fechar a conexão: " + ex.getMessage());
//			}
//		}
	}
}
