package br.com.banco;

import java.math.BigDecimal;

public class ContaCorrente extends Conta {
	public ContaCorrente(Long numeroConta, BigDecimal saldo, Agencia agencia) {
		super(numeroConta, saldo, agencia);
	}
}