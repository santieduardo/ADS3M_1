package View;

public class Help {
	
	/**
	 * 
	 * @return imprime para o jogador os comandos do jogo
	 */
	public String imprimirComandos(){
		String s = "\n\n--> COMANDOS <--\n"
				   + "1 - ATIRAR \n"
				   + "9 - ABANDONAR JOGO";		
		return s;
	}
	
	/**
	 * 
	 * @return pede para o jogador inserir a linha desejada para o tiro
	 */
	public String perguntarLinha(){
		String s = "Digite a linha:";		
		return s;
	}
	
	/**
	 * 
	 * @return pede para o jogador inserir a coluna desejada para o tiro
	 */
	public String perguntarColuna(){
		String s = "Digite a coluna:";		
		return s;
	}

}
