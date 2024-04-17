package srt;

import inter.Mascota;

public class AppState {

	public static void main(String[] args) {
		Mascota mascota = new Mascota();
		Menu menu = new Menu(mascota);
		menu.display();
		

	}

}
