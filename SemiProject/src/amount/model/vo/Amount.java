package amount.model.vo;

public class Amount {

	private int File_id;
	private String Hotel_id;
	private String File_name;
	private String File_rename;
	private String File_url;
	public Amount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Amount(int file_id, String hotel_id, String file_name, String file_rename, String file_url) {
		super();
		File_id = file_id;
		Hotel_id = hotel_id;
		File_name = file_name;
		File_rename = file_rename;
		File_url = file_url;
	}
	public int getFile_id() {
		return File_id;
	}
	public void setFile_id(int file_id) {
		File_id = file_id;
	}
	public String getHotel_id() {
		return Hotel_id;
	}
	public void setHotel_id(String hotel_id) {
		Hotel_id = hotel_id;
	}
	public String getFile_name() {
		return File_name;
	}
	public void setFile_name(String file_name) {
		File_name = file_name;
	}
	public String getFile_rename() {
		return File_rename;
	}
	public void setFile_rename(String file_rename) {
		File_rename = file_rename;
	}
	public String getFile_url() {
		return File_url;
	}
	public void setFile_url(String file_url) {
		File_url = file_url;
	}
	@Override
	public String toString() {
		return "Amount [File_id=" + File_id + ", Hotel_id=" + Hotel_id + ", File_name=" + File_name + ", File_rename="
				+ File_rename + ", File_url=" + File_url + "]";
	}
	
}
