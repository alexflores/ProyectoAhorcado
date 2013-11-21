package AhorcadoTDD;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JuegoServlet extends HttpServlet {
	Juego j = new Juego();
	ArrayList _JUGADAS = new ArrayList();
	public JuegoServlet() {
		j.iniciarJuego("sistemas");

	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String letrita = request.getParameter("letra");
		PrintWriter out = response.getWriter();
		if(letrita == null)
		{
			letrita="acm";
		}
		char arr[] = letrita.toCharArray();
		int tam = arr.length;
		Letra l = new Letra(arr[0]);
		
		
		out.println("<html>");
		out.println("<body bgcolor=#33ff00>");
		
		out.println("<h1>");
		out.println("AHORCADO");
		out.println("</h1>");
	
			if(tam == 1)
			{
				if(!j.jugarLetra(l))
				{
					out.println("Incorrecto!!!");
				}
				else{
					ArrayList palabrita = new ArrayList();
					_JUGADAS.add(l);
					palabrita = j.darOcurrencias(_JUGADAS);
					
					int cont=0;
					while(cont < palabrita.size())
					{
					    Letra letrin = (Letra)palabrita.get(cont);
					    out.println(letrin.getLetra());
					    cont++;
					}
				}
			}
			else{
			    out.println("<br><br>");
				out.println("Debe ingresar una letra de la A a la Z");
			} 
		
		out.println("<br><br>");
		out.println("<form action='juegoServlet'>");
		out.println("Ingresar una letra: <input type='text' name='letra'><br>");
		out.println("<input type='submit' value='Ingresar'>");
		out.println("</form>");

		out.println("</body>");
		out.println("</html>");
		
	}
}
