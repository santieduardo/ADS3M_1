package model;

public class Navio {

	private String tipo;
	private String dado;
	private String view;

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setDado(String dado) {
		this.dado = dado;
	}

	public String getDado() {
		return this.dado;
	}

	public String getVisual() {
		return this.view;
	}

	public void setVisual(String view) {
		this.view = view;
	}
}