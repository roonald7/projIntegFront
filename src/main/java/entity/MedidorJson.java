package main.java.entity;

public class MedidorJson {
		
	private long id;
	
	private String linha;
	
	private String modelo;
	
	private String categoria;

	public MedidorJson(String linha, String modelo, String categoria) {
		this.linha = linha;
		this.modelo = modelo;
		this.categoria = categoria;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLinha() {
		return linha;
	}

	public void setLinha(String linha) {
		this.linha = linha;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Medidor [id=" + id + ", linha=" + linha + ", modelo=" + modelo + ", categoria=" + categoria + "]";
	}
	
}

