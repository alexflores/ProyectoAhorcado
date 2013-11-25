package AhorcadoTDD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Ranking {
	public ArrayList<String> ListaPalabras = new ArrayList<String>();
	
	public void ObtenerUsuarios()//no tiene test porque estoy reutilizando codigo de diccionario que ya tiene test
	{
		  File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;
	      	 
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
		}

	public int sacar(String linea) {
		int resp;
		String[] campos = linea.split (" "); 
		return resp=Integer.parseInt(campos[1]);
	}
	public void OrdenamientoBurbuja(){//no tiene test porque es el burbuja...
		int i,j;
		String pos=" ";
		for(i=0;i<ListaPalabras.size()+1;i++)
		{
			for(j=0;j<ListaPalabras.size()-i-1;j++)
			{
				int auxi=sacar(ListaPalabras.get(j+1));
				int auxilio=sacar(ListaPalabras.get(j));
				if(auxi<auxilio)
				{
					pos=ListaPalabras.get(j+1);
					ListaPalabras.set(j+1,ListaPalabras.get(j));
					ListaPalabras.set(j,pos);
				}
			}
		}
	}
}
