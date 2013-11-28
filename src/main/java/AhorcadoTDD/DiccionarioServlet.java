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
		java.io.PrintWriter out = response.getWriter();
		dic.palabraDiccionario = request.getParameter("palabra");
		dic.fraseDiccionario = request.getParameter("frase");
		dic.categoriaDiccionario = request.getParameter("categoria");
		if(dic.AniadirPalabra(dic)){
			out.println("<font size='6' color='green'>La Palabra: { "+dic.palabraDiccionario+" } fue ingresada Exitosamente</font><br><br>");
		}
		else{
			out.println("<font size='10' color='red'>error: la palabra no es valida o ya se ecuentra en el diccionario</font>");
		}
		ArrayList<String> List = dic.MostrarPalabrasEnDiccionario();
		out.println("<h3>Lista de Palabras: </h3><br>");
		for(int i=0; i<List.size(); i++)
		{
			out.println(List.get(i)+"<br>");
		}
		out.println("<center><h1><a href=index.html>Volver<a/></h1></center>");
		out.close();
		
	}
}