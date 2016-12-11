package controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.MyDataException;
import model.LecturerDTO;
import service.ProfilePassword;
import utility.EmailUtility;
import utility.PasswordUtility;

/**
 * Servlet implementation class LecturerForgotPassword
 */
@WebServlet("/LecturerForgotPassword")
public class LecturerForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String host;
	private String port;
	private String user;
	private String pass;
	private String content;
	
	
	public void init() {
		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LecturerForgotPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		// TODO Auto-generated method stub
		System.out.println("hellooooooooooooooo");
	
		
		ProfilePassword pwd=new ProfilePassword();
		String studentPassword = PasswordUtility.randomString();
		System.out.println(studentPassword);
		
		System.out.println(request.getParameter("lecid"));
		int lecid=Integer.parseInt(request.getParameter("lecid"));
		String email=request.getParameter("email");
		System.out.println(email);
		String dummy="team6caps@gmail.com";
		
		try {
			LecturerDTO plist=pwd.findpwd(lecid);
			String dbemail=plist.getEmail();
			int dblecid=plist.getLecturerID();
			plist.setPassword(PasswordUtility.base64encode(studentPassword));
			System.out.println("old lec"+dblecid);
			if(lecid==dblecid&&email.equals(dbemail))
			{
				boolean result = false;
				result=pwd.updatepwd(plist);
				if(result==true)
				{
					
			try {
				content = "Dear  " + plist.getLastName()
				+ ",\r\n you have requested to reset your password. \r\n Please login your account with following password-"
				+ studentPassword + ".\r\n \r\n \r\n Best Regards,\r\n Admin Team";
				EmailUtility.sendEmail(host, port, user, pass, dummy,
						"Student Account Registration ", content);
				String s="Please login with your new password";
				request.setAttribute("message",s );
		
				RequestDispatcher rd = request.getRequestDispatcher("/lecturer_login.jsp");
				rd.forward(request, response);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
					
					
				}
				else{
					String f="oops!Something went wrong";
					request.setAttribute("message",f );
					RequestDispatcher rd = request.getRequestDispatcher("/ForgotPassword.jsp");
					rd.forward(request, response);
					
				}
				
			}
			else{
				String f="your EmailID does not match with your LecturerID ";
				request.setAttribute("message",f );
				RequestDispatcher rd = request.getRequestDispatcher("/ForgotPassword.jsp");
				rd.forward(request, response);	
			}
		} catch (MyDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
