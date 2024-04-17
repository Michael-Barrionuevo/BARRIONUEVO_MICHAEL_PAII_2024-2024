package abs;

import java.util.ArrayList;

import inter.IPrecio;

public class ProductoCompuesto implements IPrecio {

	private ArrayList<IPrecio> productos;
	
	public ProductoCompuesto() {
		productos = new ArrayList<IPrecio>();
		
	
	}
	
	public void addProducto(IPrecio pro) {
		productos.add(pro);
	}
	
	public void removeProducto(IPrecio pro) {
		productos.remove(pro);
	}
	@Override
	public double getImporteTotal() {
		double importeTotal =0;
		
		for(var it: productos) {
			importeTotal += it.getImporteTotal();
		}
		return importeTotal;
	}

	public ArrayList<IPrecio> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<IPrecio> productos) {
		this.productos = productos;
	}
	

}
