package AhorcadoTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import AhorcadoTDD.Diccionario;
public class TestDiccionario {

	Diccionario diccionario;
	
	@Before
	public void setUp() throws Exception {
		diccionario = new Diccionario();
		diccionario.BorrarContenido();
	}

	@After
	public void tearDown() throws Exception {
		diccionario.BorrarContenido();
	}
	
	@Test
	public void AniadirLetraAUnArchivoVacio()
	{
		diccionario = new Diccionario("papayon", "");
		assertEquals(true,diccionario.AniadirPalabra(diccionario));
	}
	
	@Test
	public void AniadirLetraAlFinalDeUnArchivo()
	{
		String palabra = "chuleta";
		diccionario.AniadirPalabra(new Diccionario(palabra, ""));
		assertEquals(palabra,diccionario.LeerUltimaPalabraDelDiccionario());
	}
	
	@Test
	public void DevuelveFalseSiLaPalabraAIngresarYaSeEncuentraEnElDiccionario()
	{
		diccionario.AniadirPalabra(new Diccionario("macarron", ""));
		assertEquals(false,diccionario.AniadirPalabra(new Diccionario("macarron", "")));
	}
	
	@Test
	public void DevuelveTrueSiLasLetrasDeUnFicheroSonBorradas()
	{
		diccionario.AniadirPalabra(new Diccionario("palabra1", ""));
		diccionario.AniadirPalabra(new Diccionario("palabra2", ""));
		assertEquals("palabra2",diccionario.LeerUltimaPalabraDelDiccionario());
		assertEquals(true, diccionario.BorrarContenido());
	}
	
	@Test
	public void DevuelveUnaPalabraAleatoriaObtenidaDelDiccionario()
	{
		String palabra = "";
		diccionario.AniadirPalabra(new Diccionario("palabra1", ""));
		diccionario.AniadirPalabra(new Diccionario("sorpresa", ""));
		diccionario.AniadirPalabra(new Diccionario("chocolate", ""));
		diccionario.AniadirPalabra(new Diccionario("elicoptero", ""));
		palabra = diccionario.ObtenerPalabra();
		assertEquals(false, palabra.isEmpty());
	}
	
	@Test
	public void DevuelveUnMensajeSiLaPalabraIngresadaEsInvalida()
	{
		String palabra = "palabra invalida";
		assertEquals(false, diccionario.AniadirPalabra(new Diccionario(palabra, "")));
	}
	
	@Test
	public void AgregarFraseYPalabraYDevolverLaFraseDadaUnaPalabra()
	{
		String palabra = "casa";
		String frase = "Edificación construida para ser habitada.";
		diccionario.AniadirPalabra(new Diccionario(palabra, frase));
		assertTrue(frase.toLowerCase().equals(diccionario.ObtenerFraseDadaUnaPalabra(new Diccionario(palabra, frase))));
	}
	
}
