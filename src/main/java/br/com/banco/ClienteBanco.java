package br.com.banco;

import java.math.BigDecimal;
import java.util.Scanner;

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


		Scanner dadosDeEntrada = new Scanner(System.in);

		int finaliza = -1;

		while (finaliza != 0) {

			System.out.println("\n==========================================");
			System.out.println("============ Menu Principal ==================");
			System.out.println("1 - Verificar o Saldo");
			System.out.println("2 - Depositar");
			System.out.println("3 - Transferir");
			System.out.println("4 - Finalizar acesso a conta");

			int opcao = dadosDeEntrada.nextInt();
			BigDecimal valor;

			switch (opcao) {
				case 1:
					System.out.println(">>> Saldo disponível para Saque R$ " + contaCorrente.getSaldo());
					break;
				case 2:
					System.out.println("\n");
					System.out.println("=======================================================");
					System.out.println("============ Escolha uma das opções abaixo ================");
					System.out.println("5 - Depositar na sua conta?");
					System.out.println("6 - Depositar em outra conta?");
					System.out.println("7 - Finalizar acesso a conta \n");

					int opcaoDeposito = dadosDeEntrada.nextInt();

					switch (opcaoDeposito) {
						case 5:
							System.out.println("5 - Depositar na sua conta");
							System.out.println(">>> Seu Saldo Atual R$ " + contaCorrente.getSaldo());
							System.out.print("Valor do Deposito: ");
							valor = dadosDeEntrada.nextBigDecimal();
							contaCorrente.depositar(valor);
							System.out.println(">>>Seu Novo Saldo R$ " + contaCorrente.getSaldo());
							break;
						case 6:
							System.out.println("6 - Deposito em outra conta");
							System.out.print("Digite o número da conta: ");
							int numeroConta = dadosDeEntrada.nextInt();

							ContaCorrente outraConta = new ContaCorrente(numeroConta, agencia);
							System.out.print("Digite o valor do Deposito: ");
							valor = dadosDeEntrada.nextBigDecimal();
							outraConta.depositar(valor);
							break;
						case 7:
							System.out.println("7 - Finalizar o acesso.");
							finaliza = 0;
							System.out.println("Acesso ao Banco Encerrado.....");
							System.exit(0);
							break;
					}
					break;

				case 3:
					System.out.println(">>> Saldo Atual R$ " + contaCorrente.getSaldo());
					System.out.print("Valor do Deposito: ");
					valor = dadosDeEntrada.nextBigDecimal();
					contaCorrente.transferir(BigDecimal.valueOf(100), contaPoupanca);
					System.out.println(">>> Novo Atual R$ " + contaCorrente.getSaldo());
					break;

				case 4:
					finaliza = 0;
					System.out.println("Acesso ao Banco Encerrado.....");
					System.exit(0);
					break;
			}
			dadosDeEntrada.reset();
		}
	}
}