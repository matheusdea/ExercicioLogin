package database;

public class Perfume {

	private int id;
	private String nome;
	private String fabricante;
	private String preco;

	public Perfume() {
	}

	public Perfume(int id, String nome, String fabricante, String preco) {
		this.id = id;
		this.nome = nome;
		this.fabricante = fabricante;
		this.preco = preco;
	}
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getFabricante() {
		return fabricante;
	}
	public String getPreco() {
		return preco;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
 
}
