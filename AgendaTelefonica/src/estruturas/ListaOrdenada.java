package estruturas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class ListaOrdenada<T extends Comparable<T>> extends ListaEncadeada<T> {

	/**
	 * 
	 * @param novo - insere um novo nodo
	 * @return - retorna o nodo anterior
	 */
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

	/**
	 * @param novo - insere um novo nodo na lista 
	 */
	@Override
	public void insert(Nodo<T> novo) {
		Nodo<T> anterior = findBefore(novo);
		if (anterior == null) {
			super.insert(novo);
		} else {
			super.insert(novo, anterior);
		}
	}

	/**
	 * 
	 * @param novo - insere nodo novo
	 * @param anterior - entrada do nodo anterior
	 */
	@Override
	public void insert(Nodo<T> novo, Nodo<T> anterior) {
		insert(novo);
	}

	@Override
	public void append(Nodo<T> novo) {
		insert(novo);
	}
	
	/**
	 * 
	 * @return imprime o menu para a interacao com o usuario
	 */
	public static String imprimirMenu(){
		return "\n----- Agenda Telefonica -----" +
				"\n1 - Cadastrar contato"+
				"\n2 - Ver Agenda" + 
				"\n3 - Atualizar" +
				"\n4 - Exibir Agenda em Ordem Alfabetica" +
				"\n5 - Buscar Contato" +
				"\n0 - Sair";
	}

	/**
	 * 
	 * interacao com o usuario
	 */
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
				int opc = 0;
				System.out.println(imprimirMenu());
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
					//TODO implementar
					ListaOrdenada<?> list = new ListaOrdenada<>();
					list.print();
					break;
				case 5:
					System.out.println("Digite o nome do contato:");
					//TODO implementar
					break;
				case 0:
					System.out.println("----- FIM DO PROGRAMA -----");
					System.exit(0);
					break;

				default:
					System.out.println("----- OPCAO INEXISTENTE -----");
					break;
				}

			} while (true);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
