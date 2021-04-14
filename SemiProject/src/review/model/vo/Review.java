package review.model.vo;

import java.sql.Date;

public class Review {
	private int review_no;
	private String account_id;
	private int reservation_no;
	private String review_title;
	private String review_content;
	private int review_grade;
	private Date create_date;
	private Date modify_date;
	private String status;
	private String hotelName;
	private int roomNo;
	private String guestName;
	private Date checkIn;
	private Date checkOut;
	private int adultCount;
	private int childCount;
	private int checkReservation;
	private String name;
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(int review_no, String account_id, int reservation_no, String review_title, String review_content,
			int review_grade, Date create_date, Date modify_date, String status) {
		super();
		this.review_no = review_no;
		this.account_id = account_id;
		this.reservation_no = reservation_no;
		this.review_title = review_title;
		this.review_content = review_content;
		this.review_grade = review_grade;
		this.create_date = create_date;
		this.modify_date = modify_date;
		this.status = status;
	}
	
	
	public Review(int review_no, String account_id, int reservation_no, String review_title, String review_content,
			int review_grade, Date create_date, Date modify_date, String status, String name) {
		super();
		this.review_no = review_no;
		this.account_id = account_id;
		this.reservation_no = reservation_no;
		this.review_title = review_title;
		this.review_content = review_content;
		this.review_grade = review_grade;
		this.create_date = create_date;
		this.modify_date = modify_date;
		this.status = status;
		this.name = name;
	}
	public Review(int review_no, String account_id, int reservation_no, String review_title, String review_content,
			int review_grade, Date create_date, Date modify_date, String status, String hotelName, int roomNo,
			String guestName, Date checkIn, Date checkOut, int adultCount, int childCount, int checkReservation,
			String name) {
		super();
		this.review_no = review_no;
		this.account_id = account_id;
		this.reservation_no = reservation_no;
		this.review_title = review_title;
		this.review_content = review_content;
		this.review_grade = review_grade;
		this.create_date = create_date;
		this.modify_date = modify_date;
		this.status = status;
		this.hotelName = hotelName;
		this.roomNo = roomNo;
		this.guestName = guestName;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.adultCount = adultCount;
		this.childCount = childCount;
		this.checkReservation = checkReservation;
		this.name = name;
	}
	public Review(String review_title, String review_content,  int review_grade,int review_no) {
		super();
		this.review_title = review_title;
		this.review_content = review_content;
		this.review_grade = review_grade;
		this.review_no = review_no;
	}
	public Review(int reservation_no, String hotelName,int roomNo, String guestName,
			 Date checkIn, Date checkOut , int adultCount, int childCount, String status ,String account_id) {
		super();
		this.reservation_no = reservation_no;
		this.hotelName = hotelName;
		this.roomNo = roomNo;
		this.guestName = guestName;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.adultCount = adultCount;
		this.childCount = childCount;
		this.status = status;
		this.account_id = account_id;
	}
	public Review(String account_id, int reservation_no, String status, String hotelName, String guestName,
			Date checkIn, Date checkOut, int adultCount, int childCount) {
		super();
		this.account_id = account_id;
		this.reservation_no = reservation_no;
		this.status = status;
		this.hotelName = hotelName;
		this.guestName = guestName;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.adultCount = adultCount;
		this.childCount = childCount;
	}
	
	
	public Review(int review_no, String review_title, String review_content, int review_grade) {
		super();
		this.review_no = review_no;
		this.review_title = review_title;
		this.review_content = review_content;
		this.review_grade = review_grade;
	}
	
	
	public Review(String account_id, int reservation_no, String status, String hotelName, int roomNo,
			String guestName, Date checkIn, Date checkOut, int adultCount, int childCount, int checkReservation) {
		super();
		this.account_id = account_id;
		this.reservation_no = reservation_no;
		this.status = status;
		this.hotelName = hotelName;
		this.roomNo = roomNo;
		this.guestName = guestName;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.adultCount = adultCount;
		this.childCount = childCount;
		this.checkReservation = checkReservation;
	}
	
	
	public Review(int review_no, String account_id, int reservation_no , String hotelName, String review_title, String review_content,
			int review_grade, Date create_date, Date modify_date, String status) {
		super();
		this.review_no = review_no;
		this.account_id = account_id;
		this.reservation_no = reservation_no;
		this.review_title = review_title;
		this.review_content = review_content;
		this.review_grade = review_grade;
		this.create_date = create_date;
		this.modify_date = modify_date;
		this.status = status;
		this.hotelName = hotelName;
	}
	
	public Review(String account_id, int reservation_no, String review_title, String review_content,
			int review_grade) {
		super();
		this.account_id = account_id;
		this.reservation_no = reservation_no;
		this.review_title = review_title;
		this.review_content = review_content;
		this.review_grade = review_grade;
	}
	
	
	public Review(int review_no, String account_id, int reservation_no, String review_title, String review_content,
			int review_grade, Date create_date, Date modify_date, String status, String hotelName, int roomNo,
			String guestName, Date checkIn, Date checkOut, int adultCount, int childCount, int checkReservation) {
		super();
		this.review_no = review_no;
		this.account_id = account_id;
		this.reservation_no = reservation_no;
		this.review_title = review_title;
		this.review_content = review_content;
		this.review_grade = review_grade;
		this.create_date = create_date;
		this.modify_date = modify_date;
		this.status = status;
		this.hotelName = hotelName;
		this.roomNo = roomNo;
		this.guestName = guestName;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.adultCount = adultCount;
		this.childCount = childCount;
		this.checkReservation = checkReservation;
	}
	
	
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public int getReservation_no() {
		return reservation_no;
	}
	public void setReservation_no(int reservation_no) {
		this.reservation_no = reservation_no;
	}
	public String getReview_title() {
		return review_title;
	}
	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public int getReview_grade() {
		return review_grade;
	}
	public void setReview_grade(int review_grade) {
		this.review_grade = review_grade;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getModify_date() {
		return modify_date;
	}
	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	public int getAdultCount() {
		return adultCount;
	}
	public void setAdultCount(int adultCount) {
		this.adultCount = adultCount;
	}
	public int getChildCount() {
		return childCount;
	}
	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}
	public int getCheckReservation() {
		return checkReservation;
	}
	public void setCheckReservation(int checkReservation) {
		this.checkReservation = checkReservation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Review [review_no=" + review_no + ", account_id=" + account_id + ", reservation_no=" + reservation_no
				+ ", review_title=" + review_title + ", review_content=" + review_content + ", review_grade="
				+ review_grade + ", create_date=" + create_date + ", modify_date=" + modify_date + ", status=" + status
				+ ", hotelName=" + hotelName + ", roomNo=" + roomNo + ", guestName=" + guestName + ", checkIn="
				+ checkIn + ", checkOut=" + checkOut + ", adultCount=" + adultCount + ", childCount=" + childCount
				+ ", checkReservation=" + checkReservation + ", name=" + name + "]";
	}

	
	
	
}
