package AhorcadoTDD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Ranking {
	
	public ArrayList<String> ObtenerUsuarios()//no tiene test porque estoy reutilizando codigo de diccionario que ya tiene test
	{
		  File archivo = null;
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
	      return ListaPalabras;
		}

	public int sacar(String linea) {
		int resp;
		String[] campos = linea.split (" "); 
		return resp=Integer.parseInt(campos[1]);
	}
}
