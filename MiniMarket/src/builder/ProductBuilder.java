package builder;

import model.Producto;

public interface ProductBuilder {
	
	void setNombre(String nombre);

	void setDescripcion(String descripcion);

	void setPrecio(double precio);

	void setCategoria(String categoria);

	Producto build();

}
