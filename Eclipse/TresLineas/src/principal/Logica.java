package principal;

import java.util.ArrayList;

import comunicacion.UDPConexion;
import processing.core.PApplet;
import processing.core.PVector;

public class Logica {
	
	private PApplet app;
	private ArrayList<Casilla> casillas;
	public UDPConexion conexion;
	static public Logica log;
	
	
	public Logica() {
		this.app = Main.app;
		this.log = this;
		
		this.casillas = new ArrayList<>();
		

		for(int i = 0 ; i < 3; i++) {
			Casilla c = new Casilla(new PVector((app.width/3)*i, (app.height/3)*0));
			casillas.add(c);
		}
		
		for(int i = 0 ; i < 3; i++) {
			Casilla c = new Casilla(new PVector((app.width/3)*i, (app.height/3)*1));
			casillas.add(c);
		}
		
		for(int i = 0 ; i < 3; i++) {
			Casilla c = new Casilla(new PVector((app.width/3)*i, (app.height/3)*2));
			casillas.add(c);
		}
		
		this.conexion = UDPConexion.getIntance();
	}
	
	
	public void pintar(){
		this.app.background(255);
		for(int i = 0 ; i < this.casillas.size(); i++) {
			Casilla c = this.casillas.get(i);
			c.pintar();
		}
	}
	
	public void mousePressed() {
		
	}


	public void mouseReleased() {
		
		
	}


}


