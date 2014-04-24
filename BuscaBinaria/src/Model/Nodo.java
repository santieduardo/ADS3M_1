package Model;

public class Nodo<T extends Comparable<T>> implements Comparable<Nodo<T>> {

	private T element;
	private Nodo<T> next;

	public Nodo(T s, Nodo<T> n) {
		element = s;
		next = n;
	}

	public Nodo(T valor) {
		this.element = valor;
		this.next = null;
	}

	public T getData() {
		return element;
	}

	public void setData(T chave) {
		this.element = chave;
	}

	public Nodo<T> getNext() {
		return next;
	}

	public void setNext(Nodo<T> next) {
		this.next = next;
	}

	@Override
	public int compareTo(Nodo<T> nodo) {
		return element.compareTo(nodo.getData());
	}

}