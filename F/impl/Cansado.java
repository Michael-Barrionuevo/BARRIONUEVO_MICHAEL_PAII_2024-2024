package impl;

import java.util.Timer;
import java.util.TimerTask;

import inter.IEstado;
import inter.Mascota;

public class Cansado implements IEstado {

	private Mascota mascota;
	
	@Override
	public void jugar() {
		System.out.println("No quiero jugar, estoy muy cansado");
		
	}

	@Override
	public void alimentar() {
		System.out.println("No tengo hambre, estoy cansado");
		
	}

	@Override
	public void dormir() {
		System.out.println("Siiiiii,tengo mucho sueno, buenas noches");	
		mascota.setEstado(new Durmiendo());
	}

	@Override
	public void estadoAnimo() {
		System.out.println("Esta cansado");
		
	}

	@Override
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
		
	}

}
