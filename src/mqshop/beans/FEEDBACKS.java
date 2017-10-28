package mqshop.beans;

import java.sql.Date;

public class FEEDBACKS {
	public int feedbackID;
	public String namefb;
	public String emailfb;
	public String contentfb;
	public Date createddate;
	
	public FEEDBACKS() {
	}
	
	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
	}
	public int getFeedbackID() {
		return feedbackID;
	}
	public void setNamefb(String namefb) {
		this.namefb = namefb;
	}
	public String getNamefb() {
		return namefb;
	}
	public void setEmailfb(String emailfb) {
		this.emailfb = emailfb;
	}
	public String getEmailfb() {
		return emailfb;
	}
	public void setContentfb(String contentfb) {
		this.contentfb = contentfb;
	}
	public String getContentfb() {
		return contentfb;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public Date getCreateddate() {
		return createddate;
	}

}
