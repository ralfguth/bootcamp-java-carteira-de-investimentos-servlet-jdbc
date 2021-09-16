package br.com.alura.carteira.testes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/teste")
public class TesteServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4229096480996680355L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		PrintWriter writer = response.getWriter();
		writer.print("<h1>");
		writer.print("Olá, " + nome + "!");
		writer.println("</h1>");
		
		
	}
}
