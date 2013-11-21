package AhorcadoTDD;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DiccionarioServlet extends HttpServlet {
	
	Diccionario dic = new Diccionario();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String palabra = request.getParameter("palabra");
		
		if(dic.AniadirPalabra(palabra))
		{
			response.getWriter().println("palabra ingresada: ");
			response.getWriter().println(palabra);
		}
		else
		{
			response.getWriter().println("error");
		}
		
		
		
		
		
	}
}