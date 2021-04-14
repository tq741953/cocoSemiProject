package hotel.model.vo;

import java.sql.Date;

public class QnA {

	private int qna_no;
	private String account_id;
	private int hotel_id;
	private String qna_title;
	private String qna_content;
	private String qna_answer;
	private Date create_date;
	private String status;
	private int qnacount;
	private int qna_status;
	private Date modify_date;
	private String hotel_name;
	private String name;

	/*
	 * QNA_NO NUMBER ACCOUNT_ID VARCHAR2(20 BYTE) HOTEL_ID NUMBER QNA_TITLE
	 * VARCHAR2(200 BYTE) QNA_CONTENT VARCHAR2(4000 BYTE) QNA_ANSWER VARCHAR2(4000
	 * BYTE) CREATE_DATE DATE STATUS VARCHAR2(30 BYTE) QNACOUNT NUMBER QNA_STATUS
	 * NUMBER MODIFY_DATE DATE
	 */

	public QnA() {
		super();
	}
	



	public QnA(int qna_no, String qna_answer) {
		super();
		this.qna_no = qna_no;
		this.qna_answer = qna_answer;
	}




	public QnA(int qna_no, String account_id, int hotel_id, String qna_content, String qna_answer) {
		super();
		this.qna_no = qna_no;
		this.account_id = account_id;
		this.hotel_id = hotel_id;
		this.qna_content = qna_content;
		this.qna_answer = qna_answer;
	}




	public QnA(int qna_no, String account_id, String qna_content, String qna_answer) {
		super();
		this.qna_no = qna_no;
		this.account_id = account_id;
		this.qna_content = qna_content;
		this.qna_answer = qna_answer;
	}




	public QnA(int qna_no, String account_id, int hotel_id, String qna_title, String qna_content, String qna_answer,
			Date create_date, String status, int qnacount, int qna_status, Date modify_date, String hotel_name,
			String name) {
		super();
		this.qna_no = qna_no;
		this.account_id = account_id;
		this.hotel_id = hotel_id;
		this.qna_title = qna_title;
		this.qna_content = qna_content;
		this.qna_answer = qna_answer;
		this.create_date = create_date;
		this.status = status;
		this.qnacount = qnacount;
		this.qna_status = qna_status;
		this.modify_date = modify_date;
		this.hotel_name = hotel_name;
		this.name = name;
	}
	
	

	public QnA(int qna_no, String account_id, int hotel_id, String qna_title, String qna_content, String qna_answer,
			Date create_date, String status, int qnacount, int qna_status, Date modify_date, String name) {
		super();
		this.qna_no = qna_no;
		this.account_id = account_id;
		this.hotel_id = hotel_id;
		this.qna_title = qna_title;
		this.qna_content = qna_content;
		this.qna_answer = qna_answer;
		this.create_date = create_date;
		this.status = status;
		this.qnacount = qnacount;
		this.qna_status = qna_status;
		this.modify_date = modify_date;
		this.name = name;
	}

	public QnA(int qna_no, String account_id, int hotel_id, String qna_title, String qna_content, Date create_date,
			String status, int qnacount, int qna_status, Date modify_date, String hotel_name, String name) {
		super();
		this.qna_no = qna_no;
		this.account_id = account_id;
		this.hotel_id = hotel_id;
		this.qna_title = qna_title;
		this.qna_content = qna_content;
		this.create_date = create_date;
		this.status = status;
		this.qnacount = qnacount;
		this.qna_status = qna_status;
		this.modify_date = modify_date;
		this.hotel_name = hotel_name;
		this.name = name;
	}

	public QnA(String account_id, String qna_title, String qna_content) {
		super();
		this.account_id = account_id;
		this.qna_title = qna_title;
		this.qna_content = qna_content;
	}

	public int getQna_no() {
		return qna_no;
	}

	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getQna_title() {
		return qna_title;
	}

	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}

	public String getQna_content() {
		return qna_content;
	}

	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}

	public String getQna_answer() {
		return qna_answer;
	}

	public void setQna_answer(String qna_answer) {
		this.qna_answer = qna_answer;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getQnacount() {
		return qnacount;
	}

	public void setQnacount(int qnacount) {
		this.qnacount = qnacount;
	}

	public int getQna_status() {
		return qna_status;
	}

	public void setQna_status(int qna_status) {
		this.qna_status = qna_status;
	}

	public Date getModify_date() {
		return modify_date;
	}

	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
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

	@Override
	public String toString() {
		return "QnA [qna_no=" + qna_no + ", account_id=" + account_id + ", hotel_id=" + hotel_id + ", qna_title="
				+ qna_title + ", qna_content=" + qna_content + ", qna_answer=" + qna_answer + ", create_date="
				+ create_date + ", status=" + status + ", qnacount=" + qnacount + ", qna_status=" + qna_status
				+ ", modify_date=" + modify_date + ", hotel_name=" + hotel_name + ", name=" + name + "]";
	}

}
