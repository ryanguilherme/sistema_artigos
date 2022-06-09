package projeto_final;

public class Main {
	public static void main(String[] args) {
		GerenciaArtigos gerencia = new GerenciaArtigosImplementacao();
		
		ArtigosUI artigosUIMemoria = new ArtigosUI(gerencia);
		
		artigosUIMemoria.run();
	}
}
