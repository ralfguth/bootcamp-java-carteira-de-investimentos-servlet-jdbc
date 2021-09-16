package br.com.alura.carteira.testes;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

public class Teste {

	public static void main(String[] args) {
		Transacao t2 = new Transacao("XPTO12", new BigDecimal("12.7"), 200, LocalDate.now(), TipoTransacao.VENDA);

		System.out.println(t2.toString());
	}

}
