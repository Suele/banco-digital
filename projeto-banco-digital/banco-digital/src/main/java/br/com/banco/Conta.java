package br.com.banco;

import br.com.banco.exeptions.ValidaContaException;

import java.math.BigDecimal;

public abstract class Conta {

	private final BigDecimal TAXA_TRANSFERENCIA = BigDecimal.valueOf(20.00);
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
		this.saldo = BigDecimal.valueOf(100);
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public BigDecimal getSaldo() {
		return this.saldo;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public BigDecimal sacar(BigDecimal valor) {

		if (this.saldo.compareTo(BigDecimal.ZERO) > 0 && valor.compareTo(BigDecimal.ZERO) > 0) {
			this.saldo = this.saldo.subtract(valor);
			return this.saldo;
		}
		throw new ValidaContaException("Saldo Insuficiente para realização do saque.");
	}

	public void depositar(BigDecimal valorDeposito) {
		this.verificaValorDoDepositoOuTransferencia(valorDeposito);
		this.saldo = this.saldo.add(valorDeposito);
	}

	private void verificaValorDoDepositoOuTransferencia(BigDecimal valor) {
		if (valor.compareTo(BigDecimal.ZERO) < 0) {
			throw new ValidaContaException("Valores Negativos não são validos para realização do deposito.");
		}
		if (valor.compareTo(BigDecimal.ZERO) == 0) {
			throw new ValidaContaException("Valores Zerados não são validos para realização do deposito.");
		}
	}

	public void transferir(BigDecimal valorTransferido, Conta recebeValorTransferido) {
		this.verificaValorDoDepositoOuTransferencia(valorTransferido);

		this.qualEhBanco(recebeValorTransferido);
		recebeValorTransferido.depositar(this.sacar(valorTransferido));
	}

	public BigDecimal qualEhBanco(Conta contaRecebeValorTransferido) {
		String bancoRecebeTransferencia = contaRecebeValorTransferido.getAgencia().getBanco().getNomeBanco();
		String bancoFazTransferencia = this.getAgencia().getBanco().getNomeBanco();

		if (bancoFazTransferencia.equalsIgnoreCase(bancoRecebeTransferencia)) {
			return BigDecimal.valueOf(0);
		} else {
			this.saldo = this.saldo.subtract(TAXA_TRANSFERENCIA);
			return TAXA_TRANSFERENCIA;
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