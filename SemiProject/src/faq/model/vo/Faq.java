package faq.model.vo;

import java.sql.Date;

public class Faq {

//	FAQ_NO
//	ACCOUNT_ID
//	FAQ_TITLE
//	FAQ_CONTENT
//	FAQ_ANSWER
//	CREATE_DATE
//	MODIFY_DATE
//	STATUS
	private int faqNo;
	private String accountId;
	private String faqTitle;
	private String faqContent;
	private String faqAnswer;
	private Date createDate;
	private Date modifyDate;
	private String status;
	
	public Faq () {
		
	}
	
	
	


	public Faq(String accountId, String faqTitle, String faqContent, String faqAnswer) {
		super();
		this.accountId = accountId;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.faqAnswer = faqAnswer;
	}

	public Faq(int faqNo, String accountId, String faqTitle, String faqContent, String faqAnswer, Date createDate,
			Date modifyDate, String status) {
		super();
		this.faqNo = faqNo;
		this.accountId = accountId;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.faqAnswer = faqAnswer;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}

	public int getFaqNo() {
		return faqNo;
	}

	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getFaqTitle() {
		return faqTitle;
	}

	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}

	public String getFaqContent() {
		return faqContent;
	}

	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}

	public String getFaqAnswer() {
		return faqAnswer;
	}

	public void setFaqAnswer(String faqAnswer) {
		this.faqAnswer = faqAnswer;
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

	@Override
	public String toString() {
		return "Faq [faqNo=" + faqNo + ", accountId=" + accountId + ", faqTitle=" + faqTitle + ", faqContent="
				+ faqContent + ", faqAnswer=" + faqAnswer + ", createDate=" + createDate + ", modifyDate=" + modifyDate
				+ ", status=" + status + "]";
	}
	
	
}
