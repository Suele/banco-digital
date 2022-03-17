package br.com.banco;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private String nomeBanco;
	private String CNPJ;
	private List<Agencia> agencias;

	public Banco(String nomeBanco, String CNPJ) {
		this.nomeBanco = nomeBanco;
		this.CNPJ = CNPJ;
		this.agencias = new ArrayList<>();
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void adicionaAgencia(Agencia agencia) {
		agencias.add(agencia);
	}

	public List<Agencia> listaDeAgencias() {
		return this.agencias;
	}

	@Override
	public String toString() {
		return "Banco{" +
				"banco='" + nomeBanco + '\'' +
				", CNPJ='" + CNPJ + '\'' +
				'}';
	}
}
