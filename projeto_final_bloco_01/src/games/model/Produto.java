package games.model;

public abstract class Produto {
	
	private int id;
	private String nome;
	private int categoria;
	private float preco;
	private String descricao;
	
	
	public Produto(int id, String nome, int categoria, float preco, String descricao) {
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
		this.descricao = descricao;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getCategoria() {
		return categoria;
	}


	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}


	public float getPreco() {
		return preco;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void visualizar() {
		
		String categoria = " ";
		
		switch(this.categoria) {
			case 1 -> categoria = "Ação";
			case 2 -> categoria = "RPG";
			case 3 -> categoria = "Terror";
			case 4 -> categoria = "Esporte";
			case 5 -> categoria = "Aventura";
			default -> categoria = "Inválido";
		}
		
		System.out.println("\n********************************************");
		System.out.println("              Dados do Produto              ");
		System.out.println("********************************************");
		System.out.println("ID: " + this.id);
	    System.out.println("Nome: " + this.nome);
	    System.out.println("Categoria: " + categoria);
	    System.out.println("Preço: " + this.preco);
	    System.out.println("Descrição: " + this.descricao);
	}
}

	
