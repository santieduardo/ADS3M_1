package ArvoreAVL;

import java.util.Scanner;

public class AppAVL {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		ArvoreAVL arvore = new ArvoreAVL();
		
		NodoAVL novoNodo = null;
		String cmd;
		
		do {

			System.out.println("\nOpcoes: \nInserir\nImprimir ordenada\nImprimir pre-ordem\nImprimir pos-ordem\nSair");
			
			cmd = entrada.nextLine();
			
			switch (cmd) {
			case "Inserir":
				System.out.println("Insira um numero na arvore: \n");
				int numedo = entrada.nextInt();
				novoNodo = arvore.inserir(novoNodo, numedo);
				break;
				
			case "Imprimir ordenada":
				novoNodo.ordenado(novoNodo);
				break;
				
			case "Imprimir pre-ordem":
				novoNodo.preOrdenado(novoNodo);
				break;
			case "Imprimir pos-ordem":
				novoNodo.posOrdenado(novoNodo);
				break;
			case "Sair":
				entrada.close();
				System.exit(0);
			}
		} while (true);

	}
}
