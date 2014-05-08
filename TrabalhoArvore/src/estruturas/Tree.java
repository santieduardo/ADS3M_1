package estruturas;

public class Tree {

	private Nodo raiz;

	public Tree(Nodo r) {
		this.raiz = r;
	}

	public void setRaiz(Nodo r) {
		this.raiz = r;
	}

	public Nodo getRaiz() {
		return this.raiz;
	}

	public void inserir(String valor) {
		Nodo aux = raiz;
		Nodo novo = new Nodo(valor);

		while (aux != null) {
			if (valor.length() > aux.getValue()) {
				if (aux.getRight() != null){
					aux = aux.getRight();
				}
				else {
					aux.setRight(novo);
					aux = null;
				}
			} else {
				if (aux.getLeft() != null){
					aux = aux.getLeft();
				}
				else {
					aux.setLeft(novo);
					aux = null;
				}
			}
		}
	}

	public void ordenarPre(Nodo elemento) {
		if (elemento != null) {
			System.out.println(elemento.getValueOrigin() + "\n");
			if (elemento.verificar()) {
				ordenarPre(elemento.getLeft());
				ordenarPre(elemento.getRight());
			}
		}
	}

	public void ordenarPos(Nodo elemento) {
		if (elemento != null) {
			if (elemento.verificar()) {
				ordenarPos(elemento.getLeft());
				ordenarPos(elemento.getRight());
			}
			System.out.println(elemento.getValueOrigin() + "\n");
		}
	}

	public void ordenarIn(Nodo elemento) {
		if (elemento != null) {
			if (elemento.verificar()) {
				ordenarIn(elemento.getLeft());
			}
			System.out.println(elemento.getValueOrigin() + "\n");
			if (elemento.verificar()) {
				ordenarIn(elemento.getRight());
			}
		}
	}

	public int heightTree() {
		return calcHeightTree(this.raiz, 0);
	}

	private int calcHeightTree(Nodo elemento, int height) {
		if (elemento != null) {
			if (elemento.verificar()) {
				int auxa = calcHeightTree(elemento.getLeft(), height + 1);
				int auxb = calcHeightTree(elemento.getRight(), height + 1);
				
				if (auxa > auxb){
					return auxa;
				}
				else{
					return auxb;
				}
			} else {
				return height;
			}
		}
		return 0;
	}

}
