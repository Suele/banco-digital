package br.com.banco;

import java.math.BigDecimal;

public class Conta {

	private Long numeroConta;
	private BigDecimal saldo;
	private Agencia agencia;

	public Conta(Long numeroConta, BigDecimal saldo, Agencia agencia) {
		if (numeroConta > 0 && saldo.compareTo(BigDecimal.ZERO) > 0 && agencia != null) {
			this.numeroConta = numeroConta;
			this.saldo = saldo;
			this.agencia = agencia;
		}
	}

	public Long getNumeroConta() {
		return numeroConta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void sacar(BigDecimal valor) {

		if (this.saldo.compareTo(BigDecimal.ZERO) > 0 && valor.compareTo(BigDecimal.ZERO) > 0) {
			this.saldo = this.saldo.subtract(valor);
		}
	}

	public void depositar(BigDecimal valor) {

		if (valor.compareTo(BigDecimal.ZERO) > 0) {
			this.saldo = this.saldo.add(valor);
		}
	}
}