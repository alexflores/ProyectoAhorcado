package AhorcadoTDD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Diccionario {
	
	public Diccionario()
	{}
	
	public boolean ValidarPalabra(String palabra) {
		boolean resp = true;
		int a = palabra.indexOf(' ');
		if(a>0)
			resp = false;
		return resp;
	}
	
	public Boolean AniadirPalabra(String palabra, String frase) {
        PrintWriter pw = null;
	      
        boolean resp = false;
        if(ValidarPalabra(palabra))
        {
	        try
	        {
	            if(!BuscarPalabraEnDiccionario(palabra))
	            {
	            	pw = new PrintWriter(new FileWriter("diccionario.txt", true));
	                pw.println(palabra.toLowerCase()+"|"+frase);
	                resp = true;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           if (null != pw)
	        	   pw.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
        }

		return resp;
	}

	private boolean BuscarPalabraEnDiccionario(String palabra) {
		
	  File archivo = null;
      FileReader fr = null;
      BufferedReader br = null; 
      boolean ExistePalabra = false;
 
      try 
      {
         archivo = new File ("diccionario.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
         String linea = "";
         
         while((linea = br.readLine())!=null)
        	 if(palabra.toLowerCase().equals(GetPalabraLinea(linea)))
        	 {
        		 ExistePalabra = true;
        	 }
      }catch (Exception e) {
          e.printStackTrace();
      } finally {
         try {
         if (null != fr)
        	 fr.close();
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
	  return ExistePalabra;
	}

	private String GetPalabraLinea(String linea) {
		String[] datosPalara = linea.split("\\|");
		return datosPalara[0];
	}

	public String LeerUltimaPalabraDelDiccionario() {
		
		  File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;
	      String Palabra = "";
	 
	      try 
	      {
	         archivo = new File ("diccionario.txt");
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	         String linea = "";
	         while((linea = br.readLine())!=null)
	        	 Palabra = GetPalabraLinea(linea);
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
		
		return Palabra;
	}

	public boolean BorrarContenido() {
		
		boolean resp = false;
		File fichero = new File("diccionario.txt");
		if (fichero.delete())
		{
			try {
				  // A partir del objeto File creamos el fichero físicamente
				  if (fichero.createNewFile())
				    resp = true;
				  else
				    resp = false;
				} catch (IOException ioe) {
				  ioe.printStackTrace();
				}
		}	 
		return resp;
	}

	public String ObtenerPalabra() {
		
		  File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;
	      
	      ArrayList<String> ListaPalabras = new ArrayList<String>();
	 
	      try 
	      {
	         archivo = new File ("diccionario.txt");
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	         String linea = "";
	         while((linea = br.readLine())!=null)
	        	 ListaPalabras.add(GetPalabraLinea(linea));
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
		
		return GetPalabraRandomica(ListaPalabras);
	}

	private String GetPalabraRandomica(ArrayList<String> listaPalabras) {
		int random = (int)(Math.random()*(listaPalabras.size()-1-0+1)+0);
		return listaPalabras.get(random);
	}
	
public ArrayList<String> MostrarPalabrasEnDiccionario() {
		
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	      
	    ArrayList<String> ListaPalabras = new ArrayList<String>();
	 
	    try 
	    {
	         archivo = new File ("diccionario.txt");
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	         String linea = "";
	         while((linea = br.readLine())!=null)
	        	 ListaPalabras.add(GetPalabraLinea(linea));
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

	public String ObtenerFraseDadaUnaPalabra(String palabra, String frase) {
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null; 
	    String FrasePalabra = "";
	
	    try 
	    {
	       archivo = new File ("diccionario.txt");
	       fr = new FileReader (archivo);
	       br = new BufferedReader(fr);
	       String linea = "";
	       
	       while((linea = br.readLine())!=null)
	      	 if(palabra.toLowerCase().equals(GetPalabraLinea(linea)))
	      	 {
	      		FrasePalabra = GetFraseLinea(linea);
	      	 }
	    }catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	       try {
	       if (null != fr)
	      	 fr.close();
	       } catch (Exception e2) {
	          e2.printStackTrace();
	       }
	    }
	  return FrasePalabra;
	}

	private String GetFraseLinea(String linea) {
		String[] datosPalara = linea.split("\\|");
		return datosPalara[1];
	}

}

