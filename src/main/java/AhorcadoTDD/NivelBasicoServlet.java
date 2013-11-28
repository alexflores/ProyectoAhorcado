package AhorcadoTDD;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")

public class NivelBasicoServlet extends HttpServlet {
	Juego j = new Juego();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
	
		out.println("<html>");
		out.println("<body bgcolor=#33ff00>");	
		out.println("<h1>Informacion del nivel</h1><br>");
		out.println("<h2>Nivel : Basico</h2><br><br>");
		out.println("<h2>Nro de pistas : 6</h2><br><br>");
		out.println("<h2>Nro de errores: 6</h2><br><br>");
		out.println("<form action='juegoServlet'>");
		out.println("<input type='hidden' name='restart' value='resetear'><br>");
		out.println("<input type='submit' value='Jugar'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}

}
