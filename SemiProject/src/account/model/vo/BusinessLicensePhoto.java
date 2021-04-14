package account.model.vo;

public class BusinessLicensePhoto {
	private int fileId;
	private String accountId;
	private String fileName;
	private String fileRename;
	private String fileUrl;
	
	public BusinessLicensePhoto() {}

	public BusinessLicensePhoto(int fileId, String accountId, String fileName, String fileRename, String fileUrl) {
		this.fileId = fileId;
		this.accountId = accountId;
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

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
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
		return "BusinessLicensePhoto [fileId=" + fileId + ", accountId=" + accountId + ", fileName=" + fileName
				+ ", fileRename=" + fileRename + ", fileUrl=" + fileUrl + "]";
	}

	
	
	
}
