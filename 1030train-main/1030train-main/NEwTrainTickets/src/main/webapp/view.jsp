<%@ page language="java"
	import="Tickets.Passenger,Tickets.Ticket,java.util.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Ticket Confirmed</h1><br>
		<%Ticket t=(Ticket)request.getAttribute("ticket"); %>
		<h3>PNR Number:<%=t.getPnr() %></h3><br>
		<h3>From:<%=t.getFrom() %></h3>
		<h3>To:<%=t.getTo() %></h3><br>
		<h3>Class:<%=t.getClas() %></h3>
		<h3>Date:<%=t.getDate() %></h3>
		
		<table>
			<tr>
				<th>Name</th>
				<th>Gender</th>
				<th>Age</th>
			</tr>
			<tbody>
				<%
				ArrayList<Passenger> pass = (ArrayList<Passenger>) request.getAttribute("pas");
				for (Passenger p : pass) {
				%>
				<tr>
					<td><%=p.getName()%></td>
					<td><%=p.getGender()%></td>
					<td><%=p.getAge()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</center>
</body>
</html>