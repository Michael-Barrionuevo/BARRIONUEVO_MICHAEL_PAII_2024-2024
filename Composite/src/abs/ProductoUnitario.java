package abs;

import inter.IPrecio;

public class ProductoUnitario implements IPrecio{

	private int cantidad;
	private double precio;
	private String nombre;
	private String categoria;
	
	public ProductoUnitario(int can,double pre,String nom, String cat) {
		this.cantidad = can;
		this.precio = pre;
		this.nombre = nom;
		this.categoria = cat;
		
	}
	@Override
	public double getImporteTotal() {
		
		return cantidad * precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
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
