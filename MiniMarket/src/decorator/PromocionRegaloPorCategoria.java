package decorator;

import java.util.HashMap;
import java.util.Map;

import model.Producto;

public class PromocionRegaloPorCategoria implements DecoratorPromocion {
	
    private Map<String, Producto> regalosPorCategoria;

    public PromocionRegaloPorCategoria() {
        regalosPorCategoria = new HashMap<>();
        // Define aquí los regalos para cada categoría
        regalosPorCategoria.put("Ropa", new Producto("Gorra","Gorra de Regalo ",0.0,"Accesorios de Regalo"));
        regalosPorCategoria.put("Electronica", new Producto("Auriculares", "Auriculares de Regalo", 0.0, "Accesorios de Regalo"));
        regalosPorCategoria.put("Juguetes", new Producto("Peluche Stich","Peluche de Regalo ",0.0,"Accesorios de Regalo"));
        regalosPorCategoria.put("Libros", new Producto(" Libro aleatorio de Terror ", "Libro de Regalo", 0.0, "Accesorios de Regalo"));
        regalosPorCategoria.put("Animales", new Producto("Juguete para perro o gato","Jugute de Regalo ",0.0,"Accesorios de Regalo"));
        regalosPorCategoria.put("Electrodomesticos", new Producto("Mini Batidora", "Mini Batidora de Regalo", 0.0, "Accesorios de Regalo"));
        regalosPorCategoria.put("Limpieza", new Producto("Fundas de Basura","Fundas de Regalo ",0.0,"Accesorios de Regalo"));
        regalosPorCategoria.put("Dulces", new Producto(" Huevito Kinder ", "Chocolate  de Regalo", 0.0, " Dulce de Regalo"));
        
    }

    @Override
    public void aplicarPromocion(Producto producto) {
        for (Map.Entry<String, Producto> entry : regalosPorCategoria.entrySet()) {
            String categoria = entry.getKey();
            Producto regalo = entry.getValue();

            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                System.out.println("¡Felicidades! Has recibido un regalo con tu compra de " + producto.getName());
                System.out.println(" Tu Regalo es : " + regalo.getName());
                return;
            }
        }
        System.out.println("No hay promoción de regalo para este producto.");
    }
    
}
