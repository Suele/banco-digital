# Banco Digital
Software que simula operações bancarias que são realizadas nos terminais,
mais conhecidos como ATM.

## Funcionalidades Desenvolvidas
- [X] Verificar o saldo.
- [X] Fazer deposito na sua conta.
- [X] Realizar transferência de valores para outra conta.

## Cenários de Testes

### Deposito
- Deposito na propria conta.
- Deposito na conta de outro cliente.


### Transferência
- A conta que será transferido o valor **existe** ou **não**.
- O valor retirado da **Conta A** foi depositado na **Conta B**.
- **Conta A** e **Conta B** são contas de bancos diferentes,
então têm uma taxa de R$ 10,00 que será cobrada de quem transfere.
- Não cobrar a taxa de R$ 10,00 para contas do mesmo banco.