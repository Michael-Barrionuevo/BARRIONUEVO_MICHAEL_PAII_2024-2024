package Test;

import decorator.DecoratorPrecios;
import decorator.CuponesDescuentos;
import decorator.PromocionRegaloPorCategoria;
import model.Orden;
import model.Producto;
import factory.Cliente;
import factory.ClienteVIP;
import factory.ClienteVIPFactoryImpl;
import factory.ClienteFactory;
import factory.ClienteFactoryImpl;

public class Principal {
	
public static void main(String[] args) {
	
	 ClienteFactoryImpl clienteFactory = new ClienteFactoryImpl();
     Cliente cliente = clienteFactory.crearCliente("Mark Hamil", "Guayas", 7787, "guayacoShip@");

     ClienteVIPFactoryImpl clienteVIPFactory = new ClienteVIPFactoryImpl();
     ClienteVIP clienteVIP = clienteVIPFactory.crearClienteVIP("Byron", "Quito", 2346, "fatimalove@");

     // Creamos los productos
     Producto producto = new Producto("Camisa", "Camisa de algodón", 60.0, "Ropa");
     Producto producto1 = new Producto("Parlante", "Parlante para Carro", 100.0, "Electronica");
     Producto producto2 = new Producto("Papitas", "Papas Fritolay", 1.0, "Comida");

     // Creamos la orden sin descuentos para cliente normal
     Orden orden = new Orden(cliente);
     orden.añadirProducto(producto);
     orden.añadirProducto(producto1);
     orden.añadirProducto(producto2);

     // Intentamos aplicar descuentos para cliente normal (10%)
     orden.aplicarDescuento(10);

     // Imprimimos el resumen de la orden original para cliente normal
     System.out.println("Resumen de la orden para cliente normal:");
     System.out.println(orden);

     // Calculamos el total sin descuento para cliente normal
     double totalClienteNormal = orden.getTotal();

     // Imprimimos el total sin descuento para cliente normal
     System.out.println("Total de la orden para cliente normal: " + totalClienteNormal);

     // Creamos la orden sin descuentos para cliente VIP
     Orden orden1 = new Orden(clienteVIP);
     orden1.añadirProducto(producto);
     orden1.añadirProducto(producto1);

     // Aplicamos descuentos para cliente VIP (20%)
     orden1.aplicarDescuento(20);

     // Imprimimos el resumen de la orden para cliente VIP con descuentos aplicados
     System.out.println("Resumen de la orden para cliente VIP:");
     System.out.println(orden1);

     // Calculamos el total con descuento para cliente VIP
     double totalConDescuentoClienteVIP = orden1.getTotal();

     // Imprimimos el total con descuento para cliente VIP
     System.out.println("Total de la orden con descuento para cliente VIP: " + totalConDescuentoClienteVIP);
 }
}

 

	
    
   

     
    
   


