package App;

import java.util.Scanner;

import Algoritmos.BubbleSort;
import Algoritmos.HeapSort;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HeapSort heap = new HeapSort();
		BubbleSort bubble = new BubbleSort();
		int cmd;
		
		System.out.println("----- Algorítmos de Ordenação -----");
		System.out.println("\nDigite a opção desejada: ");
		System.out.println(imprimirMenu());
		
		cmd = sc.nextInt();
		
		switch (cmd) {
		case 1:
			heap.rodarHeapSort();
			break;
			
		case 2:
			bubble.rodarBubble();
			break;
			
		case 3:
			System.err.println("Você saiu da aplicação !");
			System.exit(0);

		default:
			System.err.println("**** Valor invalido ****");
			break;
		}
		

	}
	
	public static String imprimirMenu(){
		return "1 - HeapSort\n" +
				"2 - BubbleSort\n" + 
				"3 - Sair da aplicação";
	}

}
