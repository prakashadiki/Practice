package practice;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendHTMLEmail {

	public static void main(String[] args) {
	      // Recipient's email ID needs to be mentioned.
	      String to = "";

	      // Sender's email ID needs to be mentioned
	      String from = "";
	      final String username = "";
	      final String password = "";

	      Properties props = new Properties();
	      props.put("mail.smtp.host", "smtp.gmail.com");
	      props.put("mail.smtp.socketFactory.port", "465");
	      props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.port", "465");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
	            }
		});

	      try {
	            // Create a default MimeMessage object.
	            Message message = new MimeMessage(session);

	            // Set From: header field of the header.
	            message.setFrom(new InternetAddress(from));

	            // Set To: header field of the header.
	            message.setRecipients(Message.RecipientType.TO,
	              InternetAddress.parse(to));

	            // Set Subject: header field
	            message.setSubject("Testing Subject");

	            // Send the actual HTML message, as big as you like
	            message.setContent(
	            		"<h1>This is actual message embedded in HTML tags</h1>",
	            		"text/html");

	            // Send message
	            Transport.send(message);

	            System.out.println("Sent message successfully....");

	      } catch (MessagingException e) {
	    	  e.printStackTrace();
	    	  throw new RuntimeException(e);
	      }
	   }
}
