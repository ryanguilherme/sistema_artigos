package projeto_final;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GerenciaArtigosImplementacao implements GerenciaArtigos {

	private Map<String, Artigo> listaArtigos = new HashMap<String, Artigo>();
	private ArrayList<String> keyIndividual = new ArrayList<String>();
	
	private String lerString( String mensagem ) {
			
			System.out.println( mensagem );
			
			String msg;
			Scanner scanner = new Scanner( System.in );
			msg = scanner.nextLine();
			
			return msg;
	}
	
	public void listarArtigos() {
		int flag = 0;
		for (String x : keyIndividual) {
			//listaArtigos.get(x).exibirDados();
			if (listaArtigos.get(x) != null) {
				listaArtigos.get(x).exibirDados();
				flag = 1;
			}
		}
		if (flag == 0) {
			System.out.println("Não há nenhum artigo cadastrado para exibir!");
		}
	}

	@Override
	public boolean adicionarArtigo(Artigo artigo) {
		String keyUnica = "";
		for (int i=1; i<=3; i++) {
			String pchave = lerString("Digite a palavra chave " + i + "para o artigo " + artigo.getNome());
			if (listaArtigos.get(artigo.getNome()) != null) {
				System.out.println("Já existe um artigo com esse nome!");
				return false;
			}
			if (listaArtigos.get(pchave) != null) {
				System.out.println("Essa palavra-chave já está sendo usada, tente outra!");
				i--;
			}else {
				listaArtigos.put(pchave, artigo);
				keyUnica = pchave;
			}
			
		}
		keyIndividual.add(keyUnica);
		listaArtigos.put(artigo.getNome(), artigo);
		return true;
	}
	

	@Override
	public HashMap<String, Artigo> getListaArtigos() {
		HashMap<String, Artigo> novaLista = new HashMap<String, Artigo>();
		novaLista.putAll(listaArtigos);
		return novaLista;
	}

	@Override
	public Artigo getArtigo(String chave) {
		if (listaArtigos.get(chave) == null) {
			System.out.println("Não há nenhum artigo cadastrado com essa chave!");
			return null;
		}
		return listaArtigos.get(chave);
	}

	@Override
	public boolean apagarArtigo(String chave) {
		if (listaArtigos.get(chave) == null) {
			System.out.println("Não há nenhum artigo com essa palavra-chave!");
			return false;
		}
		String nomeArtigo = listaArtigos.get(chave).getNome();
		ArrayList<String> chaves = new ArrayList<String>();
		for (String x : listaArtigos.keySet()) {
			if (listaArtigos.get(x).getNome() == nomeArtigo) {
				chaves.add(x);
			}
		}
		for (String x : chaves) {
			listaArtigos.remove(x);
		}
		//listaArtigos.remove(nomeArtigo);
		return true;
		
	}
	
	public void buscarLocal(String local) {
		for (String x : listaArtigos.keySet()) {
			if (listaArtigos.get(x).getLocalDePublicacao() == local) {
				listaArtigos.get(x).exibirDados();
			}
		}
	}

	@Override
	public boolean editarArtigo(String chave) {
		if (listaArtigos.get(chave) == null) {
			System.out.println("Não há nenhum artivo editável, tente criar um novo!");
			return false;
		}
		System.out.println("O que deseja editar no artigo" + listaArtigos.get(chave).getNome() + "?\n"
						 + "1 - Nome\n"
						 + "2 - Autor\n"
						 + "3 - Evento de publicação\n"
						 + "4 - Local de Publicação\n"
						 + "5 - Data de publicação\n");
		int opcao = lerInteiro("Digite a opção desejada: ");
		
		switch(opcao) {
		case 1:
			String oldName = listaArtigos.get(chave).getNome();
			listaArtigos.get(chave).setNome(lerString("Digite o novo nome: "));
			listaArtigos.put(listaArtigos.get(chave).getNome(), listaArtigos.get(chave));
			listaArtigos.remove(oldName);
			break;
		case 2:
			listaArtigos.get(chave).setAutor(lerString("Digite o novo autor: "));
			break;
		case 3:
			listaArtigos.get(chave).setEventoDePublicacao(lerString("Digite o novo evento: "));
			break;
		case 4:
			listaArtigos.get(chave).setLocalDePublicacao(lerString("Digite o novo local: "));
			break;
		case 5:
			listaArtigos.get(chave).setDataDePublicacao(lerString("Digite a nova data no formato dd/mm/aaaa: "));
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " +  opcao );
		}
		return true;

	}
	
	private int lerInteiro( String mensagem ) {
		
		int numeroLido = 0;
		
		System.out.println( mensagem );
		//Lendo inteiros do teclado. Vamos utilizar para ler a opcao;
		Scanner scanner = new Scanner( System.in );
		numeroLido = scanner.nextInt();
		
		return numeroLido;
		
	}


	
}
