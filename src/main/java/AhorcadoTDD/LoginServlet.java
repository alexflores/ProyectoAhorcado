package AhorcadoTDD;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	
	Usuario user = new Usuario();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();
		
		String login = request.getParameter("login");
		String pass = request.getParameter("password");
		user.UsuarioLogin = login;
		user.UsuarioPassword = pass;
		String mensaje = user.IniciarSesion(user);
		
		out.println("<center><h1>"+mensaje+"</h1></center>");
		out.println("<br><center><h1><a href=diccionario.html>Jugar<a/></h1></center>");
		
		out.close();
		
	}
}