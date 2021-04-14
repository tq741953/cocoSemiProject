package Hotelinsert.model.vo;

public class Hotel {
	
	private int Hotel_id;
	private String Account_id;
	private String Hotel_name;
	private String Hotel_address;
	private String Hotel_phone;
	private String status;
	private String Business_license;
	private String Hotel_status;
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hotel(int hotel_id, String account_id, String hotel_name, String hotel_address, String hotel_phone,
			String status, String business_license, String hotel_status) {
		super();
		Hotel_id = hotel_id;
		Account_id = account_id;
		Hotel_name = hotel_name;
		Hotel_address = hotel_address;
		Hotel_phone = hotel_phone;
		this.status = status;
		Business_license = business_license;
		Hotel_status = hotel_status;
	}
	public int getHotel_id() {
		return Hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		Hotel_id = hotel_id;
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
	public String getHotel_address() {
		return Hotel_address;
	}
	public void setHotel_address(String hotel_address) {
		Hotel_address = hotel_address;
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
	public String getBusiness_license() {
		return Business_license;
	}
	public void setBusiness_license(String business_license) {
		Business_license = business_license;
	}
	public String getHotel_status() {
		return Hotel_status;
	}
	public void setHotel_status(String hotel_status) {
		Hotel_status = hotel_status;
	}
	@Override
	public String toString() {
		return "Hotel [Hotel_id=" + Hotel_id + ", Account_id=" + Account_id + ", Hotel_name=" + Hotel_name
				+ ", Hotel_address=" + Hotel_address + ", Hotel_phone=" + Hotel_phone + ", status=" + status
				+ ", Business_license=" + Business_license + ", Hotel_status=" + Hotel_status + "]";
	}
	
}
