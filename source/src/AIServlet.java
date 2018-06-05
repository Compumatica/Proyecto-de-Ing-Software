// Import required java libraries
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import prCompumatica.*;

@WebServlet("/ai")
public class AIServlet extends HttpServlet {
 
   public void init() throws ServletException {

   }

   public void doGet(HttpServletRequest request, HttpServletResponse response){
	   Usuario u = new Usuario(null, null, null);
	   u.setAlergenos();
	   Dieta d = AsistenteDieta.hacerSugerencia(u);
	   List<Plato> p = d.getPlatos();
	   
	   HttpSession session = request.getSession();
	   session.setAttribute("breakfast", p.get(2));
	   
	   String[] arr = {"lunch", "dinner", "breakfast", "snack"};
	   
	   for(int i = 0; i < 4; i++){
		   session.setAttribute(arr[i], p.get(i));
		   session.setAttribute(arr[i] + "_cal",   Math.round(p.get(i).getCalorias()*100)/100);
		   session.setAttribute(arr[i] + "_carbo", Math.round(p.get(i).getCarbohidratos()*100)/100);
		   session.setAttribute(arr[i] + "_prot",  Math.round(p.get(i).getProteinas()*100)/100);
		   session.setAttribute(arr[i] + "_gras",  Math.round(p.get(i).getGrasas()*100)/100);
	   }

	   try {
		   response.sendRedirect("suggest.jsp");
	   } catch (IOException e1) {
		   e1.printStackTrace();
	   }
	   
	 /*  
	   PrintWriter pw;
	   try {
		   pw = response.getWriter();
		   pw.println("<br> Desayuno:" + p.get(2).toString());
		   pw.println("<br> Almuerzo:" + p.get(0).toString());
		   pw.println("<br> Merienda:" + p.get(3).toString());
		   pw.println("<br> Cena:" + p.get(1).toString());
		   pw.close();
	   } catch (IOException e) {
		   e.printStackTrace();
	   }*/
   }
   
   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

   }

   public void destroy() {
      // do nothing.
   }
}