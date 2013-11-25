package AhorcadoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import AhorcadoTDD.Ranking;

public class RankingTest {
	Ranking nuevo;
	/*@Test
	public void convertirastring()
	{
		int entero=15;
		String nombre="trancapecho";
		assertEquals("trancapecho%15",nuevo.nuevostring(nombre, entero));
	}*/
	@Test
	public void puntaje()
	{
		int fallas=2;
		assertEquals(50,nuevo.puntajetotal(fallas));
	}
	@Test
	public void test() {
		assertEquals(1,1);
	}
}
