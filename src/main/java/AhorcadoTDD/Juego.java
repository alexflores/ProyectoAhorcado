package AhorcadoTDD;

import java.util.ArrayList;

public class Juego {
	public int puntaje=0;
	
	public String nivelJuego;
	public int pistasEnJuego;
	public int erroresEnJuego;
	
    public static final int JUGANDO = 0;
    //Vector de letras jugadas por el jugador
	private ArrayList<Letra> _JUGADAS;
	
	private Palabra _ACTUAL;
	
	public static final int GANADOR = 1;

	public static final int AHORCADO = 2;
	
	public String _RESULTADO = "";
	
	public String _CUERPITO = "";
	
	private static final String _NIVEL_BASICO = "Básico";
	private static final int _PISTAS_BASICO = 6;
	private static final int _ERRORES_POSIBLES_BASICO = 6;
	
	private static final String _NIVEL_INTERMEDIO = "Intermedio";
	private static final int _PISTAS_INTERMEDIO = 4;
	private static final int _ERRORES_POSIBLES_INTERMEDIO = 4;
	
	private static final String _NIVEL_AVANZADO = "Avanzado";
	private static final int _PISTAS_AVANZADO = 2;
	private static final int _ERRORES_POSIBLES_AVANZADO = 2;
	
	public Juego(){}
	
	public Juego(String nivel)
	{
		this.nivelJuego = nivel;
	}
	/*public String _BRAZO_IZQ = "";
	
	public String _CUERPO = "";
	
	public String _BRAZO_DER = "";
	
	public String _PIERNA_IZQ= "";
	
	public String _PIERNA_DER= "";*/
	
	public int cant_error = 1;
	
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
		// Verifico que el tamaño sea solo de 1, es decir una letra!!!
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
	
	public String mostrarMuñequito()
	{	
		//_CUERPITO = new String();
		switch(cant_error) {
            case 1:  _CUERPITO = "O\n";
                     break;
            case 2:  _CUERPITO = "/\n";
                     break;
            case 3:  _CUERPITO = "|\n";
                     break;
            case 4:  _CUERPITO = "\\\n";
                     break;
            case 5:  _CUERPITO = "/\n";
                     break;
            case 6:  _CUERPITO = "\\\n";
                     break;
            default: _CUERPITO = "AHORCADO!!!";
                     break;
        }
		cant_error++;
		return _CUERPITO;
	}
	
	
	/*public String mostrarBrazoIzq(Letra l, int tam)
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
	}*/
	
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
	
	public void reiniciarJuego()
	{
		_JUGADAS = new ArrayList<Letra>();
	}

	public Juego ObtenerInformacionDeJuegoPorNivel(Juego juego) {
		Juego infoGame = new Juego();
		if(juego.nivelJuego.equals(_NIVEL_BASICO)){
			infoGame.nivelJuego = _NIVEL_BASICO;
			infoGame.pistasEnJuego = _PISTAS_BASICO;
			infoGame.erroresEnJuego = _ERRORES_POSIBLES_BASICO;
		}
		else if(juego.nivelJuego.equals(_NIVEL_INTERMEDIO)){
			infoGame.nivelJuego = _NIVEL_INTERMEDIO;
			infoGame.pistasEnJuego = _PISTAS_INTERMEDIO;
			infoGame.erroresEnJuego = _ERRORES_POSIBLES_INTERMEDIO;
		}
		else{
			infoGame.nivelJuego = _NIVEL_AVANZADO;
			infoGame.pistasEnJuego = _PISTAS_AVANZADO;
			infoGame.erroresEnJuego = _ERRORES_POSIBLES_AVANZADO;
		}
		return infoGame;
	}
	
	/*public int darEstado( )
    {
        return estado;
    }*/

}
