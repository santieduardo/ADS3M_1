package view;

import java.util.Scanner;
import controller.BatalhaNaval;

public class Menu {

	public void menu() {

		Scanner entradaTeclado = new Scanner(System.in);
		BatalhaNaval batalha = new BatalhaNaval();
		int lin;
		String col;
		batalha.preencher();
		
		try {
			
			do {
				System.out.println("\nComandos: \natacar \nsair");
				
				String comando = entradaTeclado.nextLine();
				
				switch (comando.toLowerCase()) {
				case "atacar":
					System.out.println("Insira a linha entre 0 a 9:");
					lin = entradaTeclado.nextInt();
					
					System.out.println("Insira a coluna entre 'A' a 'J':");
					col = entradaTeclado.next();
					
					batalha.setColuna(col);
					batalha.setLinha(lin);
					batalha.atacar();
					batalha.mostrar();
					System.out.println("PONTUACAO: " + batalha.mostrarPontos());					
					break;
					
				case "sair":
					System.err.println("VOCE ENCERROU O GAME!");
					System.exit(0);
					break;
				}
				
			} while (true);
			
		} catch (Exception e) {
			System.err.println("Fail!");
			menu();
		}
	}
}