package thebabycareproject;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.*;

/**
 * Used in the section ' Vaccine Reminder ' in the ' Reminder &amp; Notifications ' category.
 * Creates cron job to send mails.
 * @author 201833102(Owishi)
 */
public class Job1 implements Job{

    /**
     * Executes created job for vaccine reminder
     * @param context used for override
     */
    @Override
    public void execute(JobExecutionContext context){
        try {
            System.out.println("Job1 --->>> Time is " + new Date());
            EmailUtil.sendMail(LoginPageController.email_txt);
        } catch (Exception ex) {
            Logger.getLogger(Job1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}