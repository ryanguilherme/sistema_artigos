package projeto_final;

import java.util.Scanner;

public class ArtigosUI {
	private boolean running;
	private GerenciaArtigos gerencia;
	
	private void printMenu() {
		String menu = "Gerencia coleção de Artigos\n"
					+ "1 - Listar artigos da coleção\n"
					+ "2 - Adicionar artigo à coleção\n"
					+ "3 - Editar um artigo\n"
					+ "4 - Remover um artigo\n"
					+ "5 - Buscar artigos";
	}
	
	private void imprimirListaArtigos() {
		gerencia.listarArtigos();
	}
	
	private int lerInteiro( String mensagem ) {
		
		int numeroLido = 0;
		
		System.out.println( mensagem );
		//Lendo inteiros do teclado. Vamos utilizar para ler a opcao, ler a placa e o valor do veiculo;
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
		
	}





















}
