package hnotice.model.vo;

import java.sql.Date;

public class HNotice {
	
	private int hnNo;
	private int hotel_id;
	private String account_id;
	private String hnTitle;
	private String hnContent;
	private Date create_date;
	private Date modify_date;
	private String status;
	private String hotelName;
	public HNotice() {
		super();
	}
	
	public HNotice(int hotel_id, String hnTitle, String hnContent) {
		super();
		this.hotel_id = hotel_id;
		this.hnTitle = hnTitle;
		this.hnContent = hnContent;
	}


	public HNotice(int hotel_id, String account_id, String hnTitle, String hnContent) {
		super();
		this.hotel_id = hotel_id;
		this.account_id = account_id;
		this.hnTitle = hnTitle;
		this.hnContent = hnContent;
	}

	public HNotice(String account_id, String hnTitle, String hnContent) {
		super();
		this.account_id = account_id;
		this.hnTitle = hnTitle;
		this.hnContent = hnContent;
	}

	public HNotice(int hnNo, int hotel_id, String account_id, String hnTitle, String hnContent, Date create_date,
			Date modify_date, String status, String hotelName) {
		super();
		this.hnNo = hnNo;
		this.hotel_id = hotel_id;
		this.account_id = account_id;
		this.hnTitle = hnTitle;
		this.hnContent = hnContent;
		this.create_date = create_date;
		this.modify_date = modify_date;
		this.status = status;
		this.hotelName = hotelName;
	}

	public HNotice(int hnNo, int hotel_id, String account_id, String hnTitle, String hnContent, Date create_date,
			Date modify_date, String status) {
		super();
		this.hnNo = hnNo;
		this.hotel_id = hotel_id;
		this.account_id = account_id;
		this.hnTitle = hnTitle;
		this.hnContent = hnContent;
		this.create_date = create_date;
		this.modify_date = modify_date;
		this.status = status;
	}

	public int getHnNo() {
		return hnNo;
	}

	public void setHnNo(int hnNo) {
		this.hnNo = hnNo;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getHnTitle() {
		return hnTitle;
	}

	public void setHnTitle(String hnTitle) {
		this.hnTitle = hnTitle;
	}

	public String getHnContent() {
		return hnContent;
	}

	public void setHnContent(String hnContent) {
		this.hnContent = hnContent;
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

	@Override
	public String toString() {
		return "HNotice [hnNo=" + hnNo + ", hotel_id=" + hotel_id + ", account_id=" + account_id + ", hnTitle="
				+ hnTitle + ", hnContent=" + hnContent + ", create_date=" + create_date + ", modify_date=" + modify_date
				+ ", status=" + status + ", hotelName=" + hotelName + "]";
	}


}
