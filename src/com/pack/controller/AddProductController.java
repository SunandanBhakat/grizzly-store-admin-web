package com.pack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.PrimitiveIterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pack.model.Product;
import com.pack.service.AdminServiceImpl;

/**
 * Servlet implementation class AddProductController
 */
//@WebServlet("/AddProductController")
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		if(request.getParameter("ipid")!="")
		{
			//String pid=request.getParameter("ipid");
			String pname=request.getParameter("ipname");
			String pbrand=request.getParameter("ipbrand");
			String pcategory=request.getParameter("optradio");
			String pdescription=request.getParameter("ipdescription");
			float pprice=Float.parseFloat(request.getParameter("ipprice"));
			AdminServiceImpl s=new AdminServiceImpl();
			Product p=new Product(pname,pbrand,pcategory,pdescription,pprice);
			int i=s.addProduct(p);
			if(i==1){
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Record Is Added Successfully');");
				pw.println("location='/grizzly-store-admin-web/ListProductsController';");
				pw.println("</script>");
			}
			else{
				response.sendRedirect("/grizzly-store-admin-web/ListProductsController");
			}
		}
		else
		{
			response.sendRedirect("/grizzly-store-admin-web/ListProductsController");
		}
	}
}
