package controller;

import java.util.ArrayList;
import java.util.List;

import factory.Cliente;
import model.Orden;
import model.Producto;

public class ControlTienda {

	private List<Producto> carrito;
	private Cliente cliente;

	public ControlTienda(Cliente cliente) {
		this.cliente = cliente;
		this.carrito = new ArrayList<>();
	}

	public void añadirAlCarrito(Producto producto) {
		carrito.add(producto);
	}

	public void removerDelCarrito(Producto producto) {
		carrito.remove(producto);
	}

	public void vaciarCarrito() {
		carrito.clear();
	}

	// Método para realizar un pedido con los productos en el carrito
	public Orden realizarPedido() {
		Orden order = new Orden(cliente);
		for (Producto producto : carrito) {
			order.añadirProducto(producto);
		}
		// Limpiar el carrito después de realizar el pedido
		vaciarCarrito();
		return order;
	}
}
