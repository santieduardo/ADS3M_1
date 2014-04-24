package Controller;

import java.awt.Menu;
import java.util.Arrays;
import java.util.Scanner;

import Model.Nodo;

public class ListaEncadeada<T extends Comparable<T>> {

	private Scanner sc;
	private Nodo<T> head;
	private Nodo<T> tail;
	private String vetConv[];

	public ListaEncadeada() {
		head = null;
		tail = null;
	}

	public void converter(Nodo<T> nodo, int tam) {
		vetConv = new String[tam];
		for (int insert = 0; insert < vetConv.length; insert++) {
			vetConv[insert] = String.valueOf(nodo.getData());
			nodo = nodo.getNext();
		}
	}

	public void ordenar() {
		Arrays.sort(vetConv);
	}

	public void pesquisarFormaBinaria() {

		sc = new Scanner(System.in);

		int comeco, meio = 0, fim;
		boolean acha = false;
		String pesquisa = "";

		do {
			System.out.println("\nEntre com o nome a ser pesquisado: \n"
					+ "Digite Sair para abortar o programa.");
			pesquisa = sc.next().toUpperCase();
			comeco = 0;
			fim = vetConv.length - 1;
			acha = false;

			while ((comeco <= fim) && (acha == false)) {
				meio = ((comeco + fim) / 2);
				if (vetConv[0].toUpperCase().equalsIgnoreCase(pesquisa)) {
					acha = true;
					meio = 0;
					break;
				}
				if (vetConv[meio].toUpperCase().equalsIgnoreCase(pesquisa)) {
					acha = true;
					break;
				} else {
					if (vetConv[meio].toUpperCase().startsWith(pesquisa))
						fim = meio - 1;
					else
						comeco = meio + 1;
				}
			}

			if (acha) {
				System.out.println("O nome \"" + pesquisa
						+ "\" foi localizado na posição \'" + meio + "\'");
				break;
			} else {
				System.out.println("O nome \"" + pesquisa
						+ "\" não foi localizado.");
				break;
			}

		} while (true);
	}

	public Nodo<T> getHead() {
		return head;
	}

	public void removeFirst() {
		Nodo<T> nodo;
		if (head == null) {
			System.out.println("Lista vazia");
		}
		if (head != null) {
			nodo = head;
			head = head.getNext();
			nodo.setNext(null);

		}

	}

	public void print() {
		Nodo<?> nodo = head;
		do {
			if (nodo == null) {
				System.out.println("Lista Vazia");
			} else {

				System.out.println(nodo.getData());
				nodo = nodo.getNext();
			}
		} while (nodo != null);
	}

	public void insert(Nodo<T> novo) {
		novo.setNext(head);
		head = novo;

		if (tail == null)
			tail = head;
	}

	public void insert(Nodo<T> novo, Nodo<T> anterior) {
		if (anterior == tail) {
			tail.setNext((Nodo<T>) novo);
			tail = novo;
		} else {
			novo.setNext(anterior.getNext());
			anterior.setNext(novo);
		}
	}

	public void append(Nodo<T> novo) {
		tail.setNext(novo);
		tail = novo;
	}

}