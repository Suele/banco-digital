package br.com.banco;

public class Agencia {

	private Long numeroAgencia;
	private Endereco endereco;
	private Banco banco;

	public Agencia() {
	}

	public Agencia(Long numeroAgencia, Endereco endereco, Banco banco) {
		this.numeroAgencia = numeroAgencia;
		this.endereco = endereco;
		this.banco = banco;
	}

	public Long getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(Long numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Agencia{" +
				"numero agencia=" + numeroAgencia +
				", endereço=" + endereco +
				", banco=" + banco.toString() +
				'}';
	}
}