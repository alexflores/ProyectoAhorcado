package AhorcadoTDD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Ranking {
	
<<<<<<< HEAD
	public ArrayList<String> ObtenerUsuarios()
	{
		
		File archivo = null;
=======
	public ArrayList<String> ObtenerPalabra() {
		
		  File archivo = null;
>>>>>>> be9f28b24b919fc9f790bf55b77b197e12529842
	      FileReader fr = null;
	      BufferedReader br = null;
	      
	      ArrayList<String> ListaPalabras = new ArrayList<String>();
	 
	      try 
	      {
	         archivo = new File ("PruebaRudy.txt");
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	         String linea = "";
	         while((linea = br.readLine())!=null)
	        	 ListaPalabras.add(linea);
	      }
	      catch(Exception e)
	      {
	         e.printStackTrace();
	      }
	      finally
	      {
	          try
	          {                    
	             if( null != fr )  
	                fr.close();               
	          }
	          catch (Exception e2)
	          { 
	             e2.printStackTrace();
	          }
	      }
<<<<<<< HEAD
		return ListaPalabras;
	
	}
	
=======
	
		
		return ListaPalabras;
	}
>>>>>>> be9f28b24b919fc9f790bf55b77b197e12529842
}
