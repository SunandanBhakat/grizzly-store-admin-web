package com.pack.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pack.model.Login;
import com.pack.model.Profile;
import com.pack.service.AdminServiceImpl;

/**
 * Servlet implementation class VerifyAdminController
 */
/*@WebServlet("/VerifyAdminController")*/
public class VerifyAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int attempts=0;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String username=request.getParameter("uname");
		String password=request.getParameter("pass");
		Login lo=new Login(username,password);
		AdminServiceImpl at=new AdminServiceImpl();
		Profile p=at.verifyAdmin(lo);
		if(p!=null)
		{
			attempts=0;
			HttpSession hs=request.getSession();
			hs.setAttribute("name", p.getName());
			hs.setAttribute("id",p.getId());
			hs.setAttribute("designation", p.getDesignation());
			hs.setAttribute("office", p.getOffice());
			RequestDispatcher rd=request.getRequestDispatcher("/ListProductsController");
			rd.forward(request, response);
		}
		else
		{
			++attempts;
            /*System.out.print(attempts);*/
            if(attempts>=3)
            { 
            		AdminServiceImpl at1=new AdminServiceImpl();
                  int i=at1.updateStatus(username);
                  pw.println("<script type=\"text/javascript\">");
                  pw.println("alert('User has been blocked');");
                  pw.println("location='/grizzly-store-admin-web/login.jsp';");
                   pw.println("</script>"); 
            }
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Invalid username or password');");
            pw.println("location='/grizzly-store-admin-web/login.jsp';");
            pw.println("</script>");
	
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
