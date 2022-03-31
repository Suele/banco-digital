package br.com.banco;

import br.com.banco.exeptions.ValidaContaException;

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

	public void depositar(BigDecimal valorDeposito) {
		this.verificaValorDoDepositoOuTransferencia(valorDeposito);

		BigDecimal saldoAtual = this.saldo;
		BigDecimal novoSaldo = this.saldo.add(valorDeposito);
		this.saldo = novoSaldo;
		this.verificaDepositoFoiRealizado(saldoAtual, novoSaldo);
	}

	public void verificaDepositoFoiRealizado(BigDecimal saldoAtual, BigDecimal novoSaldo) {
		if (saldoAtual.compareTo(novoSaldo) > 0) {
			throw new ValidaContaException("Deposito não foi realizado.");
		}
	}

	private void verificaValorDoDepositoOuTransferencia(BigDecimal valor) {
		if (valor.compareTo(BigDecimal.ZERO) < 0) {
			throw new ValidaContaException("Valores Negativos não são validos para realização do deposito.");
		}
		if (valor.compareTo(BigDecimal.ZERO) == 0) {
			throw new ValidaContaException("Valores Zerados não são validos para realização do deposito.");
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
			contaTransferencia.depositar(this.sacar(valor));
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