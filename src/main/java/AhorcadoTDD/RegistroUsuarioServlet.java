package AhorcadoTDD;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RegistroUsuarioServlet extends HttpServlet {
	
	Usuario user = new Usuario();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();
		
		String nombre = request.getParameter("nombre");
		String login = request.getParameter("login");
		String pass = request.getParameter("password");
		
		String mensaje = user.RegistrarUsuario(nombre, login, pass);
		
		out.println("<center><h1>"+mensaje+"</h1></center>");
		//out.println("<center><h1><a href=diccionario.html>Volver<a/></h1></center>");
		
		out.println("<center><h1><a href=index.html>Jugar<a/></h1></center>");
		
		out.close();
		
		
		
		
	}
}