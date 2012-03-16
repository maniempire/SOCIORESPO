package com.pid.util;

import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail implements Db2ServerInfo {
	public String username = null;
	public String password = null;
	public String validateMail(String uFname, String userEmailId, String userSupvEmailId, String daysRequired, String startDate, String endDate, String reason) throws MessagingException{
		username = MAIL;
		password = MAILPASS;
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

		SecurityManager security = System.getSecurityManager();

		Authenticator auth = new SMTPAuthenticator1();

		//Session mailSession = Session.getDefaultInstance(props, auth);
		Session mailSession = Session.getInstance(props);
		
		mailSession.setDebug(true);
		// Define message
		MimeMessage message = new MimeMessage(mailSession);

		// Set the Mail From_address
		//message.setFrom(new InternetAddress("smartadmin@visiontss.com"));
		message.setFrom(new InternetAddress(userEmailId));
		// Set the Mail To_address
		//message.addRecipient(Message.RecipientType.TO,new InternetAddress("smartadmin@visiontss.com"));
		message.addRecipient(Message.RecipientType.TO,new InternetAddress(userSupvEmailId));
		
		
		message.setSubject("REG : Leave request send by  " +uFname);

		 // Set message content
		//message.setText("HI");
		
		String userSupvEmail[] = userSupvEmailId.split("@");
		String supvName = userSupvEmail[0];
		StringBuffer mesg = new StringBuffer();
		mesg.append("<html>" 
				+"<table border=0 cellspacing=5 cellpadding=5>"
					+"<tr><td width='30%'>Dear " +supvName +"</td></tr>"
					+"<tr><td0></td></tr>"
					+"<tr><td width='10%'></td><td width='90%'>" +uFname +" is requesting a leave. Details are mentioned below</td></tr>"
					+"<tr></tr></table>"
					+"<table width='30%' border=0 cellspacing=5 cellpadding=5>"
					+"<tr><td>No. of Days Required</td><td>:</td><td>" +daysRequired +"</td></tr>"
					+"<tr><td>Start Date</td><td>:</td><td>" +startDate +"</td></tr>"
					+"<tr><td>End Date</td><td>:</td><td>" +endDate +"</td></tr>"
					+"<tr><td>Reason</td><td>:</td><td>" +reason +"</td></tr>"
					+"<tr></tr>"
					+"<tr><td width='100%'>Regards,<br>" +" " +uFname +"</td></tr>"
				+"</table></html>");

		message.setContent(mesg.toString(), "text/html");
		
		Transport tr = mailSession.getTransport("smtp");
		//Transport transport = mailSession.getTransport();

		try{			
			tr.connect("smtp.gmail.com", username, password);
			
	        //Send the message
	        //tr.send(message);
			tr.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
	        tr.close();
			//transport.connect();
		}catch (AuthenticationFailedException ex){
			ex.printStackTrace();
		}catch (Exception ex){
			return "Failure";
		}
		return "Success";
	}
	private class SMTPAuthenticator1 extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	}	
}
