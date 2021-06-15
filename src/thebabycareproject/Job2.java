package thebabycareproject;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.*;

/**
 * Used in the section ' Pop-ups ' in the ' Reminder &amp; Notifications ' category.
 * Creates cron job to send mails.
 * @author 2018331022(Owishi)
 */
public class Job2 implements Job{

    
    /**
     * Executes created job for for pop-ups 
     * @param context used for override
     */
    @Override
    public void execute(JobExecutionContext context) {
        try {
            System.out.println("Job2 --->>> Time is " + new Date());
            EmailUtil.sendMail(LoginPageController.email_txt);
        } catch (Exception ex) {
            Logger.getLogger(Job1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}