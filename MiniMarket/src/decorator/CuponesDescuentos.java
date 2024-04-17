package decorator;

import model.Producto;

public class CuponesDescuentos implements DecoratorPrecios {
    private double porcentajeDescuento;

    public CuponesDescuentos(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public double calcularPrecio(double precio) {
        return precio * (1 - (porcentajeDescuento / 100));
    }
}


