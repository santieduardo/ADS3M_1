package Controller;

public class Controle {

	private int pontos;

	public Controle() {
		this.pontos = 0;
	}

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

	private void setPontos(int valor) {
		pontos = pontos + valor;
	}

	public int getPontos() {
		return pontos;
	}

	public boolean isGameOver() {
		if (getPontos() == 0) {
			return true;
		}
		return false;
	}

}
