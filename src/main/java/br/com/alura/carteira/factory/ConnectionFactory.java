package br.com.alura.carteira.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private String url;
	private String usuario;
	private String senha;

	public Connection getConnection() {
		try {
			url = "jdbc:mysql://localhost:3306/carteira";
			usuario = "bootcamp";
			senha = "123456";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			return conexao;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
