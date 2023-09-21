package Tickets;
public class Ticket {
	@Override
	public String toString() {
		return "Ticket [from=" + from + ", to=" + to + ", train=" + train + ", clas=" + clas + ", date=" + date
				+ ", pnr=" + pnr + "]";
	}

	String from,to,train,clas,date,pnr;

	public Ticket(String from, String to, String train, String clas, String date) {
		super();
		this.from = from;
		this.to = to;
		this.train = train;
		this.clas = clas;
		this.date = date;
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

	public String getTrain() {
		return train;
	}

	public void setTrain(String train) {
		this.train = train;
	}

	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
}