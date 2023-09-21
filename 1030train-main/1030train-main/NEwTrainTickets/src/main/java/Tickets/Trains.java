package Tickets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

@WebServlet("/Trains")
public class Trains extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sf=request.getParameter("from");
		String st=request.getParameter("to");
		Stations t=new Stations();
		//JSONArray ja=t.getTrains(sf, st);
		//response.getWriter().write(ja.toString());
	}
}