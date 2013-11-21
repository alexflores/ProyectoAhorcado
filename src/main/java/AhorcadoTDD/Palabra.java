package AhorcadoTDD;

import java.util.ArrayList;

public class Palabra {
    
	private ArrayList _LETRAS;
	
	public Palabra(String palabra)
	{
		_LETRAS = new ArrayList();
		
		// Adicionar las letras al vector recorriendo todos los caracteres del String
		int i = 0;
		int cantLetras = palabra.length();
		
		while(i < cantLetras)
		{
			// Cada uno de los caracteres del String se convierte en una letra
			char c = palabra.charAt(i);
			Letra l = new Letra(c);
			_LETRAS.add(l);
			i++;
		}
	}
	
	 public ArrayList getLetras( )
	 {
	        return _LETRAS;
	 }
	
	public boolean buscarLetraEnVector(Letra letra, ArrayList vecLetras)
	{
		boolean esta = false;
		int cont = 0;
		
		while(cont < vecLetras.size() && !esta)
		{
			Letra l = (Letra)vecLetras.get(cont);
			
			if(l.esIgual(letra))
			{
				esta = true;
			}
			cont++;
		}
		return esta;
	}
	
	public boolean estaLetra(Letra letra)
	{
		return buscarLetraEnVector(letra, _LETRAS);
	}
	
	public ArrayList darOcurrencias(ArrayList jugadas)
	{
		ArrayList visibles = new ArrayList();
		
		int cont = 0;
		//Se recorren todas las letras de la palabra
		while(cont < _LETRAS.size())
		{
		    Letra l = (Letra)_LETRAS.get(cont);
		    //La letra no esta dentro de las jugadas (no se muestra)
		    if(!buscarLetraEnVector(l,jugadas))
		    {
		    	visibles.add(new Letra('_'));
		    }
		    else{
		    	//La letra ya se jugo entonces se muestra
		    	visibles.add(l);
		    }
		    cont++;
		}
		return visibles;
	}
}

