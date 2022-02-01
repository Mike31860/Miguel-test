package Snake;

public class Apex {
	    public static integer dado=6;
	 public static void updateOlderAccounts() {


	        boolean win=false;
	        integer  posiscion=0;
	        integer  [] stairs = new List<integer >();
	        // ArrayList<Integer> stairs= new ArrayList();
	        stairs.add(3);
	        stairs.add(10);
	        stairs.add(9);
	        stairs.add(6);
	        integer  [] snakes= new List<integer >();
	        stairs.add(14);
	        stairs.add(19);
	        stairs.add(22);
	        stairs.add(24);
	        while(!win)
	        {  
	        	integer  aleatorio= (integer) (Math.random() * dado);
	        	System.debug('Dado arroja '+aleatorio+'\n');
	        	if(stairs.contains(posiscion+aleatorio))
	        	{  
	        		if(posiscion+aleatorio==3) {
	        			posiscion=11;
	        			System.debug('Jugador sube por escalera a cuadro '+posiscion+'\n');
	        			
	        		}
	        		else if(posiscion+aleatorio==10) {
	        			posiscion=12;
	        			System.debug('Jugador sube por escalera a cuadro '+posiscion+'\n');
	        		}
	        		else if(posiscion+aleatorio==9) {
	        			posiscion=18;
	        			System.debug('Jugador sube por escalera a cuadro '+posiscion+'\n');
	        		}
	        		else if(posiscion+aleatorio==6) {
	        			posiscion=17;
	        			System.debug('Jugador sube por escalera a cuadro '+posiscion+'\n');
	        		}
	        	}
	        	if(snakes.contains(posiscion+aleatorio))
	        	{  
	        		if(posiscion+aleatorio==14) {
	        		  posiscion=4;
	        		  System.debug('Jugador descience a cuadro '+posiscion+'\n');}
	        		else if(posiscion+aleatorio==19) {
	        			posiscion=8;
	        			System.debug('Jugador descience a cuadro '+posiscion+'\n');
	        		}
	        		else if(posiscion+aleatorio==24) {
	        			posiscion=16;
	        			System.debug('Jugador descience a '+posiscion+'\n');
	        		}
	        		else if(posiscion+aleatorio==22) {
	        			posiscion=20;
	        			System.debug('Jugador descience a '+posiscion+'\n');
	        		}
	        	}
	        	if(!stairs.contains(posiscion+aleatorio)&&!snakes.contains(posiscion+aleatorio)) {
	        		posiscion=posiscion+aleatorio;
	        		System.debug('Jugador avanza a cuadro '+posiscion+'\n');
	        	}
	        	if(posiscion > 25)
	        	{
	        		posiscion=posiscion-(posiscion-25);
	        	
	        		
	        	}
	        	
	        	if(posiscion==25)
	        	{
	        		win=true;
	        		System.debug('Fin\n');
	        		posiscion=0;
	        	}
	                 	
	        	
	        }
	        
	    }
	}


