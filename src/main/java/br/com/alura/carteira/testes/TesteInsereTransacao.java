package br.com.alura.carteira.testes;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import br.com.alura.carteira.dao.TransacaoDao;
import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

public class TesteInsereTransacao {

	public static void main(String[] args) {
		try {
			String url = "jdbc:mysql://localhost:3306/carteira";
			String usuario = "bootcamp";
			String senha = "123456";
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			TransacaoDao dao = new TransacaoDao(conexao);
			Transacao transacao = new Transacao("NUIZA", new BigDecimal("123.4"), 100, LocalDate.now(), TipoTransacao.COMPRA);
			dao.cadastrar(transacao);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
