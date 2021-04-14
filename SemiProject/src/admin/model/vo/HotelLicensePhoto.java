package admin.model.vo;

public class HotelLicensePhoto {
	private int fileId;
	private int hotelId;
	private String fileName;
	private String fileRename;
	private String fileUrl;
	
	public HotelLicensePhoto() {
		super();
	}
	public HotelLicensePhoto(int fileId, int hotelId, String fileName, String fileRename, String fileUrl) {
		super();
		this.fileId = fileId;
		this.hotelId = hotelId;
		this.fileName = fileName;
		this.fileRename = fileRename;
		this.fileUrl = fileUrl;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileRename() {
		return fileRename;
	}
	public void setFileRename(String fileRename) {
		this.fileRename = fileRename;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	@Override
	public String toString() {
		return "HotelLicensePhoto [fileId=" + fileId + ", hotelId=" + hotelId + ", fileName=" + fileName
				+ ", fileRename=" + fileRename + ", fileUrl=" + fileUrl + "]";
	}
	
}
