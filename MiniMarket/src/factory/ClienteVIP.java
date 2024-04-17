package factory;

import decorator.CuponesDescuentos;


public class ClienteVIP extends Cliente {
	
    private CuponesDescuentos cuponDescuento;

    public ClienteVIP(String nombre, String direccion, long telefono, String email) {
    	
        super(nombre, direccion, telefono, email);
    }

    public CuponesDescuentos getCuponDescuento() {
        return cuponDescuento;
    }

    public void setCuponDescuento(CuponesDescuentos cuponDescuento) {
        this.cuponDescuento = cuponDescuento;
    }
    
 // Método estático de fábrica para crear instancias de ClienteVIP
    public static ClienteVIP crearClienteVIP(String nombre, String direccion, long telefono, String email) {
        return new ClienteVIP(nombre, direccion, telefono, email);
    }

    // Getters y setters de la clase ClienteVIP
    // Estos getters y setters son necesarios para acceder a los atributos
    // heredados de la clase Cliente y a los atributos específicos de ClienteVIP
    public String getNombre() {
        return super.getNombre();
    }

    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    public String getDireccion() {
        return super.getDireccion();
    }

    public void setDireccion(String direccion) {
        super.setDireccion(direccion);
    }

    public long getTelefono() {
        return super.getTelefono();
    }

    public void setTelefono(long telefono) {
        super.setTelefono(telefono);
    }

    public String getEmail() {
        return super.getEmail();
    }

    public void setEmail(String email) {
        super.setEmail(email);
    }
}