package assignment2;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HandleFormInput
 */
@WebServlet("/HandleFormInput")
public class HandleFormInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init (ServletConfig config) throws ServletException
    {
       super.init(config);
       System.out.println("hello from init method");
    }
	
	@Override
	public void destroy ()
    {
       super.destroy();
       System.out.println("hello from destroy method");
    }
	

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleFormInput() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
			request.setAttribute("firstname", firstname);
			request.setAttribute("lastname", lastname);
		
		if(request.getParameter("firstname") != "" && request.getParameter("lastname") != "") {
			request.getRequestDispatcher("ResponsePage.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("TestError.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
