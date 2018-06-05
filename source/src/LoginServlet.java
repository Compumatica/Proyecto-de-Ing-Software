// Import required java libraries
import java.io.*;
import java.util.Enumeration;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import prCompumatica.BaseDeDatos;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
 
   public void init() throws ServletException {

   }

   public void doGet(HttpServletRequest request, HttpServletResponse response){
	   String username = (String) request.getParameter("username");
	   String password = (String) request.getParameter("password");
	   
	   System.out.println("username:<" + username + ">");
	   System.out.println("password:<" + password + ">");
   }
   
   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
   
	   String username = (String) request.getParameter("username");
	   String password = (String) request.getParameter("password");

	   synchronized(this){
		   try {
			wait(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	   }
	   	   
	   HttpSession session = request.getSession();
	   session.setAttribute("username", username);
	   response.sendRedirect("user.jsp");
	   
	   // DEMO
	   /*BaseDeDatos bd = new BaseDeDatos();
	   if(bd.verificarCredenciales(username, password, false)){
		   while(response.isCommitted());
		   response.sendRedirect("home.jsp");
	   } else{
		   System.out.println("CREDENCIALES INCORRECTAS");
		   // fail
	   }*/
   }

   public void destroy() {
      // do nothing.
   }
}