package hotel.model.vo;

public class RoomFile {
	private int file_id;
	private int room_no;
	private String file_name;
	private String file_rename;
	private String file_url;
	
	public RoomFile() {}

	public RoomFile(int file_id, int room_no, String file_name, String file_rename, String file_url) {
		super();
		this.file_id = file_id;
		this.room_no = room_no;
		this.file_name = file_name;
		this.file_rename = file_rename;
		this.file_url = file_url;
	}

	public int getFile_id() {
		return file_id;
	}

	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}

	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_rename() {
		return file_rename;
	}

	public void setFile_rename(String file_rename) {
		this.file_rename = file_rename;
	}

	public String getFile_url() {
		return file_url;
	}

	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}

	@Override
	public String toString() {
		return "RoomFile [file_id=" + file_id + ", room_no=" + room_no + ", file_name=" + file_name + ", file_rename="
				+ file_rename + ", file_url=" + file_url + "]";
	}
	
	
}
