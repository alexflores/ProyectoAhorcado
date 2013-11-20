package AhorcadoTDD;

public class Letra {
	
	private char _LETRA;
	
	public Letra(char miLetra)
	{
		_LETRA = miLetra;
	}
	
	public char getLetra()
	{
		return _LETRA;
	}
	
	public boolean esIgual(Letra otraLetra)
	{
		boolean igual = false;
		//Compara si la letra es igual a la letra dada
		if(otraLetra.getLetra() == _LETRA)
		{
			igual = true;
		}
		//Si la letra es minuscula compara si la mayuscula correspondiente es igual a la letra dada
		else if( _LETRA >= 97 && _LETRA - 32 == otraLetra.getLetra())
		{
			igual = true;
		}
		// La letra es mayuscula y verifica si la minuscula correspondiente es igual a la letra dada
		else if(_LETRA + 32 == otraLetra.getLetra())
		{
			igual = true;
		}
		return igual;
	}

}
