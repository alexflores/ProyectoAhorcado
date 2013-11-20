package AhorcadoTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import AhorcadoTDD.Diccionario;

public class TestDiccionario {

	Diccionario diccionario;
	
	@Before
	public void initObjects()
	{
		diccionario = new Diccionario();
		diccionario.BorrarContenido();
	}
	
	@Test
	public void AniadirLetraAUnArchivoVacio()
	{
		assertEquals(true,diccionario.AniadirPalabra("papayon"));
	}
	
	@Test
	public void AniadirLetraAlFinalDeUnArchivo()
	{
		String palabra = "chuleta";
		diccionario.AniadirPalabra(palabra);
		assertEquals(palabra,diccionario.LeerUltimaPalabraDelDiccionario());
	}
	
	@Test
	public void DevuelveFalseSiLaPalabraAIngresarYaSeEncuentraEnElDiccionario()
	{
		String palabra = "macarron";
		diccionario.AniadirPalabra(palabra);
		assertEquals(false,diccionario.AniadirPalabra(palabra));
	}
	
	@Test
	public void DevuelveTrueSiLasLetrasDeUnFicheroSonBorradas()
	{
		diccionario.AniadirPalabra("palabra1");
		diccionario.AniadirPalabra("palabra2");
		assertEquals("palabra2",diccionario.LeerUltimaPalabraDelDiccionario());
		assertEquals(true, diccionario.BorrarContenido());
	}
	
	@Test
	public void DevuelveUnaPalabraAleatoriaObtenidaDelDiccionario()
	{
		diccionario.AniadirPalabra("paralelepipedo");
		diccionario.AniadirPalabra("sorpresa");
		diccionario.AniadirPalabra("chocolate");
		diccionario.AniadirPalabra("elicoptero");
		String palabra = "";
		palabra = diccionario.ObtenerPalabra();
		assertEquals(false, palabra.isEmpty());
		
	}
	
	@Test
	public void DevuelveUnMensajeSiLaPalabraIngresadaEsInvalida()
	{
		String palabra = "palabra invalida";
		assertEquals(false, diccionario.ValidarPalabra(palabra));
		
	}
}
