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
	
	public JuegoServlet() {
		j.iniciarJuego("sistemas");

	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String letrita = request.getParameter("letra");
		if(letrita == null)
		{
			letrita="acm";
		}
		char arr[] = letrita.toCharArray();
		int tam = arr.length;
		Letra l = new Letra(arr[0]);
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body bgcolor=#33ff00>");
		
		out.println("<h1>");
		out.println("AHORCADO");
		out.println("</h1>");
	    
		out.println(j.juego(l, tam));
		
		out.println("<br><br>");
		out.println("<form action='juegoServlet'>");
		out.println("Ingresar una letra: <input type='text' name='letra'><br>");
		out.println("<input type='submit' value='Ingresar'>");
		out.println("</form>");

		out.println("</body>");
		out.println("</html>");
		
	}
}
