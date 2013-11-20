package AhorcadoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import AhorcadoTDD.Bienvenida;

public class TestBienvenida {

	@Test
	public void devuelveTrueSiTeclaPresionadaEsIgualAEnter() {
		char tecla=13;
		Bienvenida b = new Bienvenida();
		assertEquals(true,b.esEnter(tecla));
	}

}
