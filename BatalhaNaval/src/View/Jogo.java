package View;

import java.util.Scanner;

import Controller.Controle;
import Model.Tabuleiro;

public class Jogo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Tabuleiro tabuleiro = new Tabuleiro();
		Controle controle = new Controle();
		Help help = new Help();
		
		do{
		System.out.println("----- BATALHA NAVAL -----");
		System.out.print("        A       B       C       D       E       F       G       H       I       J");
		tabuleiro.gerarTabuleiro();
		
		System.out.println(help.imprimirComandos());
		int cmd = sc.nextInt();
		controle.converterCMD(cmd);
		
		} while(!controle.isGameOver());
		
		
		
		
		
	}

}
