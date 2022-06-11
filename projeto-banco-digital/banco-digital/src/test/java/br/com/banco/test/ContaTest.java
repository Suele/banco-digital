package br.com.banco.test;

import br.com.banco.Agencia;
import br.com.banco.Banco;
import br.com.banco.Conta;
import br.com.banco.ContaCorrente;
import br.com.banco.exeptions.ValidaContaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ContaTest {
  @Test
  void deposito_na_propria_conta_realizado_com_sucesso() {
    Conta conta = new ContaCorrente(111, new BigDecimal(1000),
        new Agencia(123,
            new Banco("Banco do Brasil", "00000000000")));

    conta.depositar(new BigDecimal(100));
    Assertions.assertEquals(new BigDecimal(1100), conta.getSaldo());
  }

  @Test
  void depositar_valor_zerado_na_conta() {
    Conta conta = new ContaCorrente(111, new BigDecimal(1000),
        new Agencia(123,
            new Banco("Banco do Brasil", "00000000000")));

    Assertions.assertThrows(ValidaContaException.class,
        () -> conta.depositar(new BigDecimal(0)),
        "Valor do deposito não pode ser zerado.");
  }

  @Test
  void depositar_valor_negativo_na_conta() {
    Conta conta = new ContaCorrente(111, new BigDecimal(1000),
        new Agencia(123,
            new Banco("Banco do Brasil", "00000000000")));

    Assertions.assertThrows(ValidaContaException.class,
        () -> conta.depositar(new BigDecimal(-100)),
        "Valor do deposito não pode ser negativo.");
  }

  @Test
  void transferir_valor_para_contas_dos_mesmos_bancos() {
    Conta conta1 = new ContaCorrente(111, new BigDecimal(1000),
        new Agencia(123,
            new Banco("Banco do Brasil", "00000000000")));

    Conta conta2 = new ContaCorrente(222, new BigDecimal(2000),
        new Agencia(123,
            new Banco("Banco do Brasil", "00000000000")));

    Assertions.assertEquals(BigDecimal.valueOf(0), conta1.qualEhBanco(conta2));
  }

  @Test
  void transferir_valor_para_contas_de_bancos_difentes() {
    Conta conta1 = new ContaCorrente(111, new BigDecimal(1000),
        new Agencia(123,
            new Banco("Banco do Brasil", "00000000000")));

    Conta conta2 = new ContaCorrente(222, new BigDecimal(2000),
        new Agencia(123,
            new Banco("Banco Itaú", "00000000000")));

    Assertions.assertEquals(BigDecimal.valueOf(20.00), conta1.qualEhBanco(conta2));
  }
}