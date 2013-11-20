package AhorcadoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import AhorcadoTDD.Letra;

public class TestLetra {

	@Test
	public void devuelveTrueSiLaLetraDadaEsIgualALaLetra() {
		Letra letraDada = new Letra('A');
		Letra Letra = new Letra('A');
		assertEquals(true,Letra.esIgual(letraDada));
	}
	
	@Test
	public void devuelveTrueSiLaLetraDadaMayusculaEsIgualALetraMinuscula()
	{
		Letra letraDada = new Letra('A');
		Letra Letra = new Letra('a');
		assertEquals(true,Letra.esIgual(letraDada));
	}
	
	@Test
	public void devuelveTrueSiLaLetraDadaMinusculaEsIgualALetraMayuscula()
	{
		Letra letraDada = new Letra('a');
		Letra Letra = new Letra('A');
		assertEquals(true,Letra.esIgual(letraDada));
	}

}
