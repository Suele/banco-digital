package br.com.banco;

public class Cliente {

	private String nome;
	private String CPF;
	private Endereco endereco;
	private Conta conta;

	public Cliente(String nome, String CPF, Endereco endereco, Conta conta) {
		if (!nome.isBlank() && !CPF.isBlank() && endereco != null && conta != null) {
			this.nome = nome;
			this.CPF = CPF;
			this.endereco = endereco;
			this.conta = conta;
		}
	}

	public String getNome() {
		return nome;
	}

	public String getCPF() {
		return CPF;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Cliente{" +
				"nome='" + nome + '\'' +
				", CPF='" + CPF + '\'' +
				", endereço=" + endereco.toString() +
				", conta=" + conta.toString() +
				'}';
	}
}