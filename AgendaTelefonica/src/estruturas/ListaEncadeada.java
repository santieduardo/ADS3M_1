package estruturas;

import static java.lang.System.out;

import java.io.*;
import java.util.Scanner;

public class ListaEncadeada<T extends Comparable<T>> {

	private Nodo<T> head;
	private Nodo<T> tail;

	/**
	 * 
	 * @return o nodo 'cabeca' da lista
	 */
	public Nodo<T> getHead() {
		return head;
	}

	/**
	 * Exibe os nodos validos
	 */
	public void print() {
		Nodo<?> nodo = head;
		do {
			out.println(nodo.getData());
			nodo = nodo.getNext();
		} while (nodo != null);
	}

	/**
	 * 
	 * @param novo - insere nodo novo 
	 */
	public void insert(Nodo<T> novo) {
		novo.setNext(head);
		head = novo;

		if (tail == null)
			tail = head;
	}

	/**
	 * 
	 * @param novo - insere nodo novo
	 * @param anterior - entrada do nodo anterior
	 */
	public void insert(Nodo<T> novo, Nodo<T> anterior) {
		if (anterior == tail) {
			tail.setNext((Nodo<T>) novo);
			tail = novo;
		} else {
			novo.setNext(anterior.getNext());
			anterior.setNext(novo);
		}
	}

	/**
	 * 
	 * @param novo - insere o nodo no final da lista
	 */
	public void append(Nodo<T> novo) {
		tail.setNext(novo);
		tail = novo;
	}

	/**
	 * realiza leituras do teclado, grava e le os contatos do arquivo 'registros.txt'
	 */
	public void lista() {
		ListaEncadeada<String> lista = new ListaEncadeada<String>();

		try {
			String nome, telefone;
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite o nome: ");
			nome = sc.next();
			System.out.println("Digite o telefone: ");
			telefone = sc.next();

			Writer fileWriter = new FileWriter("registros.txt", true);
			fileWriter.write("\n" + nome + "\n" + telefone);
			fileWriter.close();

			Reader fileReader = new FileReader("registros.txt");
			BufferedReader br = new BufferedReader(fileReader);

			String registro = br.readLine();
			String campos[] = registro.split(";");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}