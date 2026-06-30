package games.model;

public class Jogo extends Produto {
	
	private String plataformas;
	private boolean multijogador;

	public Jogo(int id, String nome, int categoria, float preco, String plataformas, boolean multijogador) {
		super(id, nome, categoria, preco);
		this.plataformas = plataformas;
		this.multijogador = multijogador;
	}

	public String getPlataformas() {
		return plataformas;
	}

	public void setPlataformas(String plataformas) {
		this.plataformas = plataformas;
	}

	public boolean getMultijogador() {
		return multijogador;
	}

	public void setMultijogador(boolean multijogador) {
		this.multijogador = multijogador;
	}
	
	public void visualizar() {
		super.visualizar();
		System.out.printf("Plataformas disponíveis:  %s\n", this.plataformas);
		System.out.printf("O Jogo é multijogador? %s\n", this.multijogador ? "Sim" : "Não");
  }

}