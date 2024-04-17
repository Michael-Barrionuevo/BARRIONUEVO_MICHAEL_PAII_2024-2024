package model;

public class Producto {
	
	private String nombre;
	private String descripcion;
	private double precio;
	private String categoria;

	public Producto(String nombre, String descripcion, double precio, String categoria) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
	}

	public String getName() {
		return nombre;
	}

	public void setName(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescription(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrice(double precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategory(String categoria) {
		this.categoria = categoria;
	}
	
	public boolean equals(Producto otherProduct) {
        return this.nombre.equals(otherProduct.getName()) &&
               this.descripcion.equals(otherProduct.getDescripcion()) &&
               this.precio == otherProduct.getPrecio() &&
               this.categoria.equals(otherProduct.getCategoria());
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + nombre + '\'' +
                ", description='" + descripcion + '\'' +
                ", price=" + precio +
                ", category='" + categoria + '\'' +
                '}';
    }

}
