package AhorcadoTDD;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class PistaServlet extends HttpServlet {
	
	Diccionario dic = new Diccionario();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body background='mifondo.jpg'>");	
		String palabra = request.getParameter("palabraPista");
		String categoria = request.getParameter("categoriaSeleccionada");
		String pista = dic.ObtenerFraseDadaUnaPalabra(new Diccionario(palabra,"",""));
		if(palabra!= "")
		{
			response.getWriter().println("<font size='6' color='green'>Pista: { "+pista+" } </font>");
			response.getWriter().println("<br><br>");
		}
		
		
		out.println("<form action='juegoServlet' method='post'>");
		out.println("<input type='hidden' name='categoriaSeleccionada' value='"+categoria+"'><br>");
		out.println("<input type='submit' value='Volver'>");
		out.println("</form>");
		
		//out.println("<center><h1><a href=juegoServlet>Volver<a/></h1></center>");
		
		out.close();
		
	}
}