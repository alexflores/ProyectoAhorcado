package AhorcadoTDD;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class GuardarDatosUsuarioServlet extends HttpServlet {
	
	Usuario user = new Usuario();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();
		user.UsuarioId = Integer.parseInt(request.getParameter("idUsuario"));
		user.UsuarioNombre = request.getParameter("nuevoNombre");
		user.UsuarioLogin = request.getParameter("nuevoLogin'value");
		user.UsuarioPassword = request.getParameter("nuevoPass");
		
		String mensaje = user.ModificarUsuario(user);
		
		out.println("<h1 ALIGN='CENTER'>"+mensaje+"</h1>");
		
		out.println("<style type='text/css'> #inputSinBorde{ border-width:0; } </style>");
		
		out.println("<form method='post' action='index.html'>");
		out.println("<table border='0'>");
		out.println("<tr><td>Nombre:</td> <td><label>"+user.UsuarioNombre+"</label></td></tr>");
		out.println("<tr><td>Login:</td> <td><label>"+user.UsuarioLogin+"</label></td></tr>");
		out.println("<tr><td>Password:</td> <td><input type='password' id='inputSinBorde' value="+user.UsuarioPassword+"/></td></tr>");
		out.println("<tr><td><input type='submit' value='Aceptar'/></td></tr>");
		out.println("</table>");
		out.println("</form>");
		
	}
}