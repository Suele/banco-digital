package br.com.banco.exeptions;

public class ValidaContaException extends RuntimeException {
  public ValidaContaException(String message) {
    super(message);
  }
}
