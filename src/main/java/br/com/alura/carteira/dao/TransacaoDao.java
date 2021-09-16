package br.com.alura.carteira.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

public class TransacaoDao {

	private Connection conexao;
	private String sql;

	public TransacaoDao(Connection conexao) {
		this.conexao = conexao;
	}

	public void cadastrar(Transacao transacao) {
		sql = "INSERT INTO transacoes(ticker, preco, quantidade, data, tipo) values(?, ?, ?, ?, ?);";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, transacao.getTicker());
			ps.setBigDecimal(2, transacao.getPreco());
			ps.setInt(3, transacao.getQuantidade());
			ps.setDate(4, Date.valueOf(transacao.getData()));
			ps.setString(5, transacao.getTipo().toString());
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Transacao> listar() {
		sql = "SELECT * FROM transacoes";
		List<Transacao> transacoes = new ArrayList<>();
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Transacao t = new Transacao(
						resultSet.getString("ticker"), 
						resultSet.getBigDecimal("preco"), 
						resultSet.getInt("quantidade"), 
						resultSet.getDate("data").toLocalDate(), 
						TipoTransacao.valueOf(resultSet.getString("tipo"))
						);
				transacoes.add(t);
			}
			return transacoes;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
