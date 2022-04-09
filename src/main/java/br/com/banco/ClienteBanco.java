package br.com.banco;

import br.com.banco.exeptions.ValidaContaException;

import java.math.BigDecimal;
import java.util.Scanner;

public class ClienteBanco {
	public static Boolean eUmNumero(String dadoInseridoPeloUsuario) {
		boolean ehNumeroNegativo = dadoInseridoPeloUsuario.contains("-");

		if (ehNumeroNegativo) {
			String ehNumeroPositivo = dadoInseridoPeloUsuario.replaceFirst("-", "");
			return ehNumeroPositivo.chars().allMatch(Character::isDigit);
		}
		return dadoInseridoPeloUsuario.chars().allMatch(Character::isDigit);
	}

	public static Integer numerosInteiros(String dadoInseridoPeloUsuario) {
		if (eUmNumero(dadoInseridoPeloUsuario))
			return new Integer(dadoInseridoPeloUsuario);
		return null;
	}

	public static BigDecimal numerosDecimais(String dadoInseridoPeloUsuario) {
		if (eUmNumero(dadoInseridoPeloUsuario))
			return new BigDecimal(dadoInseridoPeloUsuario);
		return null;
	}

	public static void main(String[] args) {

		Endereco enderecoCliente = new Endereco("Martins Felix Berta", 1050,
				"Rubem Berta", "91250200", "Porto Alegre",
				"Rio Grande do Sul", TipoEndereco.MINHA_CASA);

		Endereco enderecoAgencia = new Endereco("RAMIRO BARCELOS", 1865,
				"Rio Branco", "90035006", "Porto Alegre",
				"Rio Grande do Sul", TipoEndereco.AGENCIA);

		Banco banco = new Banco("Itaú Unibanco Holding S.A", "60872504000123");

		Agencia agencia = new Agencia(1232, enderecoAgencia, banco);

		banco.adicionaAgencia(agencia);

		ContaCorrente contaCorrente = new ContaCorrente(1111, new BigDecimal(1000), agencia);

		Cliente cliente = new Cliente("Suele Guimarães", "00000000000", enderecoCliente, contaCorrente);

		ContaPoupanca contaPoupanca = new ContaPoupanca(22222, new BigDecimal(10), agencia);


		Scanner dadoDoTipoNumerico = new Scanner(System.in);
		Scanner dadoDoTipoString = new Scanner(System.in);

		int finalizarLoop = -1;
		while (finalizarLoop != 0) {

			System.out.println("\n");
			System.out.println("==========================================================");
			System.out.println("================= Menu Principal =========================");
			System.out.println("============ Selecione uma das opções abaixo =============");
			System.out.println("==========================================================");
			System.out.println("1 - Abrir uma conta");
			System.out.println("2 - Entrar na minha conta");
			System.out.println("3 - Sair");
			System.out.println("\n");

			System.out.print(">>>>> Digite o número da opção escolhida: ");
			Integer opcao = numerosInteiros(dadoDoTipoString.nextLine());

			BigDecimal valor;

			try {
				switch (opcao) {
					case 1:
						System.out.println("\n");
						System.out.println("===============================================================");
						System.out.println("============ Opção escolhida 1 - Abrir uma conta ==============");
						System.out.println("===============================================================");
						System.out.println("Por Favor Preencha os dados como solicitados");
						System.out.println("");

						System.out.println("Dados Pessoais do Cliente");
						System.out.print(">>> Nome Completo: ");
						String nomeCompleto = dadoDoTipoString.nextLine();

						System.out.print(">>> CPF: ");
						String cpf = dadoDoTipoString.nextLine();

						System.out.println("");

						System.out.println("Endereço");
						System.out.print(">>> Rua/Avenida: ");
						String nome = dadoDoTipoString.nextLine();

						System.out.print(">>> Número: ");
						Integer numero = numerosInteiros(dadoDoTipoString.nextLine());

						System.out.print(">>> Bairro: ");
						String bairro = dadoDoTipoString.nextLine();

						System.out.print(">>> CEP: ");
						String CEP = dadoDoTipoString.nextLine();

						System.out.print(">>> Cidade: ");
						String cidade = dadoDoTipoString.nextLine();

						System.out.print(">>> Estado: ");
						String estado = dadoDoTipoString.nextLine();

						System.out.println("Qual o tipo do endereço cadastrado?\n" +
								"\tTRABALHO,\n" +
								"\tMINHA_CASA,\n" +
								"\tCASA_SOGRA,\n" +
								"\tCASA_MAE,\n" +
								"\tMATRIZ,\n" +
								"\tAGENCIA");
						System.out.print(">>> ");
						String tipo = dadoDoTipoString.nextLine();
						TipoEndereco tipoEndereco = TipoEndereco.valueOf(tipo.toUpperCase());

						System.out.println("\n");
						System.out.println("======================================================================");
						System.out.println("============ Qual o tipo de Conta que você deseja abrir? ==============");
						System.out.println("============== Escolha uma das opções abaixo ==========================");
						System.out.println("================== 1 - Conta Corrente ==================================");
						System.out.println("================== 2 - Conta Poupança ==================================");
						System.out.println("=======================================================================");
						System.out.println("\n");

						Endereco enderecoNovoCliente = new Endereco(nome, numero, bairro, CEP, cidade, estado, tipoEndereco);
						Conta novaConta = null;

						Integer opcaoTipoConta = numerosInteiros(dadoDoTipoString.nextLine());
						System.out.println(">>> Digite aqui a sua opção: ");
						System.out.println("\n");

						switch (opcaoTipoConta) {
							case 1:
								System.out.println("===============================================================");
								System.out.println("============ Opção escolhida 1 - Conta Corrente =====================");
								System.out.println("===============================================================");
								novaConta = new ContaCorrente(1111, agencia);
								System.out.println(novaConta.getClass().toString().substring(19));

								break;
							case 2:
								System.out.println("===============================================================");
								System.out.println("=========== Opção escolhida 2 - Conta Poupança =====================");
								System.out.println("===============================================================");
								novaConta = new ContaPoupanca(1111, new BigDecimal(1000d), agencia);
								break;
						}
						Cliente novoCliente = new Cliente(nomeCompleto, cpf, enderecoNovoCliente, novaConta);

						System.out.println("\n");
						System.out.println(">>> Novo Cliente Cadastrado: " + novoCliente.toString());
						System.out.println("\n");
						break;
					case 2:
						System.out.println("===============================================================");
						System.out.println("================ Você está acessando a sua conta ===================");
						System.out.println("=================== Selecione uma das opções =====================");
						System.out.println("===============================================================");
						System.out.println("1 - Verificar o Saldo");
						System.out.println("2 - Fazer Deposito");
						System.out.println("3 - Fazer Transferencia");
						System.out.println("===============================================================");

						System.out.print(">>>>> Digite o número da sua opção: ");
						Integer opcaoDaMinhaConta = numerosInteiros(dadoDoTipoString.nextLine());
						System.out.println("\n");

						switch (opcaoDaMinhaConta) {
							case 1:
								System.out.println(" ========= Opção escolhida 1 - Verificar o Saldo ============");
								System.out.println(">>> Saldo disponível para Saque R$ " + contaCorrente.getSaldo());
								System.out.println("\n");
								break;
							case 2:
								System.out.println("=======================================================");
								System.out.println("======================= Deposito ========================");
								System.out.println("5 - Depositar na sua conta?");
								System.out.println("6 - Depositar em outra conta?");
								System.out.println("7 - Finalizar acesso a conta \n");

								System.out.print(">>>>> Digite o número da sua opção: ");
								Integer opcaoDeposito = numerosInteiros(dadoDoTipoString.nextLine());

								switch (opcaoDeposito) {
									case 5:
										System.out.println("\n");
										System.out.println("5 - Depositar na sua conta");
										System.out.println(">>> Seu Saldo Atual R$ " + contaCorrente.getSaldo());
										System.out.print("Valor do Deposito: ");

										try {
											valor = numerosDecimais(dadoDoTipoString.nextLine());
											contaCorrente.depositar(valor);
											System.out.println(">>> Seu Novo Saldo R$ " + contaCorrente.getSaldo());
										} catch (ValidaContaException e) {
											System.out.println(e.getMessage());
										}
										break;
									case 6:
										System.out.println("\n");
										System.out.println("6 - Deposito em outra conta");
										System.out.print(">>> Digite o número da conta: ");
										Integer numeroConta = numerosInteiros(dadoDoTipoString.nextLine());

										ContaCorrente outraConta = new ContaCorrente(numeroConta, agencia);
										System.out.print(">>> Digite o valor do Deposito: ");
										valor = numerosDecimais(dadoDoTipoString.nextLine());
										try {
											outraConta.depositar(valor);
										} catch (ValidaContaException e) {
											System.out.println(e.getMessage());
										}
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
								System.out.println(">>> Seu Saldo Atual R$ " + contaCorrente.getSaldo());

								System.out.print(">>> Digite o número da Conta: ");
								Integer numeroConta = numerosInteiros(dadoDoTipoString.nextLine());

								System.out.print(">>> Digite o valor do Deposito: ");
								valor = numerosDecimais(dadoDoTipoString.nextLine());

								// bancos iguais
								//Banco banco1 = new Banco("Itaú Unibanco Holding S.A", "60872504000123");
								Banco banco1 = new Banco("Banco do Brasil", "00000000000191");
								Agencia agencia1 = new Agencia(111, banco1);
								ContaCorrente contaCorrenteTransferencia = new ContaCorrente(numeroConta, agencia1);

								try {
									contaCorrente.transferir(valor, contaCorrenteTransferencia);
									System.out.println(">>> Seu saldo apos a transferencia R$ " + contaCorrente.getSaldo());
								} catch (ValidaContaException e) {
									System.out.println(e.getMessage());
								}
								break;
						}
						break;
					case 3:
						System.out.println("Opção escolhida 3 - Sair");
						finalizarLoop = 0;
						dadoDoTipoNumerico.close();
						dadoDoTipoString.close();
						System.exit(0);
				}

			} catch (NullPointerException nullPointerException) {
				System.out.println(">>> O valor digitado não é valido, por favor siga as instruções solicitadas.");
			}
			dadoDoTipoNumerico.reset();
			dadoDoTipoString.reset();
		}
	}
}