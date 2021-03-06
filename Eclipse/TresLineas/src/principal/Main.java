package principal;

import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main("principal.Main");
	}
	
	static public PApplet app;
	private Logica log;
	
	@Override
	public void settings() {
		app = this;
		size(500, 500);
	}
	
	public void setup() {
		this.log = new Logica();
	}
	
	@Override
	public void draw() {
		log.pintar();
	}
	
	@Override
	public void mousePressed() {
		log.mousePressed();
	}
	
	@Override
	public void mouseReleased() {
		log.mouseReleased();
	}

}
