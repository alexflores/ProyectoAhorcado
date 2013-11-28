package AhorcadoTDD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Diccionario {
	
	String palabraDiccionario;
	String fraseDiccionario;
	String categoriaDiccionario;
	
	public ArrayList<String> ListaDePalabras = ObtenerListaDePalabras();
	
	private static final String _PALABRA_POR_DEFECTO = "sistemas";
	private static final String _FRASE_POR_DEFECTO = "permite estudiar y comprender la realidad, con el propósito de implementar u optimizar sistemas complejos";
	private static final String _CATEGORIA_POR_DEFECTO = "informática";
	
	public Diccionario()
	{}
	
	public Diccionario(String palabra, String frase, String categoria)
	{
		this.palabraDiccionario = palabra;
		this.fraseDiccionario = frase;
		this.categoriaDiccionario = categoria;
	}
	
	// Métodos Privados --------------------------------------------------------------------------------------
	
	private ArrayList<String> ObtenerListaDePalabras() {
		  ArrayList<String> ListaPalabras = new ArrayList<String>();
	      BufferedReader br = null;
	      try {
	         br = new BufferedReader(new FileReader (new File ("diccionario.txt")));
	         String linea = "";
	         while((linea = br.readLine())!=null)
	        	 ListaPalabras.add(linea);
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }
	      finally{
	          try{                    
	             if( null != br )  
	            	 br.close();               
	          }
	          catch (Exception e2){ 
	             e2.printStackTrace();
	          }
	      }
	      return ListaPalabras;
	}
	
	private void GuardarListaDePalabras(ArrayList<String> listaPalaras) {
		BorrarContenido();
		PrintWriter pw = null;
        try{
        	pw = new PrintWriter(new FileWriter("diccionario.txt", true));
    		for(int i=0; i<listaPalaras.size(); i++)
    		{
    			pw.println(listaPalaras.get(i));
    		}
        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
           try {
	           if (null != pw)
	        	   pw.close();
           } 
           catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}
	
	private boolean ExistePalabraEnDiccionario(String palabra) {
      boolean ExistePalabra = false;
      for(int i=0; i<ListaDePalabras.size();i++){
    	 if(palabra.toLowerCase().equals(GetPalabraLinea(ListaDePalabras.get(i))))
     		 ExistePalabra = true;
      }
	  return ExistePalabra;
	}

	private String GetPalabraLinea(String linea) {
		String[] datosPalara = linea.split("\\|");
		return datosPalara[0];
	}
	
	private String GetFraseLinea(String linea) {
		String[] datosPalara = linea.split("\\|");
		return datosPalara[1];
	}
	
	private String GetCategoriaLinea(String linea) {
		String[] datosPalara = linea.split("\\|");
		return datosPalara[2];
	}
	
	private boolean ValidarPalabra(String palabra) {
		boolean resp = true;
		int a = palabra.indexOf(' ');
		if(a>0)
			resp = false;
		return resp;
	}

	// Métodos Públicos --------------------------------------------------------------------------------
	
	public boolean BorrarContenido() {
		boolean resp = false;
		File fichero = new File("diccionario.txt");
		if (fichero.delete())
		{
			try {
				  if (fichero.createNewFile())
				    resp = true;
				  else
				    resp = false;
				} 
			catch (IOException ioe) {
				  ioe.printStackTrace();
				}
		}	 
		return resp;
	}
	
	public Boolean AniadirPalabra(Diccionario dic) {
        boolean resp = false;
        if(ValidarPalabra(dic.palabraDiccionario)){
            if(!ExistePalabraEnDiccionario(dic.palabraDiccionario)){
            	String nuevaPalabra = dic.palabraDiccionario.toLowerCase()+"|"+dic.fraseDiccionario.toLowerCase()+"|"+dic.categoriaDiccionario.toLowerCase();
            	ListaDePalabras.add(nuevaPalabra);
            	GuardarListaDePalabras(ListaDePalabras);
                resp = true;
            }
        }
		return resp;
	}

	public String LeerUltimaPalabraDelDiccionario() {
		String resp ="";
		int indexUltimaPalabra = ListaDePalabras.size();
		if(indexUltimaPalabra!=0)
			resp = GetPalabraLinea(ListaDePalabras.get(indexUltimaPalabra-1));
		return resp;
	}

	public String ObtenerPalabra() {
		ListaDePalabras = ObtenerListaDePalabras();
		String palabra = "";
		if(ListaDePalabras.size()==0){
			Diccionario d = new Diccionario();
			d.palabraDiccionario = _PALABRA_POR_DEFECTO;
			d.fraseDiccionario = _FRASE_POR_DEFECTO;
			d.categoriaDiccionario = _CATEGORIA_POR_DEFECTO;
			AniadirPalabra(d);
			palabra = d.palabraDiccionario;
		}
		else{
			int random = (int)(Math.random()*(ListaDePalabras.size()-1-0+1)+0);
			palabra = GetPalabraLinea(ListaDePalabras.get(random));
		}
		return palabra;
	}
	
	public ArrayList<String> MostrarPalabrasEnDiccionario() {
		if(ListaDePalabras.size()==0)
			return new ArrayList<String>();
		else	
			return ListaDePalabras;
	}

	public String ObtenerFraseDadaUnaPalabra(Diccionario dic) {
	    String palabraMasFrase = "";
		String FrasePalabra = "";
	    for(int i=0; i<ListaDePalabras.size(); i++){
	    	palabraMasFrase = ListaDePalabras.get(i);
	    	if(dic.palabraDiccionario.toLowerCase().equals(GetPalabraLinea(palabraMasFrase))){
	      		FrasePalabra = GetFraseLinea(palabraMasFrase);
	      	 }
	    }
	    return FrasePalabra;
	}

	public String ObtenerPalabraDadaUnaCategoria(Diccionario diccionario) {
		String palabraMasFrase = "";
		String categoriaPalabra = "";
	    for(int i=0; i<ListaDePalabras.size(); i++){
	    	palabraMasFrase = ListaDePalabras.get(i);
	    	if(diccionario.categoriaDiccionario.toLowerCase().equals(GetCategoriaLinea(palabraMasFrase))){
	    		categoriaPalabra = GetPalabraLinea(palabraMasFrase);
	      	 }
	    }
	    return categoriaPalabra;
	}

	public ArrayList<String> ObtenerCategoriasEnDiccionario() {
		ListaDePalabras = ObtenerListaDePalabras();
		ArrayList<String> ListaCategorias = new ArrayList<String>();
		String palabra = "";
	    for(int i=0; i<ListaDePalabras.size(); i++){
	    	palabra = ListaDePalabras.get(i);
	    	ListaCategorias.add(GetCategoriaLinea(palabra));
	    }
	    return ListaCategorias;
	}
}

