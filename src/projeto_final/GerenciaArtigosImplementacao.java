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
	public Map<String, Artigo> getListaArtigos() {
		Map<String, Artigo> novaLista = new HashMap<String, Artigo>();
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

	@Override
	public boolean editarArtigo(String chave) {
		if (listaArtigos.get(chave).getNome() == null) {
			System.out.println("Não há nenhum artivo editável, tente criar um novo!");
			return false;
		}
//		System.out.print("Digite um novo nome para o artigo " + artigo.getNome() + ": ");
//		artigo.setNome(lerString(""));
//		System.out.print("Digite um novo autor: "); artigo.setAutor(lerString(""));
//		System.out.print("Digite um novo evento de publicação: "); artigo.setEventoDePublicacao(lerString(""));
//		System.out.print("Digite um novo local de publicação: "); artigo.setLocalDePublicacao(lerString(""));
//		System.out.print("Digite uma nova data de publicação no formado dd/mm/aaaa: "); artigo.setDataDePublicacao(lerString(""));
//		return true;
		Artigo a = new Artigo();
		System.out.print("Digite um novo nome para o artigo: ");
		a.setNome(lerString(""));
		System.out.print("Digite um novo autor: "); a.setAutor(lerString(""));
		System.out.print("Digite um novo evento de publicação: "); a.setEventoDePublicacao(lerString(""));
		System.out.print("Digite um novo local de publicação: "); a.setLocalDePublicacao(lerString(""));
		System.out.print("Digite uma nova data de publicação no formado dd/mm/aaaa: "); a.setDataDePublicacao(lerString(""));
		for (String x : listaArtigos.keySet()) {
			if (x != chave && listaArtigos.get(x).getNome() == listaArtigos.get(chave).getNome()) {
				listaArtigos.remove(x);
				listaArtigos.put(x, a);
				
			}
		}
		listaArtigos.remove(chave);
		listaArtigos.put(chave, a);
		return true;
		
	}


	
}
