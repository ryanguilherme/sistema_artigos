package projeto_final;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Artigo {
	private String nome;
	private String eventoDePublicacao;
	private String localDePublicacao;
	private String autor;
	private String dataDePublicacao;
	//public ArrayList<String> keys;
	
	public Artigo() {
		super();
		this.nome = "";
		this.eventoDePublicacao = "";
		this.localDePublicacao = "";
		this.autor = "";
		this.dataDePublicacao = "";
	}
	
	public Artigo(String nome, String eventoDePublicacao, String localDePublicacao, String autor, String dataDePublicacao) {
		super();
		this.nome = nome;
		this.eventoDePublicacao = eventoDePublicacao;
		this.localDePublicacao = localDePublicacao;
		this.autor = autor;
		this.dataDePublicacao = dataDePublicacao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEventoDePublicaco() {
		return eventoDePublicacao;
	}
	
	public void setEventoDePublicacao(String eventoDePublicacao) {
		this.eventoDePublicacao = eventoDePublicacao;
	}
	
	public String getLocalDePublicacao() {
		return localDePublicacao;
	}
	
	public void setLocalDePublicacao(String localDePublicacao) {
		this.localDePublicacao = localDePublicacao;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getDataDePublicacao() {
		return dataDePublicacao;
	}
	
	public void setDataDePublicacao(String dataDePublicacao) {
		this.dataDePublicacao = dataDePublicacao;
	}
	

	public void exibirDados() {
		String dados = "------------------------------------------------------------\nINFORMAÇÕES DO ARTIGO\n"
				+ "Artigo: " + this.nome + "\n"
				+ "Evento de publicação: " + this.eventoDePublicacao + "\n"
				+ "Local de Publicação: " + this.localDePublicacao + "\n"
				+ "Autor: " + this.autor + "\n"
				+ "Data de Publicação: " + this.dataDePublicacao + "\n"
				+ "------------------------------------------------------------\n";
		System.out.println(dados);
	}
	
	public static void main(String[] args) {
		Artigo a1 = new Artigo();
		a1.setAutor("Ryan");
		a1.setDataDePublicacao("08/02/2002");
		a1.setEventoDePublicacao("Teste Evento");
		a1.setLocalDePublicacao("Boa Viagem, Ceará, Brasil");
		a1.setNome("Bogan");
		a1.exibirDados();
		System.out.println("\n\n\ntestando map\n");
		Map<String, Artigo> listaArtigos = new HashMap<String, Artigo>();
		listaArtigos.put("evento", a1);
		listaArtigos.put("bveventos", a1);
		listaArtigos.get("evento").exibirDados();
		listaArtigos.get("bveventos").exibirDados();
		
		listaArtigos.put("teste", a1);
		
	}

}










