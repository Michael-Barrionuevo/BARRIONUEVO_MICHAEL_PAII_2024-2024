package impl;

import inter.IEstado;
import inter.Mascota;

public class Aburrido implements IEstado{
	
	private Mascota mascota;

	@Override
	public void jugar() {
				System.out.println("Siiiiiii, jugemos");
				mascota.setEstado(new Cansado());
	}

	@Override
	public void alimentar() {
		System.out.println("Estoy aburrido, no quiero comer");
		
	}

	@Override
	public void dormir() {
		System.out.println("No tengo sueno, estoy aburrido");
	}

	@Override
	public void estadoAnimo() {
		System.out.println("Esta Aburrido");
		
	}

	@Override
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
		
	}

}
