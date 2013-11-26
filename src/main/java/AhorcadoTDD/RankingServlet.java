package AhorcadoTDD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
	@SuppressWarnings("serial")
	public class RankingServlet extends HttpServlet {
		Juego j = new Juego();
		Ranking r=new Ranking();
		int a=0;
		public RankingServlet() {
			

		}
		
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body bgcolor=#33ff00>");
		r.IngresarPuntaje("rudy",100);
		r.IngresarPuntaje("lucho",40);
		r.IngresarPuntaje("tenguentopa",70);
		r.IngresarPuntaje("nose",10);
		r.ObtenerUsuarios();
		out.println("USUARIO    PUNTAJE ");
		out.println("<br/>");
		int aux;
		for(aux=0;aux<r.ListaPalabras.size();aux++){
			out.println(r.ListaPalabras.get(aux));
			out.println("<br/>");
		}
		
		out.println("--------------------------");
		out.println("<br/>");
		out.println("Ordenado Decendente");
		out.println("<br/>");
		r.OrdenamientoBurbuja();
		for(a=0;a<r.ListaPalabras.size();a++){
			out.println(r.ListaPalabras.get(a));
			out.println("<br/>");
		}
		out.println("<br/>");
		out.println("Ordenado Acendente");
		out.println("<br/>");
		Collections.reverse(r.ListaPalabras);
		for(a=0;a<r.ListaPalabras.size();a++){
			out.println(r.ListaPalabras.get(a));
			out.println("<br/>");
		}
		out.println("<br/>");
		out.println("</body>");
		out.println("</html>");
			
		}
	}
