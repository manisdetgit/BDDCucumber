package utils;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.io.File;

public class SendEmail {

    public static void sendReport(String reportPath, String screenshotPath, String subject, String bodyText) {
        String fromEmail = "manisankarasrinivasu.dusanapudi@publicissapient.com";  // Your email address
        String toEmail = "manisankarasrinivasu.dusanapudi@publicissapient.com";    // Recipient email address
        String smtpServer = "smtp.office365.com";       // SMTP server (e.g., smtp.gmail.com)
        String smtpPort = "587";                      // SMTP port
        String username = "manisankarasrinivasu.dusanapudi@publicissapient.com";   // Email username
        String password = "Msks@jan30";      // Email password

        try {
            // Set up the email properties
            Properties properties = new Properties();
            properties.put("mail.smtp.host", smtpServer);
            properties.put("mail.smtp.port", smtpPort);
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            // Create the email session
            Session session = Session.getInstance(properties, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            // Create the email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(bodyText);

            // Create a multipart message for sending multiple parts (report + screenshot)
            Multipart multipart = new MimeMultipart();

            // Attach the report file
            MimeBodyPart reportAttachment = new MimeBodyPart();
            reportAttachment.attachFile(reportPath);
            multipart.addBodyPart(reportAttachment);

            // Attach the screenshot if it exists
            if (screenshotPath != null && !screenshotPath.isEmpty()) {
                MimeBodyPart screenshotAttachment = new MimeBodyPart();
                screenshotAttachment.attachFile(screenshotPath);
                multipart.addBodyPart(screenshotAttachment);
            }

            // Set the content of the email to be the multipart (email + attachments)
            message.setContent(multipart);

            // Send the email
            Transport.send(message);
            System.out.println("Email sent successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error sending email: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Example call to send email with a report and a screenshot (you can call this method after tests)
        sendReport("target/cucumber.html", "image/png.png", "Test Report", "Please find the test report and screenshot attached.");
    }
}
