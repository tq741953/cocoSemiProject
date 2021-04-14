package hotel.model.vo;

public class Hotel {
	private int hotel_id;
	private String account_id;
	private String hotel_name;
	private String hotel_address;
	private String hotel_phone;
	private double hotel_x;
	private double hotel_y;
	private String file_url;
	private String file_rename;
	private String status;	// 호텔
	private int room_no;
	private int room_count;
	private int room_price;
	private int room_maximum;
	private int adult_count;
	private int child_count;
	private String hotel_service;
	private String bed_type;
	private String room_type;	// 방
	private int checkedRoom;	// 예약한 방의 갯수를 세기위한 임의 변수
	private String business_license;
	private String hotel_status;
	
	
	public Hotel() {}
	
	
	
	public int getCheckedRoom() {
		return checkedRoom;
	}



	public void setCheckedRoom(int checkedRoom) {
		this.checkedRoom = checkedRoom;
	}



	public Hotel(int hotel_id) {
		super();
		this.hotel_id = hotel_id;
	}



	public Hotel(int hotel_id, String account_id, String hotel_name, String hotel_address, String hotel_phone,
			 String status, String business_license, String hotel_status , String file_rename ,String file_url) {
		super();
		this.hotel_id = hotel_id;
		this.account_id = account_id;
		this.hotel_name = hotel_name;
		this.hotel_address = hotel_address;
		this.hotel_phone = hotel_phone;
		this.file_url = file_url;
		this.file_rename = file_rename;
		this.status = status;
		this.business_license = business_license;
		this.hotel_status = hotel_status;
	}



	public Hotel(int hotel_id, String account_id, String hotel_name, String hotel_address, String hotel_phone,
			String status, String business_license, String hotel_status) {
		super();
		this.hotel_id = hotel_id;
		this.account_id = account_id;
		this.hotel_name = hotel_name;
		this.hotel_address = hotel_address;
		this.hotel_phone = hotel_phone;
		this.status = status;
		this.business_license = business_license;
		this.hotel_status = hotel_status;
	}



	public Hotel(int hotel_id, String account_id, String hotel_name, String hotel_address, String hotel_phone,
			double hotel_x, double hotel_y, String file_url, String file_rename, String status, int room_no,
			int room_count, int room_price, int room_maximum, int adult_count, int child_count, String hotel_service,
			String bed_type, String room_type, int checkedRoom) {
		super();
		this.hotel_id = hotel_id;
		this.account_id = account_id;
		this.hotel_name = hotel_name;
		this.hotel_address = hotel_address;
		this.hotel_phone = hotel_phone;
		this.hotel_x = hotel_x;
		this.hotel_y = hotel_y;
		this.file_url = file_url;
		this.file_rename = file_rename;
		this.status = status;
		this.room_no = room_no;
		this.room_count = room_count;
		this.room_price = room_price;
		this.room_maximum = room_maximum;
		this.adult_count = adult_count;
		this.child_count = child_count;
		this.hotel_service = hotel_service;
		this.bed_type = bed_type;
		this.room_type = room_type;
		this.checkedRoom = checkedRoom;
	}



	public Hotel(int hotel_id, String hotel_name, String hotel_address, String hotel_phone, double hotel_x,
			double hotel_y, String file_url, String file_rename, String status, int room_no, int room_count,
			int room_price, int adult_count, int child_count, String hotel_service, String bed_type, String room_type) {
		super();
		this.hotel_id = hotel_id;
		this.hotel_name = hotel_name;
		this.hotel_address = hotel_address;
		this.hotel_phone = hotel_phone;
		this.hotel_x = hotel_x;
		this.hotel_y = hotel_y;
		this.file_url = file_url;
		this.file_rename = file_rename;
		this.status = status;
		this.room_no = room_no;
		this.room_count = room_count;
		this.room_price = room_price;
		this.adult_count = adult_count;
		this.child_count = child_count;
		this.hotel_service = hotel_service;
		this.bed_type = bed_type;
		this.room_type = room_type;
	}

