package View;

import java.util.Scanner;

import Controller.Controle;
import Model.Tabuleiro;

public class Jogo {

	/**
	 * Roda o jogo 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Tabuleiro tabuleiro = new Tabuleiro();
		Controle controle = new Controle();
		Help help = new Help();

		do {
			System.out.println("----- BATALHA NAVAL -----");
			System.out.print("        A       B       C       D       " +
							 "E       F       G       H       I       J");
			tabuleiro.gerarTabuleiro();

			System.out.println(help.imprimirComandos());
			int cmd = sc.nextInt();
			escolherCMD(cmd);

		} while (!controle.isGameOver());

	}

	/**
	 * executa a opcao inserida pelo jogador
	 * @param cmd - comando escolhido
	 */
	private static void escolherCMD(int cmd) {
		Scanner sc = new Scanner(System.in);
		Controle ctrl = new Controle();
		Help help = new Help();

		switch (cmd) {
		case 1:
			System.out.println("Opcao ATIRAR");
			System.out.println(help.perguntarLinha());
			int linha = sc.nextInt();
			System.out.println(help.perguntarColuna());
			String conl = sc.next();
			int coluna = ctrl.escolherColuna(conl);

			ctrl.atirar(linha, coluna);

		case 9:
			System.out.println("VOCE ABANDONOU O JOGO");
			System.exit(0);

		default:
			System.err.println("OPS !\nCOMANDO INVALIDO !!!");
			break;
		}
	}

}
