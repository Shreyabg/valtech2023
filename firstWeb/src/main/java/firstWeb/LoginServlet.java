package firstWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
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
		response.getWriter().print("User Name= "+request.getParameter("name")+" Pass word = " +request.getParameter("pass"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(request, response);
		//super.doPost(request, response);
		
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		if("scott".equals(name)&& "tiger".equals(pass)) {
			request.setAttribute("message", "Hi scott ...how have u been");
		}
		else {
			request.setAttribute("message", "Only scott is a Valid User");
		}
		request.getRequestDispatcher("loginresults.jsp").forward(request, response);
		//this will take to loginresults.jsp
	}

}
