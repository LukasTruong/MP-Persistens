package model;

public class Club extends Customer{

	private int clubNo;
	
	public Club (int clubNo, String name, String street, int houseNo, String floor, String zipCode, String city, String country, String email, int phone) {
		super(name, street,houseNo, floor, zipCode, city, country, email, phone);
		this.clubNo = clubNo;
	}
		
		public int getClubNo() {
			return clubNo;
		}

		public void setClubNo(int clubNo) {
			this.clubNo = clubNo;
		
	}
}
