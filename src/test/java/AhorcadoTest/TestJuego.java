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

}
