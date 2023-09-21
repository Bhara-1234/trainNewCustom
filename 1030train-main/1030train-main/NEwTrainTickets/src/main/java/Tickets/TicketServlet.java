package Tickets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/TicketServlet")
public class TicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TicketServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		Stations t=null;
//		ArrayList<TrainDAL> al=null;
//		t=new Stations();
//		al=t.getSations();
//		
//		JSONArray ja=new JSONArray();
//		
//		for(TrainDAL y:al) {
//			JSONObject jo=new JSONObject();
//			jo.put("from",y.getFrom());
//			jo.put("to", y.getTo());
//			ja.put(jo);
//		}
//		response.getWriter().write(ja.toString());
//	}

	}
}
	