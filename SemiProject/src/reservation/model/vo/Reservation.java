package reservation.model.vo;

import java.sql.Date;

public class Reservation {
	public int reservation_no;
	public String account_id;
	public String room_no;
	public Date check_in;
	public Date check_out;
	public String remark;
	public String pay_type;
	public String pay_price;
	public String pay_code;
	public String pay_status;
	public String status;
	public int adult_count;
	public int child_count;
	public String guest_name;
	public String guest_phone;
	public String name;
	public Reservation() {
		super();
	}

	public Reservation(int reservation_no, String account_id, String room_no, Date check_in, Date check_out,
			String remark, String pay_type, String pay_price, String pay_code, String pay_status, String status,
			int adult_count, int child_count, String guest_name, String guest_phone) {
		super();
		this.reservation_no = reservation_no;
		this.account_id = account_id;
		this.room_no = room_no;
		this.check_in = check_in;
		this.check_out = check_out;
		this.remark = remark;
		this.pay_type = pay_type;
		this.pay_price = pay_price;
		this.pay_code = pay_code;
		this.pay_status = pay_status;
		this.status = status;
		this.adult_count = adult_count;
		this.child_count = child_count;
		this.guest_name = guest_name;
		this.guest_phone = guest_phone;
	}

	
	public Reservation(int reservation_no, String account_id, String room_no, Date check_in, Date check_out,
			String remark, String pay_type, String pay_price, String pay_code, String pay_status, String status,
			int adult_count, int child_count, String guest_name, String guest_phone, String name) {
		super();
		this.reservation_no = reservation_no;
		this.account_id = account_id;
		this.room_no = room_no;
		this.check_in = check_in;
		this.check_out = check_out;
		this.remark = remark;
		this.pay_type = pay_type;
		this.pay_price = pay_price;
		this.pay_code = pay_code;
		this.pay_status = pay_status;
		this.status = status;
		this.adult_count = adult_count;
		this.child_count = child_count;
		this.guest_name = guest_name;
		this.guest_phone = guest_phone;
		this.name = name;
	}

	public int getReservation_no() {
		return reservation_no;
	}

	public void setReservation_no(int reservation_no) {
		this.reservation_no = reservation_no;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getRoom_no() {
		return room_no;
	}

	public void setRoom_no(String room_no) {
		this.room_no = room_no;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPay_type() {
		return pay_type;
	}

	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}

	public String getPay_price() {
		return pay_price;
	}

	public void setPay_price(String pay_price) {
		this.pay_price = pay_price;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Reservation [reservation_no=" + reservation_no + ", account_id=" + account_id + ", room_no=" + room_no
				+ ", check_in=" + check_in + ", check_out=" + check_out + ", remark=" + remark + ", pay_type="
				+ pay_type + ", pay_price=" + pay_price + ", pay_code=" + pay_code + ", pay_status=" + pay_status
				+ ", status=" + status + ", adult_count=" + adult_count + ", child_count=" + child_count
				+ ", guest_name=" + guest_name + ", guest_phone=" + guest_phone + ", name=" + name + "]";
	}



}
