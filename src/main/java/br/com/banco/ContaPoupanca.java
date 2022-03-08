package br.com.banco;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta {
	public ContaPoupanca(Long numeroConta, BigDecimal saldo, Agencia agencia) {
		super(numeroConta, saldo, agencia);
	}
}