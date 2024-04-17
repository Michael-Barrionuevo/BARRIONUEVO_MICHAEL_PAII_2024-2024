package factory;

public class Cliente {
	
	private String nombre;
    private String direccion;
    private long telefono;
    private String email;

   
    public Cliente(String nombre, String direccion, long telefono, String email) {
    	this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public long getTelefono() {
		return telefono;
	}


	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email
				+ "]";
	}

	// Método estático de fábrica para crear instancias de Cliente
    public static Cliente crearCliente(String nombre, String direccion, long telefono, String email) {
        return new Cliente(nombre, direccion, telefono, email);
    }


	


}
