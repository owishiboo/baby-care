package thebabycareproject;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import static thebabycareproject.SigninController.flag;
import static thebabycareproject.SigninController.varification_code;

public class EmailUtil{
    public static TimerTask sendMail(String recepient) throws Exception {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        String myAccountEmail = "carebaby08@gmail.com";
        String password = "asdfghjkl;'";
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        Message message = prepareMessage(session, myAccountEmail, recepient);
        Transport.send(message);
        System.out.println("Message sent successfully");
        return null;
    }
    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Baby Care");
            String htmlCode_for_vaccine = "<h1> TAKE CARE OF YOU AND YOUR CHILD! </h1> <br/> <h2><b>It's time to get vaccine for your child. Hope you get it done. </b></h2>";
            String htmlCode_for_verification = "<h1> VERIFICATION CODE </h1> <br/> <h2><b>Welcome to baby care. Your code is "+varification_code+". Please enter it to the required field.</b></h2>";
            if(flag==5){
                flag=0;
                message.setContent(htmlCode_for_verification, "text/html");
                return message;
            }
            else {
                message.setContent(htmlCode_for_vaccine, "text/html");
                return message;
            }
        } catch (MessagingException ex) {
            Logger.getLogger(EmailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    static void sendMail(Type String) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
