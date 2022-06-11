package br.com.banco;

public class Agencia {

  private int numeroAgencia;
  private Endereco endereco;
  private Banco banco;

  public Agencia(int numeroAgencia, Banco banco) {
    this.numeroAgencia = numeroAgencia;
    this.banco = banco;
  }

  public Agencia(int numeroAgencia, Endereco endereco, Banco banco) {
    this.numeroAgencia = numeroAgencia;
    this.endereco = endereco;
    this.banco = banco;
  }

  public int getNumeroAgencia() {
    return numeroAgencia;
  }

  public void setNumeroAgencia(int numeroAgencia) {
    this.numeroAgencia = numeroAgencia;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public Banco getBanco() {
    return banco;
  }

  @Override
  public String toString() {
    return "\nAgencia{" +
        "numero agencia=" + numeroAgencia +
        ", endereço=" + endereco +
        banco.toString() +
        '}';
  }
}