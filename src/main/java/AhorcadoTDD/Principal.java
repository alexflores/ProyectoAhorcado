package AhorcadoTDD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {
	
	public static void Diccionario()
	{
		boolean resp = false;
		Diccionario dic = new Diccionario();
		
		BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
		String Palabra = "";
		
		System.out.print("Ingresa la palabra: ");
		
		try {
		   Palabra = lectura.readLine();
		   
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.print(e);
		}
		
		resp = dic.AniadirPalabra(Palabra);
		if(resp)
			System.out.print("La palabra "+ Palabra+" fue ingresado exitosamente");
		else
			System.out.print("La palabra {"+Palabra+"} ya existe en el diccionario y/o la palabra es invalida por que contiene un espacio");
			
	}
	
	public static void IniciarJuego()
	{
		Diccionario dic = new Diccionario();
		String palabra = dic.ObtenerPalabra();
		Palabra p = new Palabra();
		char ch = ' ';
		
		dic.AniadirPalabra("Avion");
		dic.AniadirPalabra("movilidad");
		
		System.out.println("Palabra a Adivinar: "+p.OcultarPalabra(palabra));
		System.out.println();
		System.out.print("Ingresa una Letra: ");
		// captura la palabra ingresa por teclado
		try {
		   ch = (char) System.in.read();	
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
	}

	public static void IngresarLetraAlex()
	{
		Bienvenida b = new Bienvenida();
		
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
		ArrayList jugadas = new ArrayList();
		//jugadas = j.getLetras();
		jugadas.add(new Letra(' '));
		//jugadas.add(new Letra('s'));
		ArrayList palabra = new ArrayList();
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
		j.iniciarJuego("Sistemas");
		boolean x,y,z;
		x=j.jugarLetra(new Letra('S'));
		y=j.jugarLetra(new Letra('k'));
		z=j.jugarLetra(new Letra('m'));
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		
	}
	
	public static void Bienvenida()
	{
		Bienvenida b = new Bienvenida();
		b.bienvenida();
	}
	
	public static void Menu()
	{
		int opcion = 0;
		Bienvenida();
		
		BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("1. Jugar: ");
		System.out.println("2. Agregar Palabra A Diccionario ");
		System.out.println("");
		System.out.println("Ingrese una Opcion: ");
		
		try 
		{
			opcion = Integer.parseInt(lectura.readLine());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		switch(opcion) {
		 case 1: 
			 //IngresarLetra();
		     break;
		 case 2: 
			 Diccionario(); 
		     break;
		 
		 default: 
			 System.out.println("Ingrese una Opcion valida ");
			 System.out.println();
			 Menu();
		     break;
		 }
	}
	
	public static void main(String[] args) {
		IngresarLetraAlex();
	
	}
 }
