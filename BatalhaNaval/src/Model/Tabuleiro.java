package Model;

public class Tabuleiro {
	
	public static final int LINHAS = 10;
	public static final int COLUNAS = 10;
	private String matriz[][];
	
	public Tabuleiro(){
		matriz = new String[LINHAS][COLUNAS];
	}

	public void gerarTabuleiro() {
		for (int x = 0; x < matriz.length; x++){
			System.out.println();
			
			for(int y = 0; y < matriz.length; y++){
				//System.out.print(x);
				System.out.print(x + "\t" + matriz[x][y]);
				//imprimirColunas();
			}
		}
	}
	
	/*private void imprimirColunas(int valor){
		switch (valor) {
		case 0:
			System.out.print("A");
			break;
		case 1:
			System.out.print("B");
			break;
		case 2:
			System.out.print("C");
			break;
		case 3:
			System.out.print("D");
			break;
		case 4:
			System.out.print("E");
			break;
		case 5:
			System.out.print("F");
			break;
		case 6:
			System.out.print("G");
			break;
		case 7:
			System.out.print("H");
			break;
		case 8:
			System.out.print("I");
			break;
		case 9:
			System.out.print("J");
			break;
		default:
			break;
		}
	} */
	
	

}
