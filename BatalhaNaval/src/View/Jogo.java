package View;

import java.util.Scanner;

import Controller.Controle;
import Model.Tabuleiro;

public class Jogo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Tabuleiro tab = new Tabuleiro();
		Controle ctrl = new Controle();
		Help help = new Help();
		
		do{
		System.out.println("----- BATALHA NAVAL -----");
		tab.gerarTabuleiro();
		
		System.out.println(help.imprimirComandos());
		int cmd = sc.nextInt();
		ctrl.converterCMD(cmd);
		
		} while(!ctrl.isGameOver());
		
		
		
		
		
	}

}
