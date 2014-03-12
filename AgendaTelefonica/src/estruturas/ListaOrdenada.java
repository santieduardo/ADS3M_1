package estruturas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class ListaOrdenada<T extends Comparable<T>> extends ListaEncadeada<T> {

	private Nodo<T> findBefore(Nodo<T> novo) {
		Nodo<T> atual = getHead();
		Nodo<T> anterior = null;

		while (atual != null) {
			int comp = atual.compareTo(novo);
			if (comp < 0) {
				anterior = atual;
				atual = atual.getNext();
			}
			if (comp == 0)
				return atual;
			if (comp > 0)
				return anterior;
		}

		return anterior;
	}

	@Override
	public void insert(Nodo<T> novo) {
		Nodo<T> anterior = findBefore(novo);
		if (anterior == null) {
			super.insert(novo);
		} else {
			super.insert(novo, anterior);
		}
	}

	@Override
	public void insert(Nodo<T> novo, Nodo<T> anterior) {
		insert(novo);
	}

	@Override
	public void append(Nodo<T> novo) {
		insert(novo);
	}

	public static void main(String[] args) {
		ListaOrdenada<String> lista = new ListaOrdenada<String>();

		try {

			do {
				Reader fileReader = new FileReader("registros.txt");
				BufferedReader br = new BufferedReader(fileReader);
				String nome;
				String telefone;
				Scanner sc = new Scanner(System.in);
				Writer fileWriter = new FileWriter("registros.txt", true);
				int opc = -1;
				System.out.println("\n----- Agenda Telefonica -----");
				System.out.println("1 - Cadastrar contato");
				System.out.println("2 - Ver Agenda");
				System.out.println("3 - Atualizar");
				System.out.println("4 - Exibir Agenda em Ordem Alfabetica");
				System.out.println("\nDigite a opçao desejada:");

				opc = sc.nextInt();
				switch (opc) {

				case 1:

					System.out.println("Digite o nome: ");
					nome = sc.next();
					lista.insert(new Nodo<String>(nome));
					fileWriter.write(nome);
					fileWriter.append(System.getProperty("line.separator"));

					System.out.println("Digite o telefone: ");
					telefone = sc.next();
					// lista.insert(new Nodo<String>(telefone));
					lista.insert(new Nodo<String>(telefone));
					fileWriter.write(telefone);
					fileWriter.append(System.getProperty("line.separator"));

					lista.print();
					fileWriter.close();

					String registro = br.readLine();
					String campos[] = registro.split(";");

					break;
				case 2:
					String line = null;
					while ((line = br.readLine()) != null) {
						System.out.println(line);
					}
					break;
				case 3:
					String lines = null;
					while ((lines = br.readLine()) != null) {
						lista.insert(new Nodo<String>(lines));
					}

					lista.print();
					break;
				case 4:
					ListaOrdenada<?> list = new ListaOrdenada<>();
					list.print();
					break;
				case 0:
					System.exit(0);
					break;

				default:
					System.out.println("Opcao nao existe");
					break;
				}

			} while (true);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
