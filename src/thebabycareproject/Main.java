package thebabycareproject;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.SchedulerException;
import static thebabycareproject.VaccineReminderController.day;
import static thebabycareproject.VaccineReminderController.hour;
import static thebabycareproject.VaccineReminderController.minute;
import static thebabycareproject.VaccineReminderController.year;
import static thebabycareproject.VaccineReminderController.month;
public class Main {

    public static void main(String[] args) throws Exception{
        try {
            JobDetail job1 = JobBuilder.newJob(Job1.class)
                    .withIdentity("job1", "group1").build();

            Trigger trigger1 = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger1", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 "+minute+" "+hour+" "+day+" "+month +" ? "+ year))//cron expression ->> second min hour dayOfTheMonth month dayOfTheWeek Year
                    //dayOfTheMonth and dayOfTheWeek cant't be added together
                    .build();
            Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
            scheduler1.start();
            scheduler1.scheduleJob(job1, trigger1);
            Thread.sleep(20000);
            //scheduler1.shutdown();

        } catch (InterruptedException | SchedulerException e) {
        }
    }

}