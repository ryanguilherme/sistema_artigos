package projeto_final;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GerenciaArtigosImplementacao implements GerenciaArtigos {

	private Map<String, Artigo> listaArtigos = new HashMap<String, Artigo>();
	
	private String lerString( String mensagem ) {
			
			System.out.println( mensagem );
			
			String msg;
			Scanner scanner = new Scanner( System.in );
			msg = scanner.nextLine();
			
			return msg;
		}

	@Override
	public boolean adicionarArtigo(Artigo artigo) {
		for (int i=1; i<=3; i++) {
			String pchave = lerString("Digite a palavra chave " + i + "para o artigo " + artigo.getNome());
			if (listaArtigos.get(pchave) != null) {
				System.out.println("Essa palavra-chave já está sendo usada, tente outra!");
				i--;
			}else {
				listaArtigos.put(pchave, artigo);
			}
		}
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
		listaArtigos.remove(chave);
		return true;
		
	}

	@Override
	public boolean editarArtigo(Artigo artigo) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
