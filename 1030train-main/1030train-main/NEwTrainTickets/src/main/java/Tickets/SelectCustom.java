package Tickets;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SelectCustom extends TagSupport {

	String from, to, table, column, trainno,dbUrl,driver;
	public String getDbUrl() {
		return dbUrl;
	}

	public String getDriver() {
		return driver;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	ResultSet rs;

	public String getTrainno() {
		return trainno;
	}

	public void setTrainno(String trainno) {
		this.trainno = trainno;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public int doStartTag() {
		String query ;
		JspWriter out = pageContext.getOut();
		try {
		
			Class.forName(driver);
			Connection cn = DriverManager.getConnection(dbUrl);
			Statement st = cn.createStatement();
			if(trainno!=null) {
			 query = "select "+column+" ," +trainno +      " from "+table;
			 
			 ResultSet rs = st.executeQuery(query);
				//out.print("<select>");
				while(rs.next()) {
				String station = rs.getString(column);
				
				String number = rs.getString(trainno);

				out.print("<option>"+station+" (" +number+ " )" +   "</option>" );
			 }
			}
			else {
			 query = "select "+column+ " from "+table;
			 ResultSet rs = st.executeQuery(query);
				//out.print("<select>");
				while(rs.next()) {
				String station = rs.getString(column);
				

				out.print("<option>"+station+"</option>" );
			}
			}
			
			
		//	out.print("<select>");
			
			rs.close();
			st.close();
			cn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SKIP_BODY;
		
	}
	
	
	

}
