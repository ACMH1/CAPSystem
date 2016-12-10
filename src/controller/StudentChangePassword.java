package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.MyDataException;
import model.AdminDTO;
import model.StudentDTO;
import service.ProfilePassword;
import utility.PasswordUtility;

/**
 * Servlet implementation class StudentChangePassword
 */
@WebServlet("/StudentChangePassword")
public class StudentChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doprocess(request,response);
		ProfilePassword pwd=new ProfilePassword();
		HttpSession session=request.getSession();
		
		String old=request.getParameter("oldpassword");
		String newp=request.getParameter("password");
		String newpass=PasswordUtility.base64encode(newp);
		String oldpass=PasswordUtility.base64encode(old);
		System.out.println("oldone-"+oldpass);
		System.out.println("newone-"+newpass);
		
		int id=(int) session.getAttribute("studentID");
		if(session.getAttribute("role")!=null&&session.getAttribute("role").equals("student"))
		{
		try {
			System.out.println("ulla came");
			StudentDTO plist=pwd.findstudpwd(id);	
			String dbpass=plist.getPassword();
			System.out.println("dbone-"+dbpass);
			if(oldpass.equals(dbpass))
			{
				boolean result = false;
				plist.setPassword(newpass);
				result=pwd.updatestudpwd(plist);
				if(result==true)
				{
					String s="successfully updated :)";
					request.setAttribute("message",s );
					RequestDispatcher rd = request.getRequestDispatcher("/student_login.jsp");
					rd.forward(request, response);
				}
				else{
					String f="oops!Something went wrong :(";
					request.setAttribute("message",f );
					RequestDispatcher rd = request.getRequestDispatcher("/changepassword.jsp");
					rd.forward(request, response);
				}
					
			}
			else{
				String f="your old password did not match :(";
				request.setAttribute("message",f );
				RequestDispatcher rd = request.getRequestDispatcher("/changepassword.jsp");
				rd.forward(request, response);	
				
			}
		} catch (MyDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else
		{
			RequestDispatcher dd = request.getRequestDispatcher("/student_login.jsp");
			dd.forward(request, response);
		}
	}

	private void doprocess(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
