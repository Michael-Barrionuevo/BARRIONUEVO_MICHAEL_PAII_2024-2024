package decorator;

public class PrecioRegular implements DecoratorPrecios {

	@Override
	public double calcularPrecio(double precio) {
		
		return precio;
		
	}

}
