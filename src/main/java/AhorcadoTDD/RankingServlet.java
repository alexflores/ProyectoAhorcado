package AhorcadoTDD;
import java.io.IOException;
import java.io.PrintWriter;

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
		r.ObtenerUsuarios();
		out.println("	cargo palabra");
		int aux;
		for(aux=0;aux<r.ListaPalabras.size();a++)
			out.println(r.ListaPalabras.get(aux));
		out.println("`paso del for");
		out.println("</body>");
		out.println("</html>");
			
		}
	}
