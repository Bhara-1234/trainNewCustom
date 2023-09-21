package Tickets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Stations {
//	public ArrayList<TrainDAL> getSations() {
//		ArrayList<TrainDAL> res = new ArrayList<>();
//		try {
//			Class.forName("org.postgresql.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?user=postgres&password=Bhara@1234");
//			Statement stat = conn.createStatement();
//			ResultSet rs = stat.executeQuery("select trn_start,trn_end from BB_Stations;");
//
//			while (rs.next()) {
//				res.add(new TrainDAL(rs.getString(1), rs.getString(2)));
//			}
//		} catch (Exception ex) {
//			System.out.println(ex);
//		}
//		return res;
//	}

//	public JSONArray getTrains(String f, String t) {
//		JSONArray ja = new JSONArray();
//		try {
//			Class.forName("org.postgresql.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?user=postgres&password=Bhara@1234");
//			PreparedStatement stat = conn
//					.prepareStatement("select trn_name from BB_Stations where trn_start=? and trn_end=?");
//			stat.setString(1, f);
//			stat.setString(2, t);
//			ResultSet rs = stat.executeQuery();
//			while (rs.next()) {
//				JSONObject jo = new JSONObject();
//				jo.put("Train", rs.getString(1));
//				ja.put(jo);
//			}
//		} catch (Exception ex) {
//			System.out.println(ex);
//		}
//		return ja;
//	}

	public ArrayList<Passenger> setPassengers(String[] name, String[] gender, String[] age) {
		ArrayList<Passenger> pas = new ArrayList<>();
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?user=postgres&password=Bhara@1234");
			PreparedStatement stat = conn.prepareStatement("insert into TktPassengers values(?,?,?)");
			for (int i = 0; i < name.length; i++) {
				stat.setString(1, name[i]);
				stat.setString(2, gender[i]);
				stat.setString(3, age[i]);
				stat.execute();
				pas.add(new Passenger(name[i], gender[i], age[i]));
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return pas;
	}

	public Ticket setTicket(Ticket y) {
		String pnr=null;
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?user=postgres&password=Bhara@1234");
			PreparedStatement stat = conn.prepareStatement("insert into TktTickets(from_location, to_location, train, class, date) values(?,?,?,?,?)");
			stat.setString(1, y.getFrom());
			stat.setString(2, y.getTo());
			stat.setString(3, y.getTrain());
			stat.setString(4, y.getClas());
			stat.setString(5, y.getDate());
			stat.execute();
			PreparedStatement stat1=conn.prepareStatement("select pnr from TktTickets where  from_location=? and to_location=? and train=? and date=? and class=?;");
			stat1.setString(1, y.getFrom());
			stat1.setString(2, y.getTo());
			stat1.setString(3, y.getTrain());
			stat1.setString(4, y.getDate());
			stat1.setString(5, y.getClas());
			ResultSet rs=stat1.executeQuery();
			if(rs.next());{
				pnr=rs.getInt(1)+"";
			}
			y.setPnr(pnr);
			} catch (Exception ex) {
			System.out.println(ex);
		}
		return y;
	}

}