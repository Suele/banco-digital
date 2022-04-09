package br.com.banco;

import br.com.banco.exeptions.ValidaContaException;

import java.math.BigDecimal;

public abstract class Conta {

	private BigDecimal saldo;
	private int numeroConta;
	private Agencia agencia;

	public Conta(int numeroConta, BigDecimal saldo, Agencia agencia) {
		if (numeroConta > 0 && saldo.compareTo(BigDecimal.ZERO) > 0 && agencia != null) {
			this.numeroConta = numeroConta;
			this.saldo = saldo;
			this.agencia = agencia;
		}
	}

	public Conta(int numeroConta, Agencia agencia) {
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.saldo = new BigDecimal(100);
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public BigDecimal sacar(BigDecimal valor) {

		if (this.saldo.compareTo(BigDecimal.ZERO) > 0 && valor.compareTo(BigDecimal.ZERO) > 0) {
			this.saldo = this.saldo.subtract(valor);
		}
		return valor;
	}

	public void depositar(BigDecimal valorDeposito) {
		this.verificaValorDoDepositoOuTransferencia(valorDeposito);
		this.saldo.add(valorDeposito);
	}

	private void verificaValorDoDepositoOuTransferencia(BigDecimal valor) {
		if (valor.compareTo(BigDecimal.ZERO) < 0) {
			throw new ValidaContaException("Valores Negativos não são validos para realização do deposito.");
		}
		if (valor.compareTo(BigDecimal.ZERO) == 0) {
			throw new ValidaContaException("Valores Zerados não são validos para realização do deposito.");
		}
	}

	public void transferir(BigDecimal valorTransferido, Conta contaTransferidoValor) {
		this.verificaValorDoDepositoOuTransferencia(valorTransferido);
		String nomeBancoRecebeTransferencia = contaTransferidoValor.getAgencia().getBanco().getNomeBanco();
		String nomeBancoFazTransferencia = this.getAgencia().getBanco().getNomeBanco();

		if (nomeBancoFazTransferencia.equalsIgnoreCase(nomeBancoRecebeTransferencia)) {
			contaTransferidoValor.depositar(this.sacar(valorTransferido));
		} else {
			this.saldo = this.saldo.subtract(BigDecimal.valueOf(20.00));
			contaTransferidoValor.depositar(this.sacar(valorTransferido));
		}
	}

	@Override
	public String toString() {
		return "\nConta{" +
				"saldo: " + saldo +
				", numeroConta: " + numeroConta +
				agencia.toString() +
				'}';
	}
}