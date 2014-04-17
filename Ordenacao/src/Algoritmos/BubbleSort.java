package Algoritmos;

import java.util.Scanner;

public class BubbleSort {
	
	public void rodarBubble(){
		BubbleSort();
	}

	private void BubbleSort() {

		int n, c, d, swap;

		Scanner sc = new Scanner(System.in);
		System.out.println("Tamanho do vetor");
		n = sc.nextInt();
		int array[] = new int[n];

		System.out.println("Digite " + n + " numeros");

		for (c = 0; c < n; c++) {
			System.out.println("Restam " + (n-c) + " valores para serem inseridos: ");
			array[c] = sc.nextInt();
		}

		for (c = 0; c < (n - 1); c++) {
			for (d = 0; d < n - c - 1; d++) {
				if (array[d] > array[d + 1]) {
					swap = array[d];
					array[d] = array[d + 1];
					array[d + 1] = swap;
				}
			}
		}

		System.out.println("Bubble Sort!");

		for (c = 0; c < n; c++) {
			System.out.print(array[c] + ",");
		}
	}

}
