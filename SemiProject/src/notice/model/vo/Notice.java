package notice.model.vo;

import java.util.Date;

public class Notice {
	private int noticeNo;
	private String accountId;
	private String noticeTitle;
	private String noticeContent;
	private Date createDate;
	private Date modifyDate;
	private String status;
	private int nCount;
	private String name;

	/*
	 * NOTICE_NO VARCHAR2(20 BYTE) ACCOUNT_ID VARCHAR2(20 BYTE) NOTICE_TITLE
	 * VARCHAR2(300 BYTE) NOTICE_CONTENT VARCHAR2(4000 BYTE) CREATE_DATE DATE
	 * MODIFY_DATE DATE STATUS VARCHAR2(20 BYTE)
	 */
	public Notice() {
		super();
	}

	public Notice(int noticeNo, String accountId, String noticeTitle, String noticeContent, Date createDate,
			Date modifyDate, String status, int nCount) {
		super();
		this.noticeNo = noticeNo;
		this.accountId = accountId;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.status = status;
		this.nCount = nCount;
	}

	public Notice(int noticeNo, String accountId, String noticeTitle, String noticeContent, Date createDate,
			Date modifyDate, String status, int nCount, String name) {
		super();
		this.noticeNo = noticeNo;
		this.accountId = accountId;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.status = status;
		this.nCount = nCount;
		this.name = name;
	}

	public Notice(String noticeTitle, String noticeContent,String accountId) {
		super();
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.accountId = accountId;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getnCount() {
		return nCount;
	}

	public void setnCount(int nCount) {
		this.nCount = nCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", accountId=" + accountId + ", noticeTitle=" + noticeTitle
				+ ", noticeContent=" + noticeContent + ", createDate=" + createDate + ", modifyDate=" + modifyDate
				+ ", status=" + status + ", nCount=" + nCount + ", name=" + name + "]";
	}




}
