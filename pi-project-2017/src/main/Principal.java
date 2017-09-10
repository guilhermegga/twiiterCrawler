package main;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import scheduler.CustomJob;


public class Principal {

	public static Scheduler scheduler;
	
	public static void main(String[] args) {

		try {
			scheduler = StdSchedulerFactory.getDefaultScheduler();

//			 define qual classe está o job que será execudado
			JobDetail job = newJob(CustomJob.class)
					.withIdentity("job1", "group1")
					.build();
			
			//trigger que será executado a cada 15 min
			Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startNow()
//					.withSchedule(CronScheduleBuilder.cronSchedule("0 0 8am ? * MON-FRI"))
					.withSchedule(CronScheduleBuilder.cronSchedule("0 0/5 * * * ?"))
					.build();

			// chama o job usando um trigger
			scheduler.scheduleJob(job, trigger);

			// inicia o scheduler
			scheduler.start();

		} catch (Exception e) {
			System.out.println("\n\nErro ao tentar iniciar Scheduler .\n\n");
			e.printStackTrace();
		}
	}

}
