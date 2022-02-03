package Test;

import java.util.ArrayList;

public class Tablero {
	
	private int largo;
	private int alto;
	private ArrayList<Obstaculo> obstaculos;
	private ArrayList<Jugador> jugadores;
	
	public Tablero(int largo, int alto) {
		super();
		this.largo = largo;
		this.alto = alto;
	}

	public int getLargo() {
		return largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public ArrayList<Obstaculo> getObstaculos() {
		return obstaculos;
	}

	public void setObstaculos(ArrayList<Obstaculo> obstaculo) {
		this.obstaculos = obstaculo;
	}
	
	
	
    
}
