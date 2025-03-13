package model;

public class Club extends Customer{

	private int clubNo;
	
	public Club (int clubNo, String name, String address, String zipCode, String city, String country, String email) {
		super(name, address, zipCode, city, country, email);
		this.clubNo = clubNo;
	}
		
		public int getClubNo() {
			return clubNo;
		}

		public void setClubNo(int clubNo) {
			this.clubNo = clubNo;
		
	}
}
