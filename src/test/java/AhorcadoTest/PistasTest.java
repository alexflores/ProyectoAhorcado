package AhorcadoTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import AhorcadoTDD.Pistas;

public class PistasTest {
	Pistas nuevo=new Pistas();
	@Test
	public void mostrarpistaIncrementada()
	{
		
		int auxiliarpistas=6;
		String mensaje="Cantidad de pistas diponibles:"+7;
		assertEquals(mensaje,"Cantidad de pistas diponibles:"+nuevo.incrementarpista(auxiliarpistas));
	}
	@Test
	public void mostrarDescripcionlvl1()
	{
		String mensaje="En este nivel tienes"+nuevo.pistasPorNivel+" fallos o pistas ="+nuevo.pistasPorNivel+"cada ves que uses una pista se descontara un fallo";
		System.out.print(mensaje);
		assertEquals(mensaje,"En este nivel tienes4 fallos o pistas =4cada ves que uses una pista se descontara un fallo");
	}
	@Test
	public void mostrarCantidadPistasAvanzado(){
		String mensaje="cantidad de pistas es de 2";
		assertEquals(mensaje,nuevo.mensajePistasAvanzado());
	}
	@Test// pistas disponibles tienen que estar en la clase juego cuando creemos un nivel deberiamos crear un juego con los parametros
	public void CantidaPistasBasico() {
		String mensaje="cantidad de pistas es de 6";
		assertEquals(mensaje,nuevo.mensajePistasBasico());
	}
	@Test
	public void CantidadPistasMedio() {
	
		String mensaje="cantidad de pistas es de 4";
		assertEquals(mensaje,nuevo.mensajePistasMedio());
	}
	@Test
	public void CantidadPistasAvanzado() {
		nuevo.pistasPorNivel=2;
		assertEquals(2,nuevo.pistasPorNivel);
	}
	@Test
	public void revisarSiLetraEstaEnPalabra()
	{
		int posicionDeLaPista=3;
		String palabra="hola";
		assertEquals('a',nuevo.BuscarLetra(posicionDeLaPista,palabra));
	}
	@Test
	public void MostrarPista()
	{
		String palabraOculta="????";
		String Palabra="hola";
		int posicionDeLaPista=2;
		assertEquals("??l?",nuevo.NuevoArray(palabraOculta,posicionDeLaPista,Palabra,'l'));
	}
	@Test
	public void revisarLetra()
	{
		char letra='o';
		int posicionDeLaPista=1;
		String palabra="hola";
		assertEquals(true,nuevo.BuscarLetraenPalabra(posicionDeLaPista,palabra,letra));
	}

}
