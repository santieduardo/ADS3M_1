package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

import model.Pessoa;

import estruturas.Tree;
import estruturas.Nodo;

public class Main {

	private Scanner entrada;
	private BufferedReader BR;
	private Reader FR;
	private Writer FW;
	private Pessoa pessoa;

	public void menu() {
		Tree tree = new Tree(null);
		String nome;
		int telefone;
		int cmd = -1;
		
		try {
			do {
				FR = new FileReader("reg.txt");
				BR = new BufferedReader(FR);
				FW = new FileWriter("reg.txt", true);
				entrada = new Scanner(System.in);
				pessoa = new Pessoa();
				
				System.out.println("\nEntre com a opcao: \n"
								+ "1 - Inserir  \n2 - Altura  \n3 - Ordenar Pré\n"
								+ "4 - Ordenar Pós  \n5 - Ordenar In  \n6 - Inserir a partir do arquivo\n"
								+ "7 - Sair");
				
				
				cmd = entrada.nextInt();
				
				switch (cmd) {
				case 1:
					System.out.println("Insira o nome: ");
					nome = entrada.next();
					
					if (tree.getRaiz() == null) {
						Nodo r = new Nodo(nome);
						tree.setRaiz(r);
					} else {
						tree.inserir(nome);
					}
					
					FW.write(nome);
					FW.append(System.getProperty("line.separator"));
					
					System.out.println("Insira o telefone: ");
					telefone = entrada.nextInt();
					
					pessoa.setNome(nome);
					pessoa.setTelefone(telefone);
					
					FW.write(telefone);
					FW.append(System.getProperty("line.separator"));
					FW.close();
					break;

				case 2:
					System.out.printf("Height Tree : %d\n", tree.heightTree());
					break;
					
				case 3:
					System.out.printf("Ordernar Pré: \n");
					tree.ordenarPre(tree.getRaiz());
					break;
					
				case 4:
					System.out.printf("Ordernar Pós: \n");
					tree.ordenarPos(tree.getRaiz());
					break;
					
				case 5:
					System.out.printf("Ordernar In: \n");
					tree.ordenarIn(tree.getRaiz());
					break;
					
				case 6:
					String captureReg = null;
					while ((captureReg = BR.readLine()) != null) {
						if (captureReg instanceof String) {
							tree.inserir(captureReg);
						}
					}
					
					break;
					
				case 7:
					BR.close();
					entrada.close();
					System.exit(0);
					
				default:
					System.out.println("Opcao invalida.");
					break;
				}

			} while (true);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Main run = new Main();
		run.menu();
	}

}
