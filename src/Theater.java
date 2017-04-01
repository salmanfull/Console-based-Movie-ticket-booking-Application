import java.util.ArrayList;

/*
 * Class to represent a Theater.
 * Author : Salmankhan
 */
public class Theater {
   private ArrayList<Ticket> ticketList;    //list to keep track of booked tickets
   private int row,col;
   private boolean seats[][];               //boolean array to keep track of booked seats.
   public Theater(int row, int column){
	   this.row  = row;
	   col = column;
	   ticketList = new ArrayList<Ticket>();
	   seats = new boolean[row][column];
   }
   public ArrayList<Ticket> getTicketList(){   
	   return ticketList;
   }
   /*
    * method to check whether theater is housefull or not
    */
   public boolean isHouseFull(){
	   return ticketList.size() == row * col;
   }
   
   /*
    * method to get the column number
    */
   private int getColumnNumber(String seatNo){
	   int col;
	   if(seatNo.length()==2)
		 col=Character.getNumericValue(seatNo.charAt(1))-1;       // if column number is less than 10
	   else
		 col=Integer.parseInt(seatNo.substring(1, 3))-1; 		  // if column number is equal or greater than 10
	   return col;
   }
   
   /*
    * method to book movie Tickets
    */
   public boolean bookTicket(String seatNo, String Name){
	   	 seatNo = seatNo.toUpperCase();
	     int row = seatNo.charAt(0)-65;
	     int col=getColumnNumber(seatNo);
	     if(seats[row][col])              						  // if seat is already booked, return false
	    	 return false;
	     else
	     {
	    	 Ticket t = new Ticket(Name,seatNo);
	    	 ticketList.add(t);
	    	 seats[row][col]=true;
	    	 return true;            							  // return true, if seat is booked successfully.
	     }
   }
   
   /*
    * method to check whether the given seat number is the valid one or not.
    */
   public boolean validSeat(String seatNo){
	   seatNo = seatNo.toUpperCase();
	   if(seatNo.length()!=2 && seatNo.length()!=3) {                              	 
		  return false;
	   }	   
	   int row = seatNo.charAt(0)-65;
	   int col=getColumnNumber(seatNo);
	   return row>=0 && row<this.row && col>=0 && col<this.col;      // check that the row and column are within the range.
   }
   
   /*
    * method to print the seats
    */
   public void printSeats(){
	   for(int i=1;i<=col;i++)
	        System.out.print("     "+i);
	   System.out.println();
	   char c='A';
	   for(int i=1;i<=row;i++){
		   System.out.print(c++);
		   for(int j=1;j<=col;j++){
			   if(seats[i-1][j-1]){
				   if(j<=9)
				   System.out.print("   |X|" );
				   else
				   System.out.print("    |X|");   
				   
			   }
			   else{
				   if(j<=9)
				   System.out.print("   |_|");
				   else
				   System.out.print("    |_|");
			   }
		   }
		   System.out.println();
	   }
   }
   public void showTickets(){
	   System.out.println("----------------------------");
	   if(ticketList.size()==0){											// if no tickets are booked.
		   System.out.println("No Tickets are booked");
		   System.out.println("----------------------------");
	   }
	   for(Ticket ticket : ticketList){
		   System.out.println("SeatNumber : " + ticket.getSeatNo() + "   Name : "+ ticket.getName());
	   }
	   System.out.println("----------------------------");
   }
   
   
}
