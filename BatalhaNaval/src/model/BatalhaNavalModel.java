package model;


public class BatalhaNavalModel {
	private int linha;
	private String coluna;
	private int colunaOK;

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public void setColuna(String coluna) {
		this.coluna = coluna;
	}

	protected void setColunaOK(int colunaOK) {
		this.colunaOK = colunaOK;
	}

	protected int getColunaB() {
		return this.colunaOK;
	}

	public int getLinha() {
		return this.linha;
	}

	public String getColuna() {
		return this.coluna;
	}
}
