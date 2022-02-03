package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test {

	public static int dado = 6;
	private static Tablero tablero;

	public static void main(String[] args) throws IOException, NumberFormatException {
		// TODO Auto-generated method stub
		String jugadores = "";
		String taman = "";
		String obstaculos = "";
		System.out.print("Por favor digita el numero de jugadores: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		jugadores = br.readLine();
		System.out.print("Por favor digita el tamano de la tabla: ");
		taman = br.readLine();
        //Jugadores en el tablero
		int players = Integer.parseInt(jugadores);

		//Sacar el largo y alto del tablero
		String[] size = taman.split("x");
		System.out.print("Por favor digita los obstáculos de la Tabla:");
		
		tablero = new Tablero(Integer.parseInt(size[0]), Integer.parseInt(size[1]));
		// 3:11,10:12,9:18,6:17-4:14,8:19,20:22,16:24
		obstaculos = br.readLine();
		String[] obs = obstaculos.split("-");
		String[] escaleras = obs[0].split(",");
		String[] serpientes = obs[1].split(",");
		ArrayList<Obstaculo> ob = new ArrayList<Obstaculo>();

		//Llenar los obstaculos de tipo escaleras en el tablero
		for (int i = 0; i < escaleras.length; i++) {
			String[] xy = escaleras[i].split(":");
			Obstaculo esca = new Obstaculo(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]), 'E');
			ob.add(esca);
		}
		//Llenar los obstaculos de tipo serpiente en el tablero
		for (int i = 0; i < serpientes.length; i++) {
			String[] xy = serpientes[i].split(":");
			Obstaculo serp = new Obstaculo(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]), 'S');
			ob.add(serp);
		}

		tablero.setObstaculos(ob);
		
		//Llenar el número de jugadores en el tablero
		ArrayList<Jugador> play = new ArrayList<Jugador>();
		for (int i = 0; i < players; i++) {
			Jugador ju = new Jugador(i, 0, false);
			play.add(ju);
		}
		tablero.setJugadores(play);

	
		
		//contador que indica si todos los jugadores han ganado el juego
		int contador=0;
		// Loop that will start the game
		while (contador!=tablero.getJugadores().size()) {
			// Loop del numero de jugadores
			for (int l = 0; l < tablero.getJugadores().size(); l++) {
				//condicion que valida si el jugador que va a tirar el dado ya ha ganado
				if (!tablero.getJugadores().get(l).isWin()) {
					//dado aleatorio
					int aleatorio = (int) (Math.random() * 5) + 1;
					int ju=l+1;
					System.out.print("Jugador " + ju + " arroja arroja dado " + aleatorio + "\n");
					// booleano que indica si el jugador ha cido en alguna de las  trampas
					boolean isInside = false;
					//loop que verifica si el tiro del jugador ha caido en algun obstaculo
					for (int i = 0; i < tablero.getObstaculos().size() && !isInside; i++) {
						//cada obstaculo tiene una parte superior y una inferior que decide si asciende o desciende
						int inferior = tablero.getObstaculos().get(i).getInferior();
						int superior = tablero.getObstaculos().get(i).getSuperior();
						//condiciones que verifica si el jugador ha caido en un obstaculo de tipo serpiente o escalera
						if (tablero.getObstaculos().get(i)
								.getInferior() == (tablero.getJugadores().get(l).getPosicion() + aleatorio)
								&& tablero.getObstaculos().get(i).getTipo() == 'E') {
							tablero.getJugadores().get(l).setPosicion(tablero.getObstaculos().get(i).getSuperior());
							isInside = true;
							System.out.print("Jugador " + ju + " sube por escalera a cuadro "
									+ tablero.getJugadores().get(l).getPosicion() + "\n");
						} else if (tablero.getObstaculos().get(i)
								.getSuperior() == (tablero.getJugadores().get(l).getPosicion() + aleatorio)
								&& tablero.getObstaculos().get(i).getTipo() == 'S') {
							tablero.getJugadores().get(l).setPosicion(tablero.getObstaculos().get(i).getInferior());
							isInside = true;
							System.out.print("Jugador " + ju + " descience a cuadro "
									+ tablero.getJugadores().get(l).getPosicion() + "\n");
						}
					}

					//Condicion ue verifica si el jugador no ha caido en ningun obstaculo
					if (!isInside) {
						tablero.getJugadores().get(l)
								.setPosicion(tablero.getJugadores().get(l).getPosicion() + aleatorio);
						System.out.print("Jugador " + ju + " avanza a cuadro "
								+ tablero.getJugadores().get(l).getPosicion() + "\n");
					}
					// Condicion que verifica si la posicion del jugador actual más el resultado del dado supera
					//el limite del tablero, haciendo que este se devuelva la diferencia entre e maximo del tablero
					// y el resultado del dado
					if (tablero.getJugadores().get(l).getPosicion() > (tablero.getLargo() * tablero.getAlto())) {
						tablero.getJugadores().get(l).setPosicion(tablero.getJugadores().get(l).getPosicion()
								- (tablero.getJugadores().get(l).getPosicion() - (tablero.getLargo() * tablero.getAlto())));
						System.out.print("Jugador " + ju + " se devuelve  "
								+ (tablero.getJugadores().get(l).getPosicion() - (tablero.getLargo() * tablero.getAlto())) + " casillas \n");
					}
					// Condision que verifica si el jugador x ha ganado la partida
					if (tablero.getJugadores().get(l).getPosicion() == (tablero.getLargo() * tablero.getAlto())) {
						tablero.getJugadores().get(l).setWin(true);
						System.out.print("Jugador " + ju + " Fin\n");
						contador++;

					}
					

				}
			}
		}

	}

}
