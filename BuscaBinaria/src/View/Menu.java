package View;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

import Controller.ListaOrdenada;
import Model.Nodo;

import static java.lang.System.*;

public class Menu {

	public void menu() {
		ListaOrdenada<String> list = new ListaOrdenada<String>();
		String infPessoa = "";

		try {

			do {
				Scanner entradaTeclado = new Scanner(System.in);

				Reader fileReader = new FileReader("registros.txt");
				BufferedReader br = new BufferedReader(fileReader);

				Writer fileWriter = new FileWriter("registros.txt", true);

				String cmd = "";
				System.out.println("\nEscolha entre: \ninserir \nver  \nremover \npesquisar \nsair");
				
				cmd = entradaTeclado.nextLine();
				
				switch (cmd) {
				case "inserir":
					System.out.println("Digite um nome: ");
					infPessoa = entradaTeclado.next();

					list.insert(new Nodo<String>(infPessoa));

					fileWriter.write(infPessoa);
					fileWriter.append(System.getProperty("line.separator"));
					fileWriter.close();
					break;

				case "ver":
					list.print();
					break;

				case "remover":
					list.removeFirst();
					break;

				case "pesquisar":
					int size;
					System.out.println("Digite o tamanho do array: \n"
									+ "Devem existir todos os elementados da quantidade"
									+ "que voce deseja na lista para poderem ser inseridos no vetor");
					
					size = entradaTeclado.nextInt();
					
					Nodo<String> nodo = list.getHead();
					
					list.converter(nodo,size);
					list.ordenar();
					list.pesquisarFormaBinaria();
					break;

				case "sair":
					System.exit(0);
					break;

				default:
					System.err.println("OPS ! Opcao invalida.");
					break;
				}

			} while (true);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}