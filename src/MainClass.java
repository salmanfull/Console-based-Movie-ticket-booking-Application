import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Theater theater = new Theater(5, 5); // can change the parameters upto 26, 26 which represents
						     // number of rows and columns of seats in the theater.
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
				System.out.println("Enter a Seat number:");
				String seatNo = in.nextLine();
				if (!theater.validSeat(seatNo)) {
					System.out.println("Not a Valid seat number. Please try again.");
					continue;
				}
				System.out.println("Enter your name:");
				String name = in.nextLine();
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
