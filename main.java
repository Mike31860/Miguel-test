package Snake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class main {
	
	public static int dado=6;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jugadores="";
		String taman="";
        System.out.print("Por favor digita el numero de jugadores: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
			jugadores = br.readLine();
			System.out.print("Por favor digita el tamano de la tabla: ");
	        taman = br.readLine();
	        
	        int players=Integer.parseInt(jugadores);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        String[] size=taman.split("x");
        
        
        //Populate the table with a defined size
        int[][] matrix=new int[25][25];
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix.length; j++) {
				matrix[i][j]=j;
				
			}
			
			
		}
        //boolean that will stop the iterations when the user wins
        boolean win=false;
        //position of the user in the table during a game
        int posiscion=0;
        //List that contains the positions where the stairs are located
        ArrayList<Integer> stairs= new ArrayList() {};
        stairs.add(3);
        stairs.add(10);
        stairs.add(9);
        stairs.add(6);
      //List that contains the positions where the snakes are located
        ArrayList<Integer> snakes= new ArrayList() {};
        stairs.add(14);
        stairs.add(19);
        stairs.add(22);
        stairs.add(24);
        //Loop that will start the game
        while(!win)
        {  
        	//Dado with a random number beetween 1 to 6
        	int aleatorio= (int) (Math.random() * 6);
        	System.out.print("Dado arroja "+aleatorio+"\n");
        	//CONDITION that ask if the random number plus the position has fallen in a stairs position
        	if(stairs.contains(posiscion+aleatorio))
        	{  
        		if(posiscion+aleatorio==3) {
        			posiscion=11;
        			System.out.print("Jugador sube por escalera a cuadro "+posiscion+"\n");
        			
        		}
        		else if(posiscion+aleatorio==10) {
        			posiscion=12;
        			System.out.print("Jugador sube por escalera a cuadro "+posiscion+"\n");
        		}
        		else if(posiscion+aleatorio==9) {
        			posiscion=18;
        			System.out.print("Jugador sube por escalera a cuadro"+posiscion+"\n");
        		}
        		else if(posiscion+aleatorio==6) {
        			posiscion=17;
        			System.out.print("Jugador sube por escalera a cuadro"+posiscion+"\n");
        		}
        	}
        	//CONDITION that ask if the random number plus the position has fallen in a snakes position
        	if(snakes.contains(posiscion+aleatorio))
        	{  
        		if(posiscion+aleatorio==14) {
        		  posiscion=4;
        		  System.out.print("Jugador descience a cuadro "+posiscion+"\n");}
        		else if(posiscion+aleatorio==19) {
        			posiscion=8;
        			System.out.print("Jugador descience a cuadro "+posiscion+"\n");
        		}
        		else if(posiscion+aleatorio==24) {
        			posiscion=16;
        			System.out.print("Jugador descience a cuadro "+posiscion+"\n");
        		}
        		else if(posiscion+aleatorio==22) {
        			posiscion=20;
        			System.out.print("Jugador descience a cuadro"+posiscion+"\n");
        		}
        	}
        	//CONDITION that ask if the random number plus the position has not fallen either in a stairs  or snakes position
        	if(!stairs.contains(posiscion+aleatorio)&&!snakes.contains(posiscion+aleatorio)) {
        		posiscion=posiscion+aleatorio;
        		System.out.print("Jugador avanza a cuadro "+posiscion+"\n");
        	}
        	//CONDITION that ask if the position is bigger than the limitd of the game
        	if(posiscion > 25)
        	{
        		posiscion=posiscion-(posiscion-25);
        	
        		
        	}
        	//CONDITION that asks if the actuall position is the final number in the table
        	if(posiscion==25)
        	{
        		win=true;
        		System.out.print("Fin\n");
        		
        	}
                 	
        	
        }
        
        
        
            

	}

}
