package srt;

import inter.Mascota;
import java.util.Scanner;

public class Menu {

	private Mascota mascota;
	
	public Menu(Mascota mascota) {
		this.mascota = mascota;
	}
	
	public void display() {
		Scanner sc = new Scanner(System.in);
		int op;
		String mns = "Escoger: 1. alimentar, 2. dormir, 3. jugar, 4. ver Estado, 5. salir";
		do {
			System.out.println(mns);
			op = sc.nextInt();
			
			switch(op) {
			case 1:
				mascota.alimentar();
				break;
			case 2:
				mascota.dormir();
				break;
			case 3:
				mascota.jugar();
				break;
			case 4:
				mascota.estadoAnimo();
				break;
			case 5:
				System.out.println("Adios");
				System.out.println(0);
				default :
					System.out.println("Opcion no valida");
			}
			
		}while(op!=5);
	}

}
