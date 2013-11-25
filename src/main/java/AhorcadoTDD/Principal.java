package AhorcadoTDD;

import java.io.IOException;
import java.util.ArrayList;

public class Principal {
	
	public static void main(String[] args)
	{
		/*Bienvenida b = new Bienvenida();
		b.bienvenida();
		boolean r;
		char ch;
		
		System.out.print("Enter a character: ");
		// captura la palabra ingresa por teclado
		try {
		   ch = (char) System.in.read();	
		   r=b.esEnter(ch);
		   System.out.print(r);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.print("Ingresaste al catch ");
		}
		
		boolean r1;
		
		Letra l1 = new Letra('a');
		Letra l2 = new Letra('B');
		
		r1 = l1.esIgual(l2);
		System.out.println(r1);
		
		boolean r2;
		Palabra p = new Palabra("sis");
		r2 = p.estaLetra(l1);
		System.out.println(r2);
		
		//Palabra j = new Palabra("s");
		ArrayList<Letra> jugadas = new ArrayList<Letra>();
		//jugadas = j.getLetras();
		jugadas.add(new Letra(' '));
		//jugadas.add(new Letra('s'));
		ArrayList<Letra> palabra = new ArrayList<Letra>();
		palabra = p.darOcurrencias(jugadas);
		//System.out.println(palabra);
		int cont=0;
		while(cont < palabra.size())
		{
		    Letra l = (Letra)palabra.get(cont);
		    System.out.println(l.getLetra());
		    cont++;
		}
		
		Juego j = new Juego();
		j.iniciarJuego("hola");
		Letra l3 = new Letra('A');
		String res;
		/*boolean x,y,z;
		x=j.jugarLetra(new Letra('S'));
		y=j.jugarLetra(new Letra('k'));
		z=j.jugarLetra(new Letra('m'));
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);*/
		/*res = j.juego(l3, 1);
		System.out.println(res);*/
<<<<<<< HEAD
		ArrayList<String> lista;
		Ranking nuevo=new Ranking();
		lista=nuevo.ObtenerUsuarios();
		System.out.println(lista);
=======
		Ranking nuevo= new Ranking();
		ArrayList<String> resultado=nuevo.ObtenerPalabra();
		for(int a=0;a<resultado.size();a++){
			System.out.print(resultado.get(a));
		}
>>>>>>> be9f28b24b919fc9f790bf55b77b197e12529842
	}
	
 }
