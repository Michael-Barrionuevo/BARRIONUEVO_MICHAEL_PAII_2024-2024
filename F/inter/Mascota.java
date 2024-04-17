package inter;

import impl.Aburrido;

public class Mascota {

	private IEstado estado;
	
	public Mascota() {
		this.setEstado(new Aburrido());
	
	}
	public void setEstado(IEstado estado) {
		this.estado = estado;
		this.estado.setMascota(this);
	}
	
	public void  jugar() {
		this.estado.jugar();
	}
	 public void alimentar() {
		 this.estado.alimentar();
	 }
	public void dormir() {
		this.estado.dormir();
	}
	public void estadoAnimo() {
		this.estado.estadoAnimo();
	}
}
