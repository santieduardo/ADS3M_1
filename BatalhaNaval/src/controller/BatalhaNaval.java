package controller;

import model.BatalhaNavalModel;
import model.Navio;

public class BatalhaNaval extends BatalhaNavalModel {

	private Navio batalhaNaval[][] = new Navio[10][10];
	private int pontuacao = 15;

	public void preencher() {
		for (int linha = 0; linha < 10; linha++) {
			for (int coluna = 0; coluna < 10; coluna++) {
				batalhaNaval[linha][coluna] = new Navio();
				batalhaNaval[linha][coluna].setVisual(".");
				if (linha % 2 == 0) {
					batalhaNaval[linha][coluna].setDado("navio");
				} else {
					batalhaNaval[linha][coluna].setDado("Agua");
				}
			}
		}
	}

	public void mostrar() {
		for (int linha = 0; linha < batalhaNaval.length; linha++) {
			for (int coluna = 0; coluna < batalhaNaval.length; coluna++) {
				System.out.print("\t" + batalhaNaval[linha][coluna].getVisual());
			}
			System.out.println("");
		}
	}

	public void corrigirColuna() {
		if (getColuna().equals("a")) {
			setColunaOK(0);
		}
		if (getColuna().equals("b")) {
			setColunaOK(1);
		}
		if (getColuna().equals("c")) {
			setColunaOK(2);
		}
		if (getColuna().equals("d")) {
			setColunaOK(3);
		}
		if (getColuna().equals("e")) {
			setColunaOK(4);
		}
		if (getColuna().equals("f")) {
			setColunaOK(5);
		}
		if (getColuna().equals("g")) {
			setColunaOK(6);
		}
		if (getColuna().equals("h")) {
			setColunaOK(7);
		}
		if (getColuna().equals("i")) {
			setColunaOK(8);
		}
		if (getColuna().equals("j")) {
			setColunaOK(9);
		}
	}

	public void atacar() {
		for (int linha = 0; linha < batalhaNaval.length; linha++) {
			for (int coluna = 0; coluna < batalhaNaval.length; coluna++) {
				corrigirColuna();

				if ((coluna == getColunaB()) & (linha == getLinha())) {
					if (batalhaNaval[linha][coluna].getDado() == "navio") {
						batalhaNaval[linha][coluna].setVisual("O");
						pontuacao = pontuacao + 3;						
					}
					else {
						batalhaNaval[linha][coluna].setVisual("-");
						if (pontuacao > 0) {
							pontuacao = pontuacao - 1;
						}
					}
				}
				if (pontuacao == 0) {
					System.err.println("Voce perdeu !");
					System.exit(0);
				}
			}
		}
	}

	public int mostrarPontos() {
		return this.pontuacao;
	}
}
