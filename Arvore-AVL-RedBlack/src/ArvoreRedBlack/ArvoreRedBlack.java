package ArvoreRedBlack;

public class ArvoreRedBlack<T extends Comparable<T>> {

	private NodoRedBlack<T> raiz;

	public ArvoreRedBlack() {
		raiz = null;
	}

	
	private void rotarEsquerda(NodoRedBlack<T> n) {
		NodoRedBlack<T> direita = n.getDireita();
		substituirNodo(n, direita);
		n.setDireita(direita.getEsquerda());
		
		if (direita.getEsquerda() != null) {
			direita.getEsquerda().setParente(n);
		}
		direita.setEsquerda(n);
		n.setParente(direita);
	}

	
	private void rotarDireita(NodoRedBlack<T> n) {
		NodoRedBlack<T> esquerda = n.getEsquerda();
		substituirNodo(n, esquerda);
		n.setEsquerda(esquerda.getDireita());
		
		if (esquerda.getDireita() != null) {
			esquerda.getDireita().setParente(n);
		}
		esquerda.setDireita(n);
		n.setParente(esquerda);
	}

	
	private void substituirNodo(NodoRedBlack<T> o, NodoRedBlack<T> n) {
		if (o.getParente() == null) {
			raiz = n;
		} else {
			if (o == o.getParente().getEsquerda()) {
				o.getParente().setEsquerda(n);
			} else {
				o.getParente().setDireita(n);
			}
		}
		if (n != null) {
			n.setParente(o.getParente());
		}
	}

	
	public void inserir(T valor) {
		NodoRedBlack<T> node = new NodoRedBlack<T>(null, null, valor, false);
		if (raiz == null) {
			raiz = node;
		} else {
			NodoRedBlack<T> n = raiz;
			
			while (true) {
				int cmp = valor.compareTo(n.getValor());
				if (cmp == 0) {
					n.setValor(valor);
					return;
				} else if (cmp < 0) {
					if (n.getEsquerda() == null) {
						n.setEsquerda(node);
						break;
					} else {
						n = n.getEsquerda();
					}
				} else {
					if (n.getDireita() == null) {
						n.setDireita(node);
						break;
					} else {
						n = n.getDireita();
					}
				}
			}
			node.setParente(n);
		}
		case1(node);
	}

	
	private void case1(NodoRedBlack<T> n) {
		if (n.getParente() == null) {
			n.setCor(true);
		} else {
			case2(n);
		}
	}

	
	private void case2(NodoRedBlack<T> n) {
		if (n.getParente().isCor() == true) {
			return;
		} else {
			case3(n);
		}
	}

	
	private void case3(NodoRedBlack<T> n) {
		if (n.tio().isCor() == false) {
			n.getParente().setCor(true);
			n.tio().setCor(true);
			n.avo().setCor(false);
			case1(n.avo());
		} else {
			case4(n);
		}
	}

	
	private void case4(NodoRedBlack<T> n) {
		if (n == n.getParente().getDireita()
				&& n.getParente() == n.avo().getEsquerda()) {
			rotarEsquerda(n.getParente());
			n = n.getEsquerda();
		} else if (n == n.getParente().getEsquerda()
				&& n.getParente() == n.avo().getDireita()) {
			rotarDireita(n.getParente());
			n = n.getDireita();
		}
		case5(n);
	}

	
	private void case5(NodoRedBlack<T> n) {
		n.getParente().setCor(true);
		n.avo().setCor(false);
		if (n == n.getParente().getEsquerda()
				&& n.getParente() == n.avo().getEsquerda()) {
			rotarDireita(n.avo());
		} else {
			rotarEsquerda(n.avo());
		}
	}

	
	public void imprimirNodos() {
		raiz.imprimir();
	}
}
