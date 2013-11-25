package AhorcadoTDD;

import java.util.ArrayList;

public class Juego {
	
    public static final int JUGANDO = 0;
    //Vector de letras jugadas por el jugador
	private ArrayList<Letra> _JUGADAS;
	
	private Palabra _ACTUAL;
	
	private int estado;
	
	public static final int GANADOR = 1;

	public static final int AHORCADO = 2;
	
	public String _RESULTADO = "";
	
	public void iniciarJuego(String palabra)
	{
		//recibo una palabra al azar del diccionario
		_ACTUAL = (new Palabra(palabra));
		
		//inicializar el vector de letras jugadas
		_JUGADAS = new ArrayList<Letra>();
	}
	
	public boolean jugarLetra(Letra letra)
	{
		//agregar la letra a las jugadas
		_JUGADAS.add(letra);
		
		//revisar si la letra pertenece a la palabra
		boolean pertenece = _ACTUAL.estaLetra(letra);
		
		//Si la letra no pertenece a la palabra 
		if(!pertenece)
		{
			return pertenece;
		}
		else{
			return pertenece;
		}
	}
	
	// Aca es donde se juega con todo en el ahorcado
	public String juego(Letra l, int tam)
	{
		_RESULTADO = new String();
		// Verifico que el tama�o sea solo de 1, es decir una letra!!!
		if(tam == 1)
		{
			if(!jugarLetra(l))
			{
				_RESULTADO = "Incorrecto!!!";
			}
			else{
				ArrayList<Letra> palabrita = new ArrayList<Letra>();
				palabrita = darOcurrencias(_JUGADAS);
				int cont=0;
				while(cont < palabrita.size())
				{
				    Letra letrin = (Letra)palabrita.get(cont);
				    char letra = letrin.getLetra();
				    _RESULTADO +=Character.toString(letra) + "  ";
				    cont++;
				}
			}
		}
		else{
			
			_RESULTADO = "Debe ingresar una letra de la A a la Z";
		} 
		
		return _RESULTADO;
	}
	
	public Palabra darPalabraActual()
	{
		return _ACTUAL;
	}
	
	public ArrayList<Letra> darJugadas()
	{
		return _JUGADAS;
	}
	
	public ArrayList<Letra> darOcurrencias(ArrayList<Letra> _JUGADAS)
	{
		return _ACTUAL.darOcurrencias(_JUGADAS);
	}
	
	public int darEstado( )
    {
        return estado;
    }
	
}
