package AhorcadoTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import AhorcadoTDD.Juego;
import AhorcadoTDD.Letra;

public class TestJuego {
	private Juego j;
	
	@Before
	public void setup() {
		j = new Juego();
		j.iniciarJuego("sistemas");
	}

	@Test
	public void devuelveTrueSiLaLetraJugadaPerteneceALaPalabra() {

		Letra l = new Letra('s');
		assertEquals(true,j.jugarLetra(l));
	}
	
	@Test
	public void devuelveMensajeDeIngresarDeLaAalaZEnCasoDeSerTamMayorAUno()
	{

		String pal = "sistemas";
		char arr[] = pal.toCharArray();
		int tam = arr.length;
		Letra l = new Letra(arr[0]);
		assertEquals("Debe ingresar una letra de la A a la Z",j.juego(l, tam));
	}
	
	@Test
	public void devuelveIncorrectoSiLaLetraJugadaNoPerteneceALaPalabra()
	{
		Letra l = new Letra('k');
		assertEquals("Incorrecto!!!",j.juego(l, 1));
	}

}
