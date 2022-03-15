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

		int finalizarLoop = -1;

		while (finalizarLoop != 0) {

			System.out.println("\n");
			System.out.println("=================================================");
			System.out.println("================= Menu Principal ===================");
			System.out.println("============ Selecione uma das opções ==============");
			System.out.println("1 - Abrir uma conta");
			System.out.println("2 - Entrar na minha conta");
			System.out.println("3 - Sair");

			System.out.println("\n");
			System.out.print(">>>>> Digite o número da sua opção: ");
			int opcao = dadosDeEntrada.nextInt();

			BigDecimal valor;

			switch (opcao) {
				case 1:
					System.out.println("Opção escolhida 1 - Abrir uma conta");
					break;
				case 2:
					System.out.println("========== Você está acessando a sua conta ==============");
					System.out.println("============ Selecione uma das opções ==============");
					System.out.println("1 - Verificar o Saldo");
					System.out.println("2 - Fazer Deposito");
					System.out.println("3 - Fazer Transferencia");

					System.out.print(">>>>> Digite o número da sua opção: ");
					int opcaoDaMinhaConta = dadosDeEntrada.nextInt();
					System.out.println("\n");

					switch (opcaoDaMinhaConta) {
						case 1:
							System.out.println(" ========= Opção escolhida 1 - Verificar o Saldo ============");
							System.out.println(">>> Saldo disponível para Saque R$ " + contaCorrente.getSaldo());
							break;
						case 2:
							System.out.println("\n");
							System.out.println("=======================================================");
							System.out.println("======================= Deposito ========================");
							System.out.println("5 - Depositar na sua conta?");
							System.out.println("6 - Depositar em outra conta?");
							System.out.println("7 - Finalizar acesso a conta \n");

							System.out.print(">>>>> Digite o número da sua opção: ");
							int opcaoDeposito = dadosDeEntrada.nextInt();

							switch (opcaoDeposito) {
								case 5:
									System.out.println("5 - Depositar na sua conta");
									System.out.println(">>> Seu Saldo Atual R$ " + contaCorrente.getSaldo());
									System.out.print("Valor do Deposito: ");
									valor = dadosDeEntrada.nextBigDecimal();
									contaCorrente.depositar(valor);
									System.out.println(">>> Seu Novo Saldo R$ " + contaCorrente.getSaldo());
									break;
								case 6:
									System.out.println("6 - Deposito em outra conta");
									System.out.print(">>> Digite o número da conta: ");
									int numeroConta = dadosDeEntrada.nextInt();

									ContaCorrente outraConta = new ContaCorrente(numeroConta, agencia);
									System.out.print(">>> Digite o valor do Deposito: ");
									valor = dadosDeEntrada.nextBigDecimal();
									outraConta.depositar(valor);
									break;
								case 7:
									System.out.println("7 - Finalizar o acesso.");
									finalizarLoop = 0;
									System.out.println("Encerrado acesso a sua conta.....");
									System.exit(0);
									break;
							}
							break;

						case 3:
							System.out.println("\n");
							System.out.println("=======================================================");
							System.out.println("===================== Transferencia ======================");
							System.out.println("1 - Para o mesmo banco.");
							System.out.println("2 - Para outro banco. \n");

							System.out.print(">>>>> Digite o número da sua opção: ");
							int opcaoTransferencia = dadosDeEntrada.nextInt();

							switch (opcaoTransferencia) {
								case 1:
									System.out.println("Opção escolhida 1 - Para o mesmo banco da sua conta.");
									System.out.println(">>> Seu Saldo Atual R$ " + contaCorrente.getSaldo());

									System.out.print(">>> Digite o número da Conta: ");
									int numeroConta = dadosDeEntrada.nextInt();

									System.out.print(">>> Digite o valor do Deposito: ");
									valor = dadosDeEntrada.nextBigDecimal();

									ContaCorrente contaCorrenteTransferencia = new ContaCorrente(numeroConta, agencia);

									contaCorrente.transferir(valor, contaCorrenteTransferencia);
									System.out.println(">>> Seu saldo apos a transferencia R$ " + contaCorrente.getSaldo());
									break;
								case 2:
									System.out.println("Opção escolhida 2 - Para outro banco.");
									System.out.println("A Transferencia de valores para outro banco é cobrado uma taxa de R$ 10,00");
									break;
							}
							break;
					}
					break;

				case 3:
					System.out.println("Opção escolhida 3 - Sair");
					finalizarLoop = 0;
					System.exit(0);
					break;
			}
			dadosDeEntrada.reset();
		}
	}
}