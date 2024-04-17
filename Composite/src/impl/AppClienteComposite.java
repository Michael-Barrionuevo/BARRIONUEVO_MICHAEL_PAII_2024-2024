package impl;

import abs.ProductoCompuesto;
import abs.ProductoPeso;
import abs.ProductoUnitario;

public class AppClienteComposite {
	
	public static void main (String [] args) {
		
		Pedido pedido = new Pedido ("Anita");
		
		ProductoPeso jamon = new ProductoPeso(1.7, 3.5, "Jamon", "Embutidos");
		ProductoPeso arroz = new ProductoPeso(4, 0.78, "Arroz", "Arroz");
		ProductoPeso queso = new ProductoPeso(6, 8.9, "Quezo Manchego", "Lacteos");
		ProductoPeso pollo = new ProductoPeso(7, 1.98, "Pollo", "Carnicos");
		ProductoUnitario cola = new ProductoUnitario(2, 1.8, "Cola", "Gaseosas");
		ProductoUnitario aceite = new ProductoUnitario(5, 5.6, "Aceite", "Aceites");
		ProductoUnitario caramelos = new ProductoUnitario(2, 1.6, "Caramelos de menta", "Dulces");
		
		ProductoCompuesto canasta = new ProductoCompuesto();
		canasta.addProducto(arroz);
		canasta.addProducto(aceite);
		canasta.addProducto(caramelos);
		
		
		pedido.addProducto(cola);
		pedido.addProducto(pollo);
		pedido.addProducto(jamon);
		pedido.addProducto(queso);
		pedido.addProducto(canasta);
		System.out.println(" El costo de su compra es : " + pedido.getImporteTotal());
	}

}
