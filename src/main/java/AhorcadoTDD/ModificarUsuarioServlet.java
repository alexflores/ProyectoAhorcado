package AhorcadoTDD;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ModificarUsuarioServlet extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();
		Usuario user = new Usuario();
		user.UsuarioLogin = request.getParameter("login");
		user.UsuarioPassword = request.getParameter("password");
		Usuario antiguoUsuario = user.ObtenerUsuarioPorLoginYPassword(user);
		
		ArrayList<String> lista = new ArrayList<String>();
		lista = user.ObtenerListaDeUsuarios();

		out.println("<form action='guardarDatosUsuarioServlet' method='post'>");
		out.println("Nombre: <input type='text' name='nuevoNombre' value='"+antiguoUsuario.UsuarioNombre+"'><br><br>");
		out.println("Login: <input type='text' name='nuevoLogin' value='"+antiguoUsuario.UsuarioLogin+"'><br><br>");
		out.println("Password: <input type='password' name='nuevoPass' value='"+antiguoUsuario.UsuarioPassword+"'><br><br>");
		out.println("<input type='hidden' name='idUsuario' value="+antiguoUsuario.UsuarioId+">");
		out.println("<input type='submit' value='Guardar Cambios'>");
		out.println("</form>");
		
		out.println("<center><h1><a href=modificarUsuario.html>Volver<a/></h1></center>");
		
		for(int i=0; i<lista.size();i++)
		{
			out.println(lista.get(i)+"<br>");
		}
		
		out.close();
		
	}
}