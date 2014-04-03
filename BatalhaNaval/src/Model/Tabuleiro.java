package Model;

public class Tabuleiro {
	
	public static final int LINHAS = 10;
	public static final int COLUNAS = 10;
	private String matriz[][];
	
	/**
	 * controi o tabuleiro do tamanho correto
	 */
	public Tabuleiro(){
		matriz = new String[LINHAS][COLUNAS];
	}

	/**
	 * gera o tabuleiro formatado corretamente
	 */
	public void gerarTabuleiro() {
		for (int x = 0; x < matriz.length; x++){
			System.out.println();
			
			for(int y = 0; y < matriz.length; y++){	
				System.out.print(x + "\t" + matriz[x][y]);
				
			}
		}
	}
}
