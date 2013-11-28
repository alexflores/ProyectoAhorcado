package AhorcadoTDD;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class InfoJuegoServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();
		
		Juego game = new Juego();
		//Usuario user = new Usuario();
		Diccionario dictionary = new Diccionario();
		
		String nivelJuego = request.getParameter("categoria");
		Juego infoGame = game.ObtenerInformacionDeJuegoPorNivel(new Juego(nivelJuego));
		
		out.println("<center><h1>Juego Basico</h1></center>");

		out.println("<font size='10' >Caracteristicas del juego:</font><br><br>");
		out.println("<font size='5' color='green'>Nivel de dificultad: "+infoGame.nivelJuego+"</font><br>");
		out.println("<font size='5' color='green'>Cantidad de Pistas: "+infoGame.pistasEnJuego +"</font><br>");
		out.println("<font size='5' color='green'>Cantidad de Errores: "+infoGame.erroresEnJuego+"</font><br>");
		
		ArrayList<String> ListaCategorias = dictionary.ObtenerCategoriasEnDiccionario();
		
		out.println("<form method='post' action='juegoServlet.html'>");
		out.println("<label>Categoria:</label>");
		out.println("<select>");
		for(int i=0; i<ListaCategorias.size(); i++)
		{
			String categoria = ListaCategorias.get(i);
			out.println("<option value='"+categoria+"'>"+categoria+"</option>");
		}
		out.println("</select>");
		out.println("<input type='submit' value='Jugar'/>");
		out.println("</form>");
		out.println("<center><h4><a href=juego.html>Volver</a></h4></center>");
		out.close();
	}
}