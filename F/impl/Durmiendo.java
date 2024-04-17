package impl;

import java.util.Timer;
import java.util.TimerTask;

import inter.IEstado;
import inter.Mascota;

public class Durmiendo implements IEstado {
	
	Mascota mascota;

	@Override
	public void jugar() {
		System.out.println("shhhhhhhhh");
	}

	@Override
	public void alimentar() {
		System.out.println("Shhhhhhhhhhh");
		
	}

	@Override
	public void dormir() {
		System.out.println("Shhhhhhhhhhh");
	}

	@Override
	public void estadoAnimo() {
		System.out.println("Esta durmiendo");
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				Durmiendo.this.mascota.setEstado(new Hambriento());
				
			}
		}, 6000);
		System.out.println("ya desperto");
	}

	@Override
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
		
	}


}
