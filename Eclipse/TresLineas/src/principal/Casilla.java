package principal;

import comunicacion.UDPConexion;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Casilla {

	private PVector pos;
	private PVector tam;
	private PApplet app;
	private Logica log;
	private UDPConexion conexion;
	
	public Casilla(PVector pos) {
		this.app = Main.app;
		this.log = Logica.log;
		this.pos = pos;
		this.tam = new PVector((app.width/3)-20, (app.height/3)-20);
	}
	
	public void pintar() {
		this.app.rectMode(PConstants.CORNER);
		this.app.fill(225, 230, 246);
		this.app.stroke(213, 73, 69);
		this.app.rect(this.pos.x, this.pos.y, this.tam.x, this.tam.y);
	}
	
	public boolean rollover() {
		boolean rollover = false;
		if(this.app.mouseX > this.pos.x && this.app.mouseX < (this.pos.x + this.tam.x) && this.app.mouseY > this.pos.y && this.app.mouseY < (this.pos.y + this.tam.y)) {
			rollover = true;
		}
		return rollover;
	}
	
	public void mousePressed() {
		
		if(rollover()) {
			
		}
		
	}
}
