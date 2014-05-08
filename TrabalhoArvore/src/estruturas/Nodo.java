package estruturas;

public class Nodo {

	private String value;
	private Nodo right;
	private Nodo left;

	public Nodo(String v) {
		value = v;
		right = null;
		left = null;
	}

	public void setValor(String s) {
		value = s;
	}

	public void setLeft(Nodo n) {
		left = n;
	}

	public void setRight(Nodo n) {
		right = n;
	}

	public int getValue() {
		return value.length();
	}

	public String getValueOrigin() {
		return value;
	}

	public Nodo getLeft() {
		return left;
	}

	public Nodo getRight() {
		return right;
	}

	public boolean verificar() {
		if ((left != null) || (right != null)){
			return true;
		}
		return false;
	}

}