import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;



/**
* Servlet implementation class LoginServlet
*/
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
    /**
* @see HttpServlet#HttpServlet()
*/
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
             
        	response.setContentType("text/html");
        	PrintWriter out = response.getWriter();
        	out.println("<form action='' method='POST'>");
        	out.println("<label>Enter Username: <input type='text' name='userid'></input></label>");
        	out.println("<label>Enter Password: <input type='text' name='password'></input></label>");
        	out.println("<input type='submit'></input>");
        	out.println("</form>");
        	
            String userId = request.getParameter("userid");
            HttpSession session=request.getSession();  
            session.setAttribute("userid",  userId);
                 
            //response.sendRedirect("dashboard");               
        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String userId = request.getParameter("userid");
                String pass = request.getParameter("password");
                if(userId != null && pass.equals("password")) {
                	System.out.println("Login accepted for user: " + userId);
                	response.sendRedirect("dashboard?userid=" + userId);
                }
                doGet(request, response);
        }

}