	public Hotel(int hotel_id, String account_id, String hotel_name, String hotel_address, String hotel_phone,
			double hotel_x, double hotel_y, String file_url, String file_rename, String status, int room_no,
			int room_count, int room_price, int room_maximum, int adult_count, int child_count, String hotel_service,
			String bed_type, String room_type) {
		super();
		this.hotel_id = hotel_id;
		this.account_id = account_id;
		this.hotel_name = hotel_name;
		this.hotel_address = hotel_address;
		this.hotel_phone = hotel_phone;
		this.hotel_x = hotel_x;
		this.hotel_y = hotel_y;
		this.file_url = file_url;
		this.file_rename = file_rename;
		this.status = status;
		this.room_no = room_no;
		this.room_count = room_count;
		this.room_price = room_price;
		this.room_maximum = room_maximum;
		this.adult_count = adult_count;
		this.child_count = child_count;
		this.hotel_service = hotel_service;
		this.bed_type = bed_type;
		this.room_type = room_type;
	}

	public String getBusiness_license() {
		return business_license;
	}



	public void setBusiness_license(String business_license) {
		this.business_license = business_license;
	}



	public String getHotel_status() {
		return hotel_status;
	}



	public void setHotel_status(String hotel_status) {
		this.hotel_status = hotel_status;
	}



	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

	public int getRoom_count() {
		return room_count;
	}

	public void setRoom_count(int room_count) {
		this.room_count = room_count;
	}

	public int getRoom_price() {
		return room_price;
	}

	public void setRoom_price(int room_price) {
		this.room_price = room_price;
	}

	public int getRoom_maximum() {
		return room_maximum;
	}

	public void setRoom_maximum(int room_maximum) {
		this.room_maximum = room_maximum;
	}

	public int getAdult_count() {
		return adult_count;
	}

	public void setAdult_count(int adult_count) {
		this.adult_count = adult_count;
	}

	public int getChild_count() {
		return child_count;
	}

	public void setChild_count(int child_count) {
		this.child_count = child_count;
	}

	public String getHotel_service() {
		return hotel_service;
	}

	public void setHotel_service(String hotel_service) {
		this.hotel_service = hotel_service;
	}

	public String getBed_type() {
		return bed_type;
	}

	public void setBed_type(String bed_type) {
		this.bed_type = bed_type;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public String getHotel_address() {
		return hotel_address;
	}

	public void setHotel_address(String hotel_address) {
		this.hotel_address = hotel_address;
	}

	public String getHotel_phone() {
		return hotel_phone;
	}

	public void setHotel_phone(String hotel_phone) {
		this.hotel_phone = hotel_phone;
	}

	public double getHotel_x() {
		return hotel_x;
	}

	public void setHotel_x(double hotel_x) {
		this.hotel_x = hotel_x;
	}

	public double getHotel_y() {
		return hotel_y;
	}

	public void setHotel_y(double hotel_y) {
		this.hotel_y = hotel_y;
	}

	public String getFile_url() {
		return file_url;
	}

	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}

	public String getFile_rename() {
		return file_rename;
	}

	public void setFile_rename(String file_rename) {
		this.file_rename = file_rename;
	}



	@Override
	public String toString() {
		return "Hotel [hotel_id=" + hotel_id + ", account_id=" + account_id + ", hotel_name=" + hotel_name
				+ ", hotel_address=" + hotel_address + ", hotel_phone=" + hotel_phone + ", hotel_x=" + hotel_x
				+ ", hotel_y=" + hotel_y + ", file_url=" + file_url + ", file_rename=" + file_rename + ", status="
				+ status + ", room_no=" + room_no + ", room_count=" + room_count + ", room_price=" + room_price
				+ ", room_maximum=" + room_maximum + ", adult_count=" + adult_count + ", child_count=" + child_count
				+ ", hotel_service=" + hotel_service + ", bed_type=" + bed_type + ", room_type=" + room_type
				+ ", checkedRoom=" + checkedRoom + ", business_license=" + business_license + ", hotel_status="
				+ hotel_status + "]";
	}




	

	

	
	
	
}
