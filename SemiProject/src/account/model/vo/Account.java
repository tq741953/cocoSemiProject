package account.model.vo;

public class Account {
	private String accountId;
	private String password;
	private String name;
	private String email;
	private String phone;
	private int auth;
	private String status;
	private String bLicense;
	private int hotelId;
	private int emailAuth;
	
	/* ACCOUNT_ID	VARCHAR2(20 BYTE)
	PASSWORD	VARCHAR2(20 BYTE)
	NAME	VARCHAR2(20 BYTE)
	EMAIL	VARCHAR2(30 BYTE)
	PHONE	VARCHAR2(100 BYTE)
	AUTH	NUMBER
	STATUS	VARCHAR2(30 BYTE) */
	
	public Account() {}

	
	
	public Account(String accountId, String password, String name, String email, String phone, int auth, String status,
			String bLicense, int hotelId) {
		super();
		this.accountId = accountId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.auth = auth;
		this.status = status;
		this.bLicense = bLicense;
		this.hotelId = hotelId;
	}


	public Account(String accountId, String password, String name, String email, String phone, int auth, String status,
			 int emailAuth, String bLicense) {
		super();
		this.accountId = accountId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.auth = auth;
		this.status = status;
		this.emailAuth = emailAuth;
		this.bLicense = bLicense;
	}



	public Account(String accountId, String password, String name, String email, String phone, int auth, String status,
			String bLicense, int hotelId, int emailAuth) {
		super();
		this.accountId = accountId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.auth = auth;
		this.status = status;
		this.bLicense = bLicense;
		this.hotelId = hotelId;
		this.emailAuth = emailAuth;
	}






	public Account(String accountId, String password, String name, String email, String phone, int auth, String status, String bLicense) {
		super();
		this.accountId = accountId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.auth = auth;
		this.status = status;
		this.bLicense = bLicense;
	}
	
	public Account(String accountId, String password, String name, String email, String phone, String bLicense) {
		this.accountId = accountId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.bLicense = bLicense;
	}
	

	public Account(String accountId, String password, String name, String email, String phone) {
		this.accountId = accountId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	

	public Account(String accountId, String name, String email) {
		this.accountId = accountId;
		this.name = name;
		this.email = email;
	}
	


	public Account(String accountId, String name, String email, String phone) {
		super();
		this.accountId = accountId;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}



	public Account(String accountId) {
		this.accountId = accountId;
	}

	public Account(String accountId, String password) {
		this.accountId = accountId;
		this.password = password;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getbLicense() {
		return bLicense;
	}

	public void setbLicense(String bLicense) {
		this.bLicense = bLicense;
	}

	public int getEmailAuth() {
		return emailAuth;
	}



	public void setEmailAuth(int emailAuth) {
		this.emailAuth = emailAuth;
	}



	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", phone=" + phone + ", auth=" + auth + ", status=" + status + ", bLicense=" + bLicense + ", hotelId="
				+ hotelId + ", emailAuth=" + emailAuth + "]";
	}





	
	
}