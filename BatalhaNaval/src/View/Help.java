package View;

public class Help {
	
	public String imprimirComandos(){
		String s = "\n\n--> COMANDOS <--\n"
				   + "1 - ATIRAR \n"
				   + "9 - ABANDONAR JOGO";
		
		return s;
	}
	
	public String perguntarLinha(){
		String s = "\nDigite a linha:";
		
		return s;
	}
	
	public String perguntarColuna(){
		String s = "\nDigite a coluna:";
		
		return s;
	}

}
