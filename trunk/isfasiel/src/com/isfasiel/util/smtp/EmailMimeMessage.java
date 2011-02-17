package com.isfasiel.util.smtp;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @Class Name : EmailMimeMessage.java
 * @Description : 
 * @Modification Information
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2011. 1. 28.	배병선
 * @author 배병선
 */
public class EmailMimeMessage extends MimeMessage {
	
	
	/**
	 * The vale stored in the Message ID header tag for the message.
	 */
	protected String messageId = "";
	
	/**
	 * Create a new EmailMimeMessage object.
	 * @param session
	 */
	public EmailMimeMessage(javax.mail.Session session) {
		super(session);
	}
	
	public void setMessageId(String p_value) {
		messageId = p_value;
	}
	
	 /**
     * Calls the super.updateHeaders() method, and also ensures 
     * that the Message-ID header tag
     * gets set if the setMessageID method was called.
     *
     * @throws MessagingException If an error occurs.
     */
	@Override
	protected void updateHeaders() throws MessagingException {
		super.updateHeaders();
		
		if( messageId != null) {
			if( !messageId.equals("") ) {
				setHeader("Message-ID", messageId);
			}
		}
	}
}