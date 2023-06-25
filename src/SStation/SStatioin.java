package SStation;

import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.*;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class SStatioin {
        public static void main(String[] args) {
            // Set up email properties
            String host = "smtp.gmail.com";
            String port = "587";
            String username = "your_email_address@gmail.com";
            String password = "your_email_password";
            String recipient = "your_email_address@gmail.com";

            // Get current ISS position
            ISSLocation location = ISSLocation.getCurrentLocation();
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();

            // Check if ISS is passing over current location
            ISSPassTime passTime = ISSPassTime.getNextPass(latitude, longitude);
            if (passTime != null) {
                // Set up email message
                String subject = "ISS is passing over your location!";
                String message = "The ISS is passing over your location at " + passTime.getDateTime() + " for " + passTime.getDuration() + " seconds.";

                // Send email
                sendEmail(host, port, username, password, recipient, subject, message);
                System.out.println("Email notification sent.");
            } else {
                System.out.println("ISS is not passing over your location at this time.");
            }
        }

        private static void sendEmail(String host, String port, final String username, final String password, String recipient, String subject, String message) {
            // Set email properties
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", port);

            // Set up email session with authentication
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            try {
                // Set up email message
                Message emailMessage = new MimeMessage(session);
                emailMessage.setFrom(new InternetAddress(username));
                emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
                emailMessage.setSubject(subject);
                emailMessage.setText(message);

                // Send email
                Transport.send(emailMessage);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
