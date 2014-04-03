package Controller;

public class Controle {

	private int pontos;

	/**
	 * constroi o jogo e ja inicia os pontos para o jogador
	 */
	public Controle() {
		this.pontos = 15;
	}

	/**
	 * 
	 * @param cmd - colina inserida
	 * @return retorna a coordenada inserida pelo usuario convertida para ser inserida na matriz
	 */
	public int escolherColuna(String cmd) {
		int coluna = 0;

		switch (cmd.toUpperCase()) {
		case "A":
			return coluna = 0;
			
		case "B":
			return coluna = 1;
			
		case "C":
			return coluna = 2;
			
		case "D":
			return coluna = 3;

		case "E":
			return coluna = 4;

		case "F":
			return coluna = 5;

		case "G":
			return coluna = 6;

		case "H":
			return coluna = 7;

		case "I":
			return coluna = 8;

		case "J":
			return coluna = 9;

		default:
			System.err.println("COLUNA INCORRETA !");
			break;
		}
		return coluna;
	}

	
	public void atirar(int linha, int coluna) {
		System.out.println("Linha:" + linha);
		System.out.println("Coluna:" + coluna);
	}

	/**
	 * define os pontos para o jogador
	 * @param valor - novo valor para o jogo
	 */
	private void setPontos(int valor) {
		this.pontos = valor;
	}

	/**
	 * 
	 * @return retorna os pontos atuais para o jogador
	 */
	public int getPontos() {
		return pontos;
	}

	/**
	 * 
	 * @return retorna se o usuario perdeu o jogo ou nao
	 */
	public boolean isGameOver() {
		if (getPontos() == 0) {
			return true;
		}
		return false;
	}

}
