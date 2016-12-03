

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;

/**
 * Servlet implementation class SampleServlet
 */
@WebServlet("/s")
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SampleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        //
        //		HttpSession session=request.getSession();
        //		session.setAttribute("role", " ");
        //
        //		String path="sample_login.jsp";
        //		RequestDispatcher rd= request.getRequestDispatcher(path);
        //		rd.forward(request, response);
        
        HttpSession session=request.getSession();
        session.setAttribute("role", " ");
        
        String path="home.jsp";
        RequestDispatcher rd= request.getRequestDispatcher(path);
        rd.forward(request, response);
        
        
        //		HttpSession session=request.getSession();
        //		session.setAttribute("role", "lecturer");
        //
        //		String path="sample_lesturer.jsp";
        //		RequestDispatcher rd= request.getRequestDispatcher(path);
        //		rd.forward(request, response);
        //
        //		HttpSession session=request.getSession();
        //		session.setAttribute("role", "admin");
        //
        //		String path="sample_admin.jsp";
        //		RequestDispatcher rd= request.getRequestDispatcher(path);
        //		rd.forward(request, response);
        
        //		HttpSession session=request.getSession();
        //		session.setAttribute("role", "student");
        //		
        //		String path="sample_student.jsp";
        //		RequestDispatcher rd= request.getRequestDispatcher(path);
        //		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
