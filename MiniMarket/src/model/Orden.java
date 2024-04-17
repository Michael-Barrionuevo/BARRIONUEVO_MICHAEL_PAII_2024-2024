package model;

import java.util.ArrayList;
import java.util.List;
import factory.Cliente;
import factory.ClienteVIP;
import decorator.DecoratorPrecios;
import decorator.CuponesDescuentos;

public class Orden {
	
	private Cliente cliente;
    private List<Producto> productos;
    private double total;
    
    private ClienteVIP clienteVIP;
    private List<Producto> productosVIP;
    private double totalVIP;

    public Orden(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.total = 0.0;
    }

    public Orden(ClienteVIP clienteVIP) {
        this.clienteVIP = clienteVIP;
        this.productosVIP = new ArrayList<>();
        this.totalVIP = 0.0;
    }

    public void añadirProducto(Producto producto) {
        if (cliente != null) {
            productos.add(producto);
            total += producto.getPrecio();
        } else if (clienteVIP != null) {
            productosVIP.add(producto);
            totalVIP += producto.getPrecio();
        }
    }

    public void añadirProductoDesc(Producto producto, double precioConDescuento) {
        producto.setPrice(precioConDescuento);
        añadirProducto(producto);
    }

    public void removerProducto(Producto producto) {
        if (cliente != null) {
            if (productos.remove(producto)) {
                total -= producto.getPrecio();
            }
        } else if (clienteVIP != null) {
            if (productosVIP.remove(producto)) {
                totalVIP -= producto.getPrecio();
            }
        }
    }
    
    public int obtenerCantidadProductos() {
        if (cliente != null) {
            return productos.size();
        } else if (clienteVIP != null) {
            return productosVIP.size();
        } else {
            return 0;
        }
    }

    public void vaciarOrden() {
        if (cliente != null) {
            productos.clear();
            total = 0.0;
        } else if (clienteVIP != null) {
            productosVIP.clear();
            totalVIP = 0.0;
        }
    }

    public boolean productoOrden(Producto producto) {
        if (cliente != null) {
            return productos.contains(producto);
        } else if (clienteVIP != null) {
            return productosVIP.contains(producto);
        } else {
            return false;
        }
    }

    public double getTotal() {
        if (cliente != null) {
            return total;
        } else if (clienteVIP != null) {
            return totalVIP;
        } else {
            return 0.0;
        }
    }

    public void setTotal(double total) {
        if (cliente != null) {
            this.total = total;
        } else if (clienteVIP != null) {
            this.totalVIP = total;
        }
    }

    
   /* public double getTotal() {
        if (cliente != null) {
            return total;
        } else if (clienteVIP != null) {
            return aplicarDescuentoCupon(totalVIP);
        } else {
            return 0.0;
        }
    }*/

    private double aplicarDescuentoCupon(double total) {
        if (clienteVIP != null && clienteVIP.getCuponDescuento() != null) {
            CuponesDescuentos cuponDescuento = clienteVIP.getCuponDescuento();
            return cuponDescuento.calcularPrecio(total);
        } else {
            return total;
        }
    }

 // Método en la clase Orden
    public void aplicarDescuento(double porcentajeDescuento) {
        if (cliente != null) {
            System.out.println("No se aplican descuentos para cliente normal.");
        } else if (clienteVIP != null) {
            double descuento = porcentajeDescuento / 100.0; // Convertir el porcentaje a decimal
            totalVIP *= (1 - descuento); // Aplicar el descuento al totalVIP
        } else {
            // Lanzar una excepción o imprimir un mensaje indicando que el cliente no es válido
            throw new UnsupportedOperationException("El cliente no es válido, no se pueden aplicar descuentos.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Orden [");
        
        if (cliente != null) {
            sb.append("cliente=").append(cliente);
            if (!productos.isEmpty()) {
                sb.append(", productos=").append(productos);
                sb.append(", total=").append(total);
            }
        } else if (clienteVIP != null) {
            sb.append("clientevip=").append(clienteVIP);
            if (!productosVIP.isEmpty()) {
                sb.append(", productos=").append(productosVIP);
                sb.append(", total=").append(totalVIP);
            }
        }
        
        sb.append("]");
        
        return sb.toString();
    }
    

}
