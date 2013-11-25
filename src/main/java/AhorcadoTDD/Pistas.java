package AhorcadoTDD;

public class Pistas {

	public int pistasDisponibles = 4;
	public int pistasPorNivel=pistasDisponibles;
	public int posicionDeLaPista;

	public int incrementarpista(int auxiliarpistas) {
		// TODO Auto-generated method stub
					return auxiliarpistas+1;
	}

	public char BuscarLetra(int a,String palabra) {
		char letra=' ';
		int cont=0;
		while(cont<palabra.length()){
			if(palabra.charAt(cont)==palabra.charAt(a))
				letra=palabra.charAt(a);
			cont++;
		}
		return letra;
		
	}

	public String mensajePistasMedio() {
		// TODO Auto-generated method stub
		String resp = "cantidad de pistas es de 4";
		return  resp;
	}
	public String mensajePistasAvanzado() {
		// TODO Auto-generated method stub
		String resp = "cantidad de pistas es de 2";
		return  resp;
	}
	public String mensajePistasBasico() {
		// TODO Auto-generated method stub
		String resp = "cantidad de pistas es de 6";
		return  resp;
	}

	public String NuevoArray(String palabraOculta, int posicionDeLaPista2,
			String palabra,char letra) {
		String resp=palabraOculta;

		if(BuscarLetraenPalabra(posicionDeLaPista2,palabra,letra)==true)
		{
			char[]auxiliar=resp.toCharArray();
			auxiliar[posicionDeLaPista2]=letra;
			resp= new String(auxiliar);
		}
		// TODO Auto-generated method stub
		return resp;
	}

	public Boolean BuscarLetraenPalabra(int posicionDeLaPista2, String palabra,
			char letra) {
		boolean resp=false;
		int cont=0;
		while(cont!=palabra.length())
		{
			if(palabra.charAt(cont)==palabra.charAt(posicionDeLaPista2))
				resp=true;
			cont++;
		}
			
		// TODO Auto-generated method stub
		return resp;
	}
	
	

}
