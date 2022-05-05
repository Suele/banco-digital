# Banco Digital
Software que simula operações bancarias realizadas nos terminais,
mais conhecidos como ATM.

## Funcionalidades do Banco Digital
- [X] Verificar o saldo.
- [X] Fazer depósito na sua conta.
- [X] Realizar transferência de valores para outras contas.
- [X] Cliente pode abrir conta **poupança** ou **corrente**. 

## Cenários de Testes

### Depósito
- Depósito na propria conta.
- Depósito na conta de outro cliente.

### Transferência
- A conta que será transferido o valor **existe** ou **não**.
- O valor retirado da **Conta A** foi depositado na **Conta B**.
- **Conta A** e **Conta B** são contas de bancos diferentes,
então têm uma taxa de R$ 20,00 que será cobrada de quem transfere.
- Não cobrar a taxa de R$ 20,00 para contas do mesmo banco.

## Testes Unitarios
Para realizar os testes unitários serão adicionados no arquivo pom.xml como dependência o JUnit 5.

### O que será testado?
#### Depósito
- [X] Depósito realizada com sucesso.
- [X] Depósito com valor zerado na conta.
- [X] Depósito valor negativo na conta.

#### Transferência
- [X] Cobrança da taxa de transferência para bancos diferentes.
- [X] Não cobrar taxa de transferência para contas do mesmo banco.
- [ ] Transferência realizada com sucesso.
- [ ] Transferência para uma conta que não exista.
- [ ] Saldo insuficiente para realizar a transferência.

## Banco de Dados
O banco de dados utilizado SQL Server em um container docker.
O passo a passo para executar o banco de dados em linha de comando foi
seguido no site da Microsoft 
https://docs.microsoft.com/pt-br/sql/linux/quickstart-install-connect-docker?view=sql-server-ver15&pivots=cs1-bash
