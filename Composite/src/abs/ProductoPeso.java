package abs;

import inter.IPrecio;

public class ProductoPeso implements IPrecio{

	private double peso;
	private double precioPeso;
	private String nombre;
	private String categoria;
	
	public ProductoPeso(double peso, double pre,String nom,String cat) {
		this.peso = peso;
		this.precioPeso = pre;
		this.nombre = nom;
		this.categoria = cat;
		
	}
	@Override
	public double getImporteTotal() {
		
		return peso * precioPeso;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getPrecioPeso() {
		return precioPeso;
	}
	public void setPrecioPeso(double precioPeso) {
		this.precioPeso = precioPeso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	

}
