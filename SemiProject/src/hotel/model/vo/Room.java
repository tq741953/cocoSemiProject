package hotel.model.vo;

import java.sql.Date;

public class Room {
	private int room_no;
	private int hotel_id;
	private int room_count;
	private int room_price;
	private int room_maximum;
	private int adult_count;
	private int child_count;
	private String hotel_service;
	private String bed_type;
	private String room_type;
	private Date check_in;
	private Date check_out;
	/*ROOM_NO	NUMBER
	HOTEL_ID	VARCHAR2(20 BYTE)
	ROOM_COUNT	NUMBER
	ROOM_PRICE	NUMBER
	ROOM_MAXIMUM	NUMBER
	ADULT_COUNT	NUMBER
	CHILD_COUNT	NUMBER
	HOTEL_SERVICE	VARCHAR2(3000 BYTE)
	BED_TYPE	VARCHAR2(20 BYTE)
	ROOM_TYPE	VARCHAR2(20 BYTE)*/
	
	public Room() {}

	
	public Room(int room_no, int hotel_id, int room_count, int room_price, int room_maximum, int adult_count,
			int child_count, String hotel_service, String bed_type, String room_type, Date check_in, Date check_out) {
		super();
		this.room_no = room_no;
		this.hotel_id = hotel_id;
		this.room_count = room_count;
		this.room_price = room_price;
		this.room_maximum = room_maximum;
		this.adult_count = adult_count;
		this.child_count = child_count;
		this.hotel_service = hotel_service;
		this.bed_type = bed_type;
		this.room_type = room_type;
		this.check_in = check_in;
		this.check_out = check_out;
	}

	public Date getCheck_in() {
		return check_in;
	}


	public void setCheck_in(Date check_in) {
		this.check_in = check_in;
	}


	public Date getCheck_out() {
		return check_out;
	}


	public void setCheck_out(Date check_out) {
		this.check_out = check_out;
	}


	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
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


	@Override
	public String toString() {
		return "Room [room_no=" + room_no + ", hotel_id=" + hotel_id + ", room_count=" + room_count + ", room_price="
				+ room_price + ", room_maximum=" + room_maximum + ", adult_count=" + adult_count + ", child_count="
				+ child_count + ", hotel_service=" + hotel_service + ", bed_type=" + bed_type + ", room_type="
				+ room_type + ", check_in=" + check_in + ", check_out=" + check_out + "]";
	}

	
	
	
	
	

}
