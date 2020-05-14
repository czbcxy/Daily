package com.ledong.p2c.webapps.wwwp.weblogic.customer.activityQuartz;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import com.ledong.p2c.platform.base.api.ActivityFacade;
import com.ledong.p2c.webapps.wwwp.weblogic.customer.QuartzManager;

@Component
public class ActivityQuartz implements Job {
	private static Logger logger = Logger.getLogger(ActivityQuartz.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			JobDetail detail = context.getJobDetail();
			String name = detail.getFullName();
			JobDataMap jobDataMap = detail.getJobDataMap();
			String activityId = (String) jobDataMap.get("activityId");
			
			
			ActivityFacade activityFacade = (ActivityFacade) ApplictionHelper.getBean("activityFacade");
			
			activityFacade.updateActivityStratById(activityId);
			QuartzManager.removeJob(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("开启活动任务失败。。。。。");
			e.printStackTrace();
		}
		
	}
	
	
	


}
