package ArvoreAVL;

public class NodoAVL {

	private NodoAVL direita, esquerda;
	private int hr, hl, numero;

	public NodoAVL insercao(NodoAVL value, int num) {
		NodoAVL nodo;

		if (value == null) {
			nodo = new NodoAVL();
			nodo.numero = num;
			nodo.hr = 0;
			nodo.hl = 0;
			nodo.esquerda = null;
			nodo.direita = null;
			value = nodo;
		}

		else if (num < value.numero) {
			value.esquerda = insercao(value.esquerda, num);

			if (value.esquerda.hr > value.esquerda.hl) {
				value.hl = value.esquerda.hr + 1;
			} else {
				value.hl = value.esquerda.hl + 1;
			}

			value = balancear(value);

		} else {
			value.direita = insercao(value.direita, num);

			if (value.direita.hr > value.direita.hl) {
				value.hr = value.direita.hr + 1;
			} else {
				value.hr = value.direita.hl + 1;
			}

			value = balancear(value);
		}
		return value;
	}

	public void ordenado(NodoAVL value) {
		if (value != null) {
			System.out.print(value.numero + "  ");
			ordenado(value.esquerda);
			ordenado(value.direita);
		}
	}

	public void preOrdenado(NodoAVL value) {
		if (value != null) {
			System.out.print(value.numero + ", ");
			preOrdenado(value.esquerda);
			preOrdenado(value.direita);
		}
	}

	public void posOrdenado(NodoAVL value) {
		if (value != null) {
			posOrdenado(value.esquerda);
			posOrdenado(value.direita);
			System.out.print(value.numero + ", ");
		}
	}

	public NodoAVL balancear(NodoAVL value) {
		int d, df;

		d = value.hr - value.hl;

		if (d == 2) {
			df = value.direita.hr - value.direita.hl;

			if (df >= 0) {
				value = rotacionarEsquerda(value);
			} else {
				value.direita = rotacionarDireita(value.direita);
				value = rotacionarEsquerda(value);
			}
		} else if (d == -2) {
			df = value.esquerda.hr - value.esquerda.hl;
			if (df <= 0) {
				value = rotacionarDireita(value);
			} else {
				value.esquerda = rotacionarEsquerda(value.esquerda);
				value = rotacionarDireita(value);
			}
		}
		return value;
	}

	public NodoAVL rotacionarDireita(NodoAVL value) {
		NodoAVL ax1, ax2;
		ax1 = value.esquerda;
		ax2 = ax1.direita;
		value.esquerda = ax2;
		ax1.direita = value;
		
		if (value.esquerda == null) {
			value.hl = 0;
		} else if (value.esquerda.hl > value.esquerda.hr) {
			value.hl = value.esquerda.hl + 1;
		} else {
			value.hl = value.esquerda.hr + 1;
		}

		if (ax1.direita.hl > ax1.direita.hr) {
			ax1.hr = ax1.direita.hl + 1;
		} else {
			ax1.hr = ax1.direita.hr + 1;
		}
		return ax1;
	}

	public NodoAVL rotacionarEsquerda(NodoAVL value) {
		NodoAVL ax1, ax2;
		ax1 = value.direita;
		ax2 = ax1.esquerda;
		value.direita = ax2;
		ax1.esquerda = value;
		
		if (value.direita == null) {
			value.hr = 0;
		} else if (value.direita.hl > value.direita.hr) {
			value.hr = value.direita.hl + 1;
		} else {
			value.hr = value.direita.hr + 1;
		}

		if (ax1.esquerda.hl > ax1.esquerda.hr) {
			ax1.hl = ax1.esquerda.hl + 1;
		} else {
			ax1.hl = ax1.esquerda.hr + 1;
		}
		return ax1;
	}

}
