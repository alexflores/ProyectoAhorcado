package AhorcadoTDD;

public class PersonaPrueba {
	public int puntaje;
	public String nombre;
	public PersonaPrueba (String datos) {
		llenar(datos);
     
}
	public void llenar(String linea)
	{
		String[] campos = linea.split (" "); 
		this.puntaje=Integer.parseInt(campos[1]);
		this.nombre=campos[0];
	}
	public void mostrar()
	{
		System.out.print(nombre+" puntaje "+puntaje);
	}

}
