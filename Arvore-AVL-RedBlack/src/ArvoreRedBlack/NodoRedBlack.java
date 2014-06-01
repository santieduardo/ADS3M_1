package ArvoreRedBlack;

public class NodoRedBlack<T extends Comparable<T>> {
	private NodoRedBlack<T> parente;
	private NodoRedBlack<T> direita;
	private NodoRedBlack<T> esquerda;
	private boolean cor;
	private T valor;

	public NodoRedBlack(NodoRedBlack<T> direita, NodoRedBlack<T> esquerda, T valor, boolean cor) {
		this.direita = direita;
		this.esquerda = esquerda;
		this.cor = cor;
		this.valor = valor;
		if (direita != null) {
			direita.parente = this;
		}
		if (esquerda != null) {
			esquerda.parente = this;
		}
		this.parente = null;
	}

	
	public void imprimir() {
		String color = "";
		
		if(isCor() == true){
			color = "V";
		}
		
		else{
			color = "B";
		}
				
		System.out.print("( " + valor + " " + color + "\n");

		if (esquerda != null) {

			esquerda.imprimir();
		}

		else {
			System.out.print("( )");
		}

		if (direita != null) {

			direita.imprimir();
		}

		else {
			System.out.print("( )");
		}
	}

	public NodoRedBlack<T> avo() {
		return parente.parente;
	}

	public NodoRedBlack<T> irmao() {
		if (this == parente.esquerda) {
			return parente.direita;
		} else {
			return parente.esquerda;
		}
	}

	public NodoRedBlack<T> tio() {
		return parente.irmao();
	}

	public NodoRedBlack<T> getParente() {
		return parente;
	}

	public void setParente(NodoRedBlack<T> parente) {
		this.parente = parente;
	}

	public NodoRedBlack<T> getDireita() {
		return direita;
	}

	public void setDireita(NodoRedBlack<T> direita) {
		this.direita = direita;
	}

	public NodoRedBlack<T> getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(NodoRedBlack<T> esquerda) {
		this.esquerda = esquerda;
	}

	public boolean isCor() {
		return cor;
	}

	public void setCor(boolean cor) {
		this.cor = cor;
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

}
