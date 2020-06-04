package thebabycareproject;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.SchedulerException;
import static thebabycareproject.Pop_upsController.*;

/**
 * Used in the section ' Pop-ups ' in the ' Reminder &amp; Notifications ' category.
 * Creates job2 with input time and date.
 * @author 2018331022(Owishi)
 */
public class Main2 {

    /**
     * Creates job1 with given time and date
     * @param args - not used
     * @throws Exception if the job can't be executed
     */
    public static void main(String[] args) throws Exception{
        try {
            JobDetail job2 = JobBuilder.newJob(Job2.class)
                    .withIdentity("job2", "group2").build();

            Trigger trigger2 = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger2", "group2")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 "+minute2+" "+hour2+" "+day2+" "+month2 +" ? "+ year2))//cron expression ->> second min hour dayOfTheMonth month dayOfTheWeek Year
                    //dayOfTheMonth and dayOfTheWeek cant't be added together
                    .build();
            Scheduler scheduler2 = new StdSchedulerFactory().getScheduler();
            scheduler2.start();
            scheduler2.scheduleJob(job2, trigger2);
            Thread.sleep(20000);
            //scheduler1.shutdown();

        } catch (SchedulerException e) {
        }
    }
}