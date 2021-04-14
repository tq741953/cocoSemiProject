package hotel.model.vo;

import account.model.vo.Account;

public class Reservation {
	private int reservation_no;
	private Account account_id;
	private String check_in;
	private String check_out;
	private String askIn;		// �슂泥��궗�빆 request媛� �삁�빟�뼱�엫 �궗�슜遺덇�
	private String pay_type;
	private int pay_price;
	private String pay_code;
	private String pay_status;
	private String status;
	private int adult_count;
	private int child_count;
	private String guest_name;
	private String guest_phone;
	private int room_count;
	private int room_no;
	
	public Reservation() {}

	public Reservation(int reservation_no, Account account_id, String check_in, String check_out, String askIn,
			String pay_type, int pay_price, String pay_code, String pay_status, String status, int adult_count,
			int child_count, String guest_name, String guest_phone, int room_count, int room_no) {
		super();
		this.reservation_no = reservation_no;
		this.account_id = account_id;
		this.check_in = check_in;
		this.check_out = check_out;
		this.askIn = askIn;
		this.pay_type = pay_type;
		this.pay_price = pay_price;
		this.pay_code = pay_code;
		this.pay_status = pay_status;
		this.status = status;
		this.adult_count = adult_count;
		this.child_count = child_count;
		this.guest_name = guest_name;
		this.guest_phone = guest_phone;
		this.room_count = room_count;
		this.room_no = room_no;
	}





	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

	public int getReservation_no() {
		return reservation_no;
	}

	public void setReservation_no(int reservation_no) {
		this.reservation_no = reservation_no;
	}

	public Account getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Account account_id) {
		this.account_id = account_id;
	}

	public String getCheck_in() {
		return check_in;
	}

	public void setCheck_in(String check_in) {
		this.check_in = check_in;
	}

	public String getCheck_out() {
		return check_out;
	}

	public void setCheck_out(String check_out) {
		this.check_out = check_out;
	}

	public String getAskIn() {
		return askIn;
	}

	public void setAskIn(String askIn) {
		this.askIn = askIn;
	}

	public String getPay_type() {
		return pay_type;
	}

	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}

	public int getPay_price() {
		return pay_price;
	}

	public void setPay_price(int pat_price) {
		this.pay_price = pat_price;
	}

	public String getPay_code() {
		return pay_code;
	}

	public void setPay_code(String pay_code) {
		this.pay_code = pay_code;
	}

	public String getPay_status() {
		return pay_status;
	}

	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getGuest_name() {
		return guest_name;
	}

	public void setGuest_name(String guest_name) {
		this.guest_name = guest_name;
	}

	public String getGuest_phone() {
		return guest_phone;
	}

	public void setGuest_phone(String guest_phone) {
		this.guest_phone = guest_phone;
	}

	public int getRoom_count() {
		return room_count;
	}

	public void setRoom_count(int room_count) {
		this.room_count = room_count;
	}

	@Override
	public String toString() {
		return "Reservation [reservation_no=" + reservation_no + ", account_id=" + account_id + ", check_in=" + check_in
				+ ", check_out=" + check_out + ", askIn=" + askIn + ", pay_type=" + pay_type + ", pay_price="
				+ pay_price + ", pay_code=" + pay_code + ", pay_status=" + pay_status + ", status=" + status
				+ ", adult_count=" + adult_count + ", child_count=" + child_count + ", guest_name=" + guest_name
				+ ", guest_phone=" + guest_phone + ", room_count=" + room_count + ", room_no=" + room_no + "]";
	}

	
	
	
}
