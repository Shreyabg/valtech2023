package assignLogin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyLoginServlet
 */
public class MyLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().print("User Name= "+request.getParameter("name")+" Pass word = " +request.getParameter("pass"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		 if(name.length()<4 && pass.length()<8) {
			request.setAttribute("message", "please enter correct name and password");
			//request.setAttribute("Incorrectpass", "please enter correct name and password");
			request.getRequestDispatcher("mylogin.jsp").forward(request, response);
			
		}
		
		 else if(name.length()<4) {
			request.setAttribute("message", "name should be more than 4 characters");
			request.getRequestDispatcher("mylogin.jsp").forward(request, response);
			//request.setAttribute("message", "Hi scott ...how have u been");
		}
		else if(pass.length()<8) {
			request.setAttribute("Incorrectpass", "password should be more than 8 characters");
		 request.getRequestDispatcher("mylogin.jsp").forward(request, response);
		}
		
		else{
		request.setAttribute("Success", "Login is successful");
	 request.getRequestDispatcher("myloginresults.jsp").forward(request, response);
	}
	    
		
	}
	}


