/*
 * Class to represent a Ticket.
 * Author : Salmankhan
 */
public class Ticket {
	private String name;
	private String seatNo;

	public Ticket(String name, String seatNo) {
		this.name = name;
		this.seatNo = seatNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

}
