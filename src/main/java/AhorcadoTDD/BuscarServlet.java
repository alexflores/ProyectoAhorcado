package AhorcadoTDD;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
	@SuppressWarnings("serial")
	public class BuscarServlet extends HttpServlet {
		Ranking nuevo=new Ranking();
		String Player;
		public BuscarServlet() {
			nuevo.ObtenerUsuarios();
		}
		
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Player= request.getParameter("palabra");
		out.println("<html>");
		out.println("<body background='mifondo.jpg'");
		out.println("USUARIO    PUNTAJE ");
		out.println("<br/>");
		int aux;
		for(aux=0;aux<nuevo.ListaPalabras.size();aux++){
			if(Player==nuevo.sacarNombre(nuevo.ListaPalabras.get(aux))){
				out.println(nuevo.ListaPalabras.get(aux));
				out.println("<br/>");
			}
			}
		}
	}
