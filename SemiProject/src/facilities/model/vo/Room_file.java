package facilities.model.vo;

public class Room_file {
		private int File_id;
		private int Room_no;
		private String File_name;
		private String File_rename;
		private String File_url;
		
		
		public Room_file() {
			super();
		}


		public Room_file(int file_id, int room_no, String file_name, String file_rename, String file_url) {
			super();
			File_id = file_id;
			Room_no = room_no;
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


		public int getRoom_no() {
			return Room_no;
		}


		public void setRoom_no(int room_no) {
			Room_no = room_no;
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
			return "Room_file [File_id=" + File_id + ", Room_no=" + Room_no + ", File_name=" + File_name
					+ ", File_rename=" + File_rename + ", File_url=" + File_url + "]";
		}

}
