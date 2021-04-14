package hotel.model.vo;

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
	private int rcount;
	private String name;	// 리뷰쓴 사람 이름 받아오기
	private String hotel_name;
	
	public Review() {}

	public Review(int review_no, String account_id, int reservation_no, String review_title, String review_content,
			int review_grade, Date create_date, Date modify_date, String status, int rcount, String name, String hotel_name) {
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
		this.rcount = rcount;
		this.name = name;
		this.hotel_name = hotel_name;
	}
	
	public Review(int review_no, String account_id, int reservation_no, String review_title, String review_content,
			int review_grade, Date create_date, Date modify_date, String status, int rcount, String name) {
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
		this.rcount = rcount;
		this.name = name;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getRcount() {
		return rcount;
	}

	public void setRcount(int rcount) {
		this.rcount = rcount;
	}

	@Override
	public String toString() {
		return "Review [review_no=" + review_no + ", account_id=" + account_id + ", reservation_no=" + reservation_no
				+ ", review_title=" + review_title + ", review_content=" + review_content + ", review_grade="
				+ review_grade + ", create_date=" + create_date + ", modify_date=" + modify_date + ", status=" + status
				+ ", rcount=" + rcount + ", name=" + name + ", hotel_name=" + hotel_name + "]";
	}

	
}
