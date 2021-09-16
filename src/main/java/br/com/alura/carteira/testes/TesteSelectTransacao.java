package br.com.alura.carteira.testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.alura.carteira.dao.TransacaoDao;

public class TesteSelectTransacao {

	public static void main(String[] args) {
		try {
			String url = "jdbc:mysql://localhost:3306/carteira";
			String usuario = "bootcamp";
			String senha = "123456";
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			TransacaoDao dao = new TransacaoDao(conexao);
			dao.listar().forEach(System.out::println);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
