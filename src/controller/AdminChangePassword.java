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
import model.LecturerDTO;
import service.ProfilePassword;
import utility.PasswordUtility;

/**
 * Servlet implementation class AdminChangePassword
 */
@WebServlet("/AdminChangePassword")
public class AdminChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChangePassword() {
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
		
		int id=(int) session.getAttribute("adminID");
		if(session.getAttribute("role")!=null&&session.getAttribute("role").equals("admin"))
		{
		try {
			System.out.println("ulla came");
			AdminDTO plist=pwd.findadminpwd(id);	
			String dbpass=plist.getPassword();
			if(oldpass.equals(dbpass))
			{
				boolean result = false;
				plist.setPassword(newpass);
				result=pwd.updateadminpwd(plist);
				if(result==true)
				{
					String s="successfully updated :)";
					request.setAttribute("message",s );
					RequestDispatcher rd = request.getRequestDispatcher("/admin_login.jsp");
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
			RequestDispatcher dd = request.getRequestDispatcher("/admin_login.jsp");
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
