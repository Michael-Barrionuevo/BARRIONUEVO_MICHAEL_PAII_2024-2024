package factory;

public class ClienteFactoryImpl implements ClienteFactory {
    @Override
    public Cliente crearCliente(String nombre, String direccion, long telefono, String email) {
        return new Cliente(nombre, direccion, telefono, email);
    }

}
