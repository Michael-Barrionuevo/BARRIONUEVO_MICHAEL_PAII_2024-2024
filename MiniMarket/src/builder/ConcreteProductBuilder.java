package builder;

import model.Producto;

public class ConcreteProductBuilder implements ProductBuilder {

	private String nombre;
	private String descripcion;
	private double precio;
	private String categoria;

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public Producto build() {
		return new Producto(nombre, descripcion, precio, categoria);
	}
}



