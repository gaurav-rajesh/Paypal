package net.codejava;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.paypal.base.rest.PayPalRESTException;

@WebServlet("/authorize_payment")
public class Authorise extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Session session =hibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String product =request.getParameter("product");
		String subtotal =request.getParameter("subtotal");
		String shipping =request.getParameter("shipping");
		String tax =request.getParameter("tax");
		String total =request.getParameter("total");
		System.out.println(product);
		
		OrderDetail orderdetail=new OrderDetail(product,subtotal,shipping,tax,total);
		session.save(orderdetail);
		session.getTransaction().commit();
		session.close();
		
		try {
		PaymentServices paymentServices=new PaymentServices();
		String approvalLink=paymentServices.authorizePayment(orderdetail);
		response.sendRedirect(approvalLink);
		}
		catch(PayPalRESTException ex){
			ex.printStackTrace();
			request.setAttribute("errorMessage", ex.fillInStackTrace().getMessage());//we can write invalid payment after error message
			request.getRequestDispatcher("error1.jsp").forward(request, response);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
