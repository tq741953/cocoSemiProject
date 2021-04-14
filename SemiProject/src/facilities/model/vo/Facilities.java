package facilities.model.vo;

public class Facilities {
	private int Room_no;
	private int Hotel_id;
	private int Room_count;
	private int Room_price;
	private int Room_maximum;
	private int Adult_count;
	private int Child_count;
	private String Hotel_service;
	private String Bed_type;
	private String Room_type;
	// HOTEL거 당겨 왔습니다.
	private String Account_id;
	private String Hotel_name;
	private String Hotel_Address;
	private String Hotel_phone;
	private String status;
	public Facilities() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Facilities(int hotel_id, int room_count, int room_price, int room_maximum, int adult_count, int child_count,
			String hotel_service, String bed_type, String room_type) {
		super();
		Hotel_id = hotel_id;
		Room_count = room_count;
		Room_price = room_price;
		Room_maximum = room_maximum;
		Adult_count = adult_count;
		Child_count = child_count;
		Hotel_service = hotel_service;
		Bed_type = bed_type;
		Room_type = room_type;
	}


	public Facilities(int room_no, int hotel_id, int room_count, int room_price, int room_maximum, int adult_count,
			int child_count, String hotel_service, String bed_type, String room_type) {
		super();
		Room_no = room_no;
		Hotel_id = hotel_id;
		Room_count = room_count;
		Room_price = room_price;
		Room_maximum = room_maximum;
		Adult_count = adult_count;
		Child_count = child_count;
		Hotel_service = hotel_service;
		Bed_type = bed_type;
		Room_type = room_type;
	}

	public Facilities(int room_no, int hotel_id, int room_count, int room_price, int room_maximum, int adult_count,
			int child_count, String hotel_service, String bed_type, String room_type, String account_id,
			String hotel_name, String hotel_Address, String hotel_phone, String status) {
		super();
		Room_no = room_no;
		Hotel_id = hotel_id;
		Room_count = room_count;
		Room_price = room_price;
		Room_maximum = room_maximum;
		Adult_count = adult_count;
		Child_count = child_count;
		Hotel_service = hotel_service;
		Bed_type = bed_type;
		Room_type = room_type;
		Account_id = account_id;
		Hotel_name = hotel_name;
		Hotel_Address = hotel_Address;
		Hotel_phone = hotel_phone;
		this.status = status;
	}

	public Facilities(String room_no2, String hotel_id2, String room_count2, String room_price2, String room_maximum2,
			String adult_count2, String child_count2, String bed_type2, String room_type2, String hotel_service2) {
		// TODO Auto-generated constructor stub
	}
	public int getRoom_no() {
		return Room_no;
	}
	public void setRoom_no(int room_no) {
		Room_no = room_no;
	}
	public int getHotel_id() {
		return Hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		Hotel_id = hotel_id;
	}
	public int getRoom_count() {
		return Room_count;
	}
	public void setRoom_count(int room_count) {
		Room_count = room_count;
	}
	public int getRoom_price() {
		return Room_price;
	}
	public void setRoom_price(int room_price) {
		Room_price = room_price;
	}
	public int getRoom_maximum() {
		return Room_maximum;
	}
	public void setRoom_maximum(int room_maximum) {
		Room_maximum = room_maximum;
	}
	public int getAdult_count() {
		return Adult_count;
	}
	public void setAdult_count(int adult_count) {
		Adult_count = adult_count;
	}
	public int getChild_count() {
		return Child_count;
	}
	public void setChild_count(int child_count) {
		Child_count = child_count;
	}
	public String getHotel_service() {
		return Hotel_service;
	}
	public void setHotel_service(String hotel_service) {
		Hotel_service = hotel_service;
	}
	public String getBed_type() {
		return Bed_type;
	}
	public void setBed_type(String bed_type) {
		Bed_type = bed_type;
	}
	public String getRoom_type() {
		return Room_type;
	}
	public void setRoom_type(String room_type) {
		Room_type = room_type;
	}
	
	

	public String getAccount_id() {
		return Account_id;
	}


	public void setAccount_id(String account_id) {
		Account_id = account_id;
	}


	public String getHotel_name() {
		return Hotel_name;
	}


	public void setHotel_name(String hotel_name) {
		Hotel_name = hotel_name;
	}


	public String getHotel_Address() {
		return Hotel_Address;
	}


	public void setHotel_Address(String hotel_Address) {
		Hotel_Address = hotel_Address;
	}


	public String getHotel_phone() {
		return Hotel_phone;
	}


	public void setHotel_phone(String hotel_phone) {
		Hotel_phone = hotel_phone;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Facilities [Room_no=" + Room_no + ", Hotel_id=" + Hotel_id + ", Room_count=" + Room_count
				+ ", Room_price=" + Room_price + ", Room_maximum=" + Room_maximum + ", Adult_count=" + Adult_count
				+ ", Child_count=" + Child_count + ", Hotel_service=" + Hotel_service + ", Bed_type=" + Bed_type
				+ ", Room_type=" + Room_type + ", Account_id=" + Account_id + ", Hotel_name=" + Hotel_name
				+ ", Hotel_Address=" + Hotel_Address + ", Hotel_phone=" + Hotel_phone + ", status=" + status + "]";
	}
}
