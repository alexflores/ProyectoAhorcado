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
		Ranking auxi=new Ranking();
		int a=0;
		
		public RankingServlet() {
			r.IngresarPuntaje("rudy", 5);
			r.IngresarPuntaje("luis", 4);
			r.ObtenerUsuarios();
			auxi.ObtenerUsuarios();

		}
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body background='mifondo.jpg'>");
		
		
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
		auxi.OrdenamientoBurbuja();
		for(a=0;a<auxi.ListaPalabras.size();a++){
			out.println(auxi.ListaPalabras.get(a));
			out.println("<br/>");
		}
		out.println("<br/>");
		out.println("Ordenado Acendente");
		out.println("<br/>");
		for(a=auxi.ListaPalabras.size()-1;a>=0;a--){
			out.println(auxi.ListaPalabras.get(a));
			out.println("<br/>");
		}
		out.println("<br/>");
		out.println("</body>");
		out.println("</html>");
		
			
		}
	}
