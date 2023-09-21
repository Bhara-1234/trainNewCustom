package Tickets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String from=request.getParameter("from");
		String to=request.getParameter("to");
		String train=request.getParameter("train");
		String clas=request.getParameter("class");
		String date=request.getParameter("date");
		String[] name=request.getParameterValues("name");
		String[] gender=request.getParameterValues("gender");
		String[] age=request.getParameterValues("age");
		System.out.println(from);
		System.out.println(to);
		System.out.println(train);
		Ticket t=new Ticket(from,to,train,clas,date);
		System.out.println(t.toString());
		System.out.println("hello");
		System.out.println(name[0]);
		
		Stations j=new Stations();
		Ticket tkt=j.setTicket(t);
		ArrayList<Passenger> pass=j.setPassengers(name, gender, age);
		
		request.setAttribute("ticket",tkt);
		request.setAttribute("pas", pass);
		
		RequestDispatcher rd=request.getRequestDispatcher("/view.jsp");
		rd.forward(request, response);
		
		
	}

}