package ArvoreRedBlack;

import java.util.Scanner;

public class AppRedBlack {

	public static void main(String[] args) {
		ArvoreRedBlack<String> redBlack = new ArvoreRedBlack<>();
		Scanner entrada = new Scanner(System.in);
		
		String value;
		String cmd;
		do {
			System.out.println("\nOpcoes:\nInserir\nImprimir\nSair");
			cmd = entrada.next();
			
			switch (cmd) {
			case "Inserir":
				System.out.println("Digite um nome: \n");
				value = entrada.next();
				redBlack.inserir(value);
				break;
			case "Imprimir":
				redBlack.imprimirNodos();
				break;
			case "Sair":
				entrada.close();
				System.exit(0);
			}
		} while (true);
	}
}
