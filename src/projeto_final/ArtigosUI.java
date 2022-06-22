package projeto_final;

import java.util.ArrayList;
import java.util.Scanner;

public class ArtigosUI {
	private boolean running;
	private GerenciaArtigos gerencia;
	
	private void printMenu() {
		System.out.println("Gerencia coleção de Artigos\n"
					+ "1 - Listar artigos da coleção\n"
					+ "2 - Adicionar artigo à coleção\n"
					+ "3 - Editar um artigo\n"
					+ "4 - Remover um artigo\n"
					+ "5 - Buscar artigos");
	}
	
	public ArtigosUI(GerenciaArtigos gerenciadorArtigos) {
		this.gerencia = gerenciadorArtigos;
	}
	
	private void imprimirListaArtigos() {
		gerencia.listarArtigos();
	}
	
	private int lerInteiro( String mensagem ) {
		
		int numeroLido = 0;
		
		System.out.println( mensagem );
		//Lendo inteiros do teclado. Vamos utilizar para ler a opcao
		Scanner scanner = new Scanner( System.in );
		numeroLido = scanner.nextInt();
		
		return numeroLido;
		
	}
	
	private String lerString( String mensagem ) {
		
		System.out.println( mensagem );
		
		String msg;
		Scanner scanner = new Scanner( System.in );
		msg = scanner.nextLine();
		
		return msg;
	}
	
	private void lerArtigo() {
		System.out.println("Adicionando um artigo");
		String nome = lerString("Digite o nome do artigo: ");
		String evento = lerString("Digite o evento de publicação: ");
		String local = lerString("Digite o local de publicação (país): ");
		String autor = lerString("Digite o autor do artigo: ");
		String data = lerString("Digite a data de publicação no formato dd/mm/aaaa: ");
		Artigo a = new Artigo(nome, evento, local, autor, data);
		gerencia.adicionarArtigo(a);	
	}
	
	private void modificarArtigo() {
		String nomeArtigo = lerString("Digite o nome do artigo que deseja editar, ou uma de suas palavras-chave: ");
		gerencia.editarArtigo(nomeArtigo);
	}
	
	private void excluirArtigo() {
		String nomeArtigo = lerString("Digite o nome do artigo que deseja excluir, ou uma de suas palavras-chave: ");
		gerencia.apagarArtigo(nomeArtigo);
	}

	private void buscarArtigo() {
		int opp = lerInteiro("Deseja buscar por palavras (1) ou por local (2): ");
		if (opp == 1) {
			String nomeArtigo = lerString("Digite o que procura: ");
			String[] chaves = nomeArtigo.split(" ");
			int flag = 0;
			for (String x : chaves) {
				if (gerencia.getArtigo(x) != null) {
					gerencia.getArtigo(x).exibirDados();
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				System.out.println("Nenhum artigo encontrado!");
			}}
		else if (opp == 2) {
			String local = lerString("Digite o local que deseja buscar (país): ");
			gerencia.buscarLocal(local);
		}
	}

	private void avaliarOpcao(int opcao) {
		switch (opcao) {
			case 1: 
				imprimirListaArtigos();
				break;	
			case 2: 
				lerArtigo();
				break;	
			case 3: 
				modificarArtigo();
				break;
			case 4: 
				excluirArtigo();
				break;		
			case 5: 
				buscarArtigo();
				break;	
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcao);}
	}
	
	public void run(){
		
		this.running = true;
		
		while(running) {
			printMenu();
			String msg = "Digite a opcao desejada: ";
			int opcao = lerInteiro(msg);
			avaliarOpcao(opcao);
			
		}
		
	}

}
