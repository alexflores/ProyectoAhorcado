package AhorcadoTDD;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Juego {
	public int puntaje=0;
    public static final int JUGANDO = 0;
    //Vector de letras jugadas por el jugador
	private ArrayList<Letra> _JUGADAS;
	
	private Palabra _ACTUAL;
	
	public static final int GANADOR = 1;

	public static final int AHORCADO = 2;
	
	public String _RESULTADO = "";
	
	public String _CABEZA = "";
	
	public String _BRAZO_IZQ = "";
	
	public String _CUERPO = "";
	
	public String _BRAZO_DER = "";
	
	public String _PIERNA_IZQ= "";
	
	public String _PIERNA_DER= "";
	
	public int cant_error = 0;
	
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
	
	public String mostrarCabeza(Letra l, int tam)
	{	
		if(!jugarLetra(l) && tam==1)
		{
			_CABEZA = "O";
		}
		
		return _CABEZA;
	}
	
	public String mostrarBrazoIzq(Letra l, int tam)
	{
		if(!jugarLetra(l) && tam==1)
		{
			_BRAZO_IZQ = "/";
		}

		return _BRAZO_IZQ;
	}
	
	public String mostrarCuerpo(Letra l, int tam)
	{
		if(!jugarLetra(l) && tam==1)
		{
			_CUERPO = "|";
		}

		return _CUERPO;
	}
	
	public String mostrarBrazoDer(Letra l, int tam)
	{
		if(!jugarLetra(l) && tam==1)
		{
			_BRAZO_DER = "\\";
		}

		return _BRAZO_DER;
	}
	
	public String mostrarPiernaIzq(Letra l, int tam)
	{
		if(!jugarLetra(l) && tam==1)
		{
			_PIERNA_IZQ = "/";
		}

		return _PIERNA_IZQ;
	}
	
	public String mostrarPiernaDer(Letra l, int tam)
	{
		if(!jugarLetra(l) && tam==1)
		{
			_PIERNA_DER = "\\";
		}

		return _PIERNA_DER;
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
	
	/*public int darEstado( )
    {
        return estado;
    }*/

}
