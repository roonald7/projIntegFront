package main.java.entity;

public class MedidorToJson {
	private String linha;
	
	private String modelo;
	
	private String categoria;

	public MedidorToJson(String linha, String modelo, String categoria) {
		this.linha = linha;
		this.modelo = modelo;
		this.categoria = categoria;
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
	
	
	
	
}
