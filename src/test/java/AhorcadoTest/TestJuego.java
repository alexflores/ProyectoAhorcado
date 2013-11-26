package AhorcadoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import AhorcadoTDD.Juego;
import AhorcadoTDD.Letra;

public class TestJuego {

	@Test
	public void devuelveTrueSiLaLetraJugadaPerteneceALaPalabra() {
		Juego j = new Juego();
		Letra l = new Letra('s');
		j.iniciarJuego("sistemas");
		assertEquals(true,j.jugarLetra(l));
	}
	
	@Test
	public void devuelveMensajeDeIngresarDeLaAalaZEnCasoDeSerTamMayorAUno()
	{
		Juego j = new Juego();
		String pal = "sistemas";
		char arr[] = pal.toCharArray();
		int tam = arr.length;
		Letra l = new Letra(arr[0]);
		assertEquals("Debe ingresar una letra de la A a la Z",j.juego(l, tam));
	}

}
