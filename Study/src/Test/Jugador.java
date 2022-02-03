package Test;

public class Jugador {
	
	private int id;
	private int posicion;
	private boolean win;

	

	public Jugador(int id, int posicion, boolean win) {
		super();
		this.id = id;
		this.posicion = posicion;
		this.win = win;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}
	
	

}
