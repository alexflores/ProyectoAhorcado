package AhorcadoTDD;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class JuegoServlet extends HttpServlet {
	Juego j = new Juego();
	Diccionario dic = new Diccionario();
	public String pal = "";
	
	public JuegoServlet() {
		//pal = dic.ObtenerPalabraDadaUnaCategoria(new Diccionario("","","informática"));
		//j.iniciarJuego(pal);
		
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		String categoria = request.getParameter("categoriaSeleccionada");
		pal = dic.ObtenerPalabraDadaUnaCategoria(new Diccionario("","",categoria));
		j.iniciarJuego(pal);
		
		String palabraFraseYCategoriaObtenida = "Palabra: { "+pal+" }, Frase: {"+dic.ObtenerFraseDadaUnaPalabra(new Diccionario(pal,"", ""))+" }";

		String resetear = new String();
		resetear="restart";

		String letrita = request.getParameter("letra");
		resetear = request.getParameter("resetear");
		
		if(resetear == null && letrita == null)
		{
		    j.reiniciarJuego();
		}
		
		if(letrita == null)
		{
			letrita="123";
			
		}
		char arr[] = letrita.toCharArray();
		int tam = arr.length;
		Letra l = new Letra(arr[0]);
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body background='mifondo.jpg'>");	    	
		out.println("<h1>");
		out.println("AHORCADO NIVEL BASICO<br>");
		out.println("</h1>");
		
		out.println("<h1>");
        if(!j.jugarLetra(l) && tam==1)
        {
        	out.println(j.mostrarMuniequito());
        	out.println("<br>");
        }
		out.println("</h1>");
		
		out.println(j.juego(l, tam));
		
		out.println(palabraFraseYCategoriaObtenida);
		out.println("<br><br>");
		out.println("<form action='juegoServlet'>");
		out.println("Ingresar una letra: <input type='text' name='letra'><br>");
		out.println("<input type='submit' value='Ingresar'>");
		out.println("</form>");


		out.println("<form action='pistaServlet' method='post'>");
		out.println("<input type='hidden' name='palabraPista' value='"+pal+"'><br>");
		out.println("<input type='hidden' name='categoriaSeleccionada' value='"+categoria+"'><br>");
		out.println("<input type='submit' value='Pedir Pista Frase'>");
		out.println("</form>");
		
		out.println("<form action='nivelBasicoServlet'>");
		out.println("<input type='submit' value='Cancelar el juego'>");
		out.println("</form>");

		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}
}
