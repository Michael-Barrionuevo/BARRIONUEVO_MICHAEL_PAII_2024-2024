package factory;

public class ClienteVIPFactoryImpl implements ClienteVIPFactory {
    @Override
    public ClienteVIP crearClienteVIP(String nombre, String direccion, long telefono, String email) {
        return new ClienteVIP(nombre, direccion, telefono, email);
    }

}
