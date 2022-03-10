package br.com.banco;

import java.math.BigDecimal;

public class ClienteBanco {
	public static void main(String[] args) {

		Endereco enderecoCliente = new Endereco("Martins Felix Berta", 1050,
				"Rubem Berta", "91250200", "Porto Alegre",
				"Rio Grande do Sul", TipoEndereco.MINHA_CASA);

		Endereco enderecoAgencia = new Endereco("RAMIRO BARCELOS", 1865,
				"Rio Branco", "90035006", "Porto Alegre",
				"Rio Grande do Sul", TipoEndereco.AGENCIA);

		Banco banco = new Banco("Itaú Unibanco Holding S.A", "60872504000123");

		Agencia agencia = new Agencia(1232L, enderecoAgencia, banco);

		banco.adicionaAgencia(agencia);

		ContaCorrente contaCorrente = new ContaCorrente(1111, new BigDecimal(1000), agencia);

		Cliente cliente = new Cliente("Suele Guimarães", "00000000000", enderecoCliente, contaCorrente);

		ContaPoupanca contaPoupanca = new ContaPoupanca(22222, new BigDecimal(10), agencia);

		contaCorrente.transferir(BigDecimal.valueOf(100), contaPoupanca);

		System.out.println("\n >>> cliente: " + cliente + "\n");
		System.out.println(">>> conta corrente: " + contaCorrente + "\n");
		System.out.println(">>> conta poupança: " + contaPoupanca);
	}
}