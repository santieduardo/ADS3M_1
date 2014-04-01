package Controller;

public class Controle {
	
	private int pontos;
	
	public Controle(){
		this.pontos = 0;
	}
	
	public void converterCMD(int cmd){
		switch (cmd) {
		case 1:
			System.out.println("Opcao ATIRAR");
			//atirar();
			break;
		case 9:
			System.out.println("VOCE ABANDONOU O JOGO");
			System.exit(0);
			break;
		default:
			System.err.println("OPS !\nCOMANDO INVALIDO !!!");
			break;
		}
	}
	
	private void setPontos(int valor){
		pontos = pontos + valor;
	}
	
	public int getPontos(){
		return pontos;
	}
	
	public boolean isGameOver(){
		if(getPontos() == 0){
			return true;
		}
		return false;
	}

}
