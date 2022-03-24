package br.com.banco.test;

import br.com.banco.Agencia;
import br.com.banco.Banco;
import br.com.banco.Conta;
import br.com.banco.ContaCorrente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ContaTest {
	@Test
	void deposito_na_propria_conta_realizado_com_sucesso() {
		Conta conta = new ContaCorrente(111, new BigDecimal(1000),
				new Agencia(123,
						new Banco("Banco do Brasil", "00000000000")));

		Assertions.assertEquals(new BigDecimal(1100), conta.depositar(new BigDecimal(100)));
	}

	@Test
	void deposito_na_propria_conta_valor_zerado() {
		Conta conta = new ContaCorrente(111, new BigDecimal(1000),
				new Agencia(123,
						new Banco("Banco do Brasil", "00000000000")));

		Assertions.assertEquals(new BigDecimal(0), conta.depositar(new BigDecimal(0)));
	}

	@Test
	void deposito_na_propria_conta_valor_negativo() {
		Conta conta = new ContaCorrente(111, new BigDecimal(1000),
				new Agencia(123,
						new Banco("Banco do Brasil", "00000000000")));

		Assertions.assertEquals(new BigDecimal(0), conta.depositar(new BigDecimal(-1000)));
	}
}
