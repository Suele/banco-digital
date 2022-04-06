# Banco Digital
Software que simula operações bancarias que são realizadas nos terminais,
mais conhecidos como ATM.

## Funcionalidades do Banco Digital
- [X] Verificar o saldo.
- [X] Fazer depósito na sua conta.
- [X] Realizar transferência de valores para outra conta.
- [ ] Adicionar no menu **cadastro de novos clientes** o tipo de conta 
que o cliente quer abrir, corrente ou poupança.

## Cenários de Testes

### Depósito
- Depósito na propria conta.
- Depósito na conta de outro cliente.

### Transferência
- A conta que será transferido o valor **existe** ou **não**.
- O valor retirado da **Conta A** foi depositado na **Conta B**.
- **Conta A** e **Conta B** são contas de bancos diferentes,
então têm uma taxa de R$ 10,00 que será cobrada de quem transfere.
- Não cobrar a taxa de R$ 10,00 para contas do mesmo banco.

## Testes Unitarios
Para realizar os testes unitários será adicionado no arquivo pom.xml como dependência o JUnit 5.

### O que será testado?
#### Depósito
- [X] Depósito realizada com sucesso.
- [X] Depósito com valor zerado na conta.
- [X] Depósito valor negativo na conta.

#### Transferência
- [ ] Transferência realizada com sucesso.
- [ ] Transferência para uma conta que não exista.
- [ ] Saldo insuficiente para realizar a transferência.