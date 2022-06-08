package br.com.banco;

public class Endereco {

	private String nome;
	private int numero;
	private String bairro;
	private String CEP;
	private String cidade;
	private String estado;
	private TipoEndereco tipoEndereco;

	public Endereco() {
	}

	public Endereco(String nome, int numero, String bairro, String CEP, String cidade, String estado, TipoEndereco tipoEndereco) {
		this.nome = nome;
		this.numero = numero;
		this.bairro = bairro;
		this.CEP = CEP;
		this.cidade = cidade;
		this.estado = estado;
		this.tipoEndereco = tipoEndereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String CEP) {
		this.CEP = CEP;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	@Override
	public String toString() {
		return "\nEndereco{" +
				"rua/avenida: '" + nome + '\'' +
				", numero: " + numero +
				", bairro: " + bairro + '\'' +
				", CEP: '" + CEP + '\'' +
				", cidade: " + cidade + '\'' +
				", estado: '" + estado + '\'' +
				", tipoDoEndereco: " + tipoEndereco +
				'}';
	}
}