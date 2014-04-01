package Model;

public class Tabuleiro {
	
	public static final int LINHAS = 9;
	public static final int COLUNAS = 9;
	private String matriz[][];
	
	public Tabuleiro(){
		matriz = new String[LINHAS][COLUNAS];
	}

	public void gerarTabuleiro() {
		for (int x = 0; x < matriz.length; x++){
			System.out.println();
			
			for(int y = 0; y < matriz.length; y++){
				System.out.print("\t" + matriz[x][y]);
			}
		}
		
	}
	
	

}
