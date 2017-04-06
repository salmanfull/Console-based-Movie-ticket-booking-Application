import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Theater theater = new Theater(10, 10); // can change the parameters upto  26, 26 which represents
												// number of rows and columns in the theater.										 
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("1. Book a ticket.");
			System.out.println("2. Show Booked ticket details");
			System.out.println("3. Exit.");
			int choice = 0;
			try {
				choice = in.nextInt();
				in.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Enter a number.");
				in.nextLine();
				continue;
			}
			switch (choice) {
			case 1:
				if (theater.isHouseFull()) {
					theater.printSeats();
					System.out.println("Sorry all tickets are booked.");
					continue;
				}
				theater.printSeats();
				String seatNo;
				boolean isSeatValid = false;
				do {
					System.out.println("Enter a Seat number:");
					seatNo = in.nextLine();
					//if (!isSeatValid) {
						try{
							isSeatValid = theater.validSeat(seatNo);
						}
						catch(InvalidSeatException e){
							System.out.println(e.getMessage());
							continue;
						}
		
				} while (!isSeatValid);

				String name;
				boolean nameValid = true;
				do {
					System.out.println("Enter your name:");
					name = in.nextLine();
					if (name.length() == 0) {
						System.out.println("Name cannot be empty. Please try again.");
						nameValid = false;
						continue;
					} else if (name.matches(".*\\d")) {
						System.out.println("Name cannot contain a number. Please try again.");
						nameValid = false;
						continue;
					}
					nameValid = true;
				} while (!nameValid);
				if (theater.bookTicket(seatNo, name)) {
					System.out.println("Ticket booked Successfully --> SeatNumber : " + seatNo + "   Name :" + name);
					theater.printSeats();
				} else {
					System.out.println("Seat is already booked. Try another seat.");
					continue;
				}
				break;
			case 2:
				theater.showTickets();
				break;
			case 3:
				return;
			default:
				System.out.println("Enter a valid number");

			}

		}
	}

}
