package AhorcadoTDD;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DiccionarioServlet extends HttpServlet {
	
	Diccionario dic = new Diccionario();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String palabra = request.getParameter("palabra");
		String frase = request.getParameter("frase");
		if(dic.AniadirPalabra(palabra,frase))
		{
			response.getWriter().println("<font size='6' color='green'>La Palabra: { "+palabra+" } fue ingresada Exitosamente</font>");
			response.getWriter().println("<br><br>");
			response.getWriter().println("<h3>Lista de Palabras: </h3>");
			response.getWriter().println("<br>");
		}
		else
		{
			response.getWriter().println("<font size='10' color='red'>error: la palabra no es valida o ya se ecuentra en el diccionario</font>");
		}
		ArrayList<String> List = dic.MostrarPalabrasEnDiccionario();
		for(int i=0; i<List.size(); i++)
		{
			response.getWriter().println("<h5>"+List.get(i)+",</h5>");
			response.getWriter().println();
		}
		
		java.io.PrintWriter out = response.getWriter();
		//output your page here
		out.println("<center><h1><a href=diccionario.html>Volver<a/></h1></center>");
		
		out.close();
		
	}
}