package br.com.banco;

import java.math.BigDecimal;

public abstract class Conta {

	private BigDecimal saldo;
	private int numeroConta;
	private Agencia agencia;

	public Conta(int numeroConta, BigDecimal saldo, Agencia agencia) {
		if (numeroConta > 0 && saldo.compareTo(BigDecimal.ZERO) > 0 &&
				agencia != null) {
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

		if (this.saldo.compareTo(BigDecimal.ZERO) > 0 &&
				valor.compareTo(BigDecimal.ZERO) > 0) {
			this.saldo = this.saldo.subtract(valor);
		}
		return valor;
	}

	public BigDecimal depositar(BigDecimal valor) {
		BigDecimal saldoAntesDeposito = this.saldo;
		BigDecimal saldoDepoisDeposito = new BigDecimal(0);

		if (valor.compareTo(BigDecimal.ZERO) > 0) {
			this.saldo = this.saldo.add(valor);
			saldoDepoisDeposito = this.saldo;

			if (saldoDepoisDeposito.compareTo(saldoAntesDeposito) > 0) {
				System.out.println(">>> Deposito realizado com sucesso.");
				return saldoDepoisDeposito;
			} else {
				System.out.println(">>> Deposito não foi realizado.");
				return new BigDecimal(0);
			}
		} else {
			System.out.println(">>> Valores negativos ou zerados não são permitidos.");
			return new BigDecimal(0);
		}
	}

	public void transferir(BigDecimal valor, Conta contaTransferencia) {
		String nomeBancoRecebeTransferencia = contaTransferencia.getAgencia().getBanco().getNomeBanco();
		String nomeBancoFazTransferencia = this.getAgencia().getBanco().getNomeBanco();

		if (nomeBancoFazTransferencia.equalsIgnoreCase(nomeBancoRecebeTransferencia)) {
			System.out.println(">>> Mesmo banco não tem cobrança de taxa extra.");
			contaTransferencia.depositar(this.sacar(valor));
		} else {
			System.out.println(">>> Transferencia para bancos diferentes têm adicional de R$ 10.00");
			this.saldo = this.saldo.subtract(BigDecimal.valueOf(10.00));
			BigDecimal valorTransferido = contaTransferencia.depositar(this.sacar(valor));
			System.out.println(">>> valor transferido: " + valorTransferido);
		}
	}

	@Override
	public String toString() {
		return "Conta{" +
				"saldo=" + saldo +
				", numero conta=" + numeroConta +
				", agencia=" + agencia.toString() +
				'}';
	}
}