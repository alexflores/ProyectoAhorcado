package AhorcadoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import AhorcadoTDD.Letra;
import AhorcadoTDD.Palabra;

public class TestPalabra {
	
	@Test
	public void devuelveTrueSiLaLetraSeEncuentraEnElVector() {
		Palabra p = new Palabra("Ingenieria");
		Letra l = new Letra('i');
		assertEquals(true,p.estaLetra(l));
	}
	
	@Test
	public void DevuelveLaMismaLongitudDeLaPalabraMostradaConEspacio()
	{
		String palabra = "arbol";
		String esperado = "_ _ _ _ _";
		Palabra p = new Palabra();
		assertTrue(esperado.equals(p.OcultarPalabra(palabra)));
	}
	
	@Test
	public void DadaUnaLetraMuestraLaLetraEnLaPalabraSiEstaEstaEnElla()
	{
		Palabra p = new Palabra();
		String palabra = "arbol";
		String palabraOculta = "_ _ _ _ _";
		char c = 'r';
		String valorEsperado = "_ r _ _ _";
		assertTrue(valorEsperado.equals(p.MostrarLetraEnPalabra(palabra, palabraOculta, c)));
	}
	
	@Test
	public void DadaUnaLetraQueNoEstaEnLaPalabraMuestraLaPalabraComoTal()
	{
		Palabra p = new Palabra();
		String palabra2 = "casa";
		String palabraOculta = "_ _ _ _";
		char c2 = 'x';
		assertTrue(palabraOculta.equals(p.MostrarLetraEnPalabra(palabra2, palabraOculta, c2)));
	}

}
