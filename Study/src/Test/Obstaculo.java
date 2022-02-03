package Test;

public class Obstaculo {
	
	private int superior;
	private int inferior;
	private char tipo;
	
	
	public Obstaculo(int superior, int inferior, char tipo) {
		super();
		this.superior = superior;
		this.inferior = inferior;
		this.tipo = tipo;
	}
	
	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public int getSuperior() {
		return superior;
	}
	public void setSuperior(int superior) {
		this.superior = superior;
	}
	public int getInferior() {
		return inferior;
	}
	public void setInferior(int inferior) {
		this.inferior = inferior;
	}
	
	
	
	
	

}
