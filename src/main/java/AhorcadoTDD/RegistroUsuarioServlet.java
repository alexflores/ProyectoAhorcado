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
		
		user.UsuarioNombre = request.getParameter("nombre");
		user.UsuarioLogin = request.getParameter("login");
		user.UsuarioPassword = request.getParameter("password");
		
		String mensaje = user.RegistrarUsuario(user);
		out.println("<center><h1>"+mensaje+"</h1></center>");
		
		if(mensaje.equals(Usuario.getRegistroExitoso())){
			out.println("<center><form method='post' action='loginServlet'>");
			out.println("<input type='hidden' name='login' value='"+user.UsuarioLogin+"'>");
			out.println("<input type='hidden' name='password' value='"+user.UsuarioPassword+"'>");
			out.println("<input type='submit' value='Jugar'>");
			out.println("</form></center>");
		}
		else{
			out.println("<center><h1><a href=registroUsuario.html>Volver<a/></h1></center>");
		}
		out.close();
	}
}