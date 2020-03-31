package thebabycareproject;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.*;
import static thebabycareproject.VaccineReminderController.email;


public class Job1 implements Job{

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            System.out.println("Job1 --->>> Time is " + new Date());
            
            EmailUtil.sendMail(email);
        } catch (Exception ex) {
            Logger.getLogger(Job1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}