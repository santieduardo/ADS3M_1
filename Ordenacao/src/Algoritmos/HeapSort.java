package Algoritmos;

import java.util.Scanner;

public class HeapSort {
	
	private int numTrocas = 0;
	private int numComparacoes = 0;
	private int vetInt[];
	private int tamanho;
	
	private Scanner entrada = new Scanner(System.in); 
	
	
	public void rodarHeapSort(){
		definirTamanhoArray();
		inserirDados();
		rodar();
		imprimir();
		System.out.print(imprimirInformacoes());
	}
	
	public int getTrocas(){
		return numTrocas;
	}
	
	public int getComparacoes(){
		return numComparacoes;
	}
	
	public int getTamanho(){
		return tamanho;
	}
	
	public String imprimirInformacoes(){
		return "Comparações: " + getComparacoes() +
				"\nTrocas: " + getTrocas();
	}
	
	private void definirTamanhoArray(){
		System.out.println("Defina a qtd de algarismos: ");
		tamanho = entrada.nextInt();
		vetInt = new int[tamanho];
	}
	

	private void heapSort(int vetInt[], int ind) {
		int i, o;
		int l, r, m, root, temp;

		root = (ind - 1) / 2;
		for (o = root; o >= 0; o--) {
			numComparacoes ++;
			
			for (i = root; i >= 0; i--) {
				numComparacoes ++;

				l = (2 * i) + 1;
				r = (2 * i) + 2;

				if ((l <= ind) && (r <= ind)) {
					if (vetInt[r] >= vetInt[l]) {
						m = r;
						numTrocas ++;
						
					} else {
						m = l;
						numTrocas ++;
						
					}
				} else {
					if (r > ind) {
						m = l;
						numTrocas ++;
						
					} else {
						m = r;
						numTrocas ++;
					}
				}

				if (vetInt[i] < vetInt[m]) {
					temp = vetInt[i];
					vetInt[i] = vetInt[m];
					vetInt[m] = temp;
					numTrocas ++;
					
				}
			}
		}

		temp = vetInt[0];
		vetInt[0] = vetInt[ind];
		vetInt[ind] = temp;
		return;

	}
	
	private void inserirDados(){
		for(int i = 0; i < getTamanho(); i++){
			System.out.println("Inserir valor: ");
			vetInt[i] = entrada.nextInt();
		}
	}
	
	private void rodar(){
		for(int i = vetInt.length; i > 1; i--){
			heapSort(vetInt, i - 1);
		}
	}
	
	private void imprimir() {
		for (int i = 0; i < vetInt.length; i++) {
			System.out.println(vetInt[i]);
		}
	}
	

}
