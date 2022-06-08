package br.com.banco;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta {
	public ContaPoupanca(int numeroConta, BigDecimal saldo, Agencia agencia) {
		super(numeroConta, saldo, agencia);
	}
}