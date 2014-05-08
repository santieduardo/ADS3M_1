package model;

public class Pessoa {

	private String nome;
	private int fone;
	
	public void setTelefone(int telefone) {
		fone = telefone;
	}
	
	public int getTelefone() {
		return fone;
	}	

	public void setNome(String s) {
		nome = s;
	}

	public String getNome() {
		return nome;
	}
}
