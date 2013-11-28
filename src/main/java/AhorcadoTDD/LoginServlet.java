package AhorcadoTDD;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body background='mifondo.jpg'>");
		Usuario user = new Usuario();
		
		String login = request.getParameter("login");
		String pass = request.getParameter("password");
		user.UsuarioLogin = login;
		user.UsuarioPassword = pass;
		String mensaje = user.IniciarSesion(user);
		
		if(mensaje.equals("Error: Login Incorrecto")||mensaje.equals("Error: Password Incorrecto"))
		{
			out.println("<center><h1>"+mensaje+"</h1></center>");
			out.println("<center><h1><a href=login.html>Volver<a/></h1></center>");
		}
		else
		{
			out.println("<center><h1>"+mensaje+"</h1></center>");
			out.println("<center><h1><a href=juego.html>Jugar<a/></h1></center>");

			out.println("<center><form method='post' action=''>");
			out.println("<input type='hidden' name='login' value='"+login+"'>");
			out.println("<input type='hidden' name='password' value='"+pass+"'>");
			out.println("<input type='submit' value='Puntuaciones'>");
			out.println("</form></center>");
			
			out.println("<center><form method='post' action='modificarUsuarioServlet'>");
			out.println("<input type='hidden' name='login' value='"+login+"'>");
			out.println("<input type='hidden' name='password' value='"+pass+"'>");
			out.println("<input type='submit' value='Editar Perfil'>");
			out.println("</form></center>");
		}
		
		//out.println("<center><h1>"+mensaje+"</h1></center>");
		out.println("<br><center><h1><a href=index.html>Salir<a/></h1></center>");
		
		out.close();
		
	}
}