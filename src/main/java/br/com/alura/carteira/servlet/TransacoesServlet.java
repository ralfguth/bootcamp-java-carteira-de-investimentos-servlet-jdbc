package br.com.alura.carteira.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.carteira.dao.TransacaoDao;
import br.com.alura.carteira.factory.ConnectionFactory;
import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

@WebServlet("/transacoes")
public class TransacoesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private TransacaoDao dao;

	public TransacoesServlet() {
			this.dao = new TransacaoDao(new ConnectionFactory().getConnection());
	};

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("transacoes", dao.listar());
		req.getRequestDispatcher("WEB-INF/jsp/transacoes.jsp").forward(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String ticker = req.getParameter("ticker");
			LocalDate data = LocalDate.parse(req.getParameter("data"));
			BigDecimal preco = new BigDecimal(req.getParameter("preco").replace(",", "."));
			int quantidade = Integer.parseInt(req.getParameter("quantidade"));
			TipoTransacao tipo = TipoTransacao.valueOf(req.getParameter("tipo").toUpperCase());
			Transacao transacao = new Transacao(ticker, preco, quantidade, data, tipo);
			dao.cadastrar(transacao);
			res.sendRedirect("transacoes");
		} catch (Exception e) {
			res.sendRedirect("transacoes?erro=campoInvalido");
		}

	}

}
