package br.com.banco;

import java.math.BigDecimal;

public class ContaCorrente extends Conta {
	public ContaCorrente(int numeroConta, BigDecimal saldo, Agencia agencia) {
		super(numeroConta, saldo, agencia);
	}
}