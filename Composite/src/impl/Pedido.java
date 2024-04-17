package impl;

import abs.ProductoCompuesto;
import abs.ProductoUnitario;
import inter.IPrecio;
import abs.ProductoPeso;

public class Pedido extends ProductoCompuesto{
	
	private String cliente;
	
	
	public Pedido(String cli) {
		this.cliente = cli;
	}
	
	public void addProducto(IPrecio pro) {
		super.addProducto(pro);
	}

	public void removeProducto(IPrecio pro) {
		super.removeProducto(pro);
		
	}
	
	public void establecerCantidad(IPrecio pro, int cant) {
		if(pro instanceof ProductoUnitario) {
			ProductoUnitario prodUnit = (ProductoUnitario)pro;
			prodUnit.setCantidad(cant);
		}
		
	}
	
	public void establecerPeso(IPrecio pro,double peso) {
		if(pro instanceof ProductoPeso) {
			ProductoPeso proPes = (ProductoPeso)pro;
			proPes.setPeso(peso);
		}
	}
}
