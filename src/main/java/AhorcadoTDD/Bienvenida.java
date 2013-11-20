package AhorcadoTDD;

public class Bienvenida {

   private String _BIENVENIDA="Bienvenido al juego del Ahorcado";	
	
   public void bienvenida()
   {
	  System.out.println(_BIENVENIDA); 
   }
   
   public boolean esEnter(char tecla)
   {      
	  boolean es=false;
 
	    if (tecla==13)
	    {
	    	es=true;
	    }
	  return es;
   }
	
}
