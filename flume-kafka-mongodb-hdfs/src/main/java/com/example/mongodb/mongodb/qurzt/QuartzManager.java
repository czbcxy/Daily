package com.ledong.p2c.webapps.wwwp.weblogic.customer;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.ledong.p2c.platform.base.api.ActivityFacade;
import com.ledong.p2c.webapps.wwwp.weblogic.customer.activityQuartz.ActivityQuartz;
import com.ledong.platform.app.utils.DateUtil;

/**
 * @Description: 定时任务管理类
 * 
 * @ClassName: QuartzManager
 * @Copyright: Copyright (c) 2014
 * 
 * @author Comsys-LZP
 * @date 2014-6-26 下午03:15:52
 * @version V2.0
 */
public class QuartzManager {
	private static SchedulerFactory gSchedulerFactory = new StdSchedulerFactory();
	private static String JOB_GROUP_NAME = "EXTJWEB_JOBGROUP_NAME";
	private static String TRIGGER_GROUP_NAME = "EXTJWEB_TRIGGERGROUP_NAME";

	/**
	 * @Description: 添加一个定时任务，使用默认的任务组名，触发器名，触发器组名
	 * 
	 * @param jobName
	 *            任务名
	 * @param cls
	 *            任务
	 * @param time
	 *            时间设置，参考quartz说明文档
	 * 
	 * @Title: QuartzManager.java
	 * @Copyright: Copyright (c) 2014
	 * 
	 * @author Comsys-LZP
	 * @date 2014-6-26 下午03:47:44
	 * @version V2.0
	 */
	@SuppressWarnings("unchecked")
	public static Date addJob(String jobName, Class cls, String time, String messageId, String status) {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			JobDetail jobDetail = new JobDetail(jobName, JOB_GROUP_NAME, cls);// 任务名，任务组，任务执行类
			jobDetail.getJobDataMap().put("messageId", messageId);
			jobDetail.getJobDataMap().put("status", status);
			// 触发器
			CronTrigger trigger = new CronTrigger(jobName, TRIGGER_GROUP_NAME);// 触发器名,触发器组
			trigger.setCronExpression(time);// 触发器时间设定
			Date date = sched.scheduleJob(jobDetail, trigger);
			// 启动
			if (!sched.isShutdown()) {
				sched.start();
			}

			return date;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static Date addliveStatusJob(String jobName, Class cls, String time, String liveId, String cid,
			String liveTitle) {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			JobDetail jobDetail = new JobDetail(jobName, JOB_GROUP_NAME, cls);// 任务名，任务组，任务执行类
			jobDetail.getJobDataMap().put("liveId", liveId);
			jobDetail.getJobDataMap().put("cid", cid);
			jobDetail.getJobDataMap().put("liveTitle", liveTitle);
			// 触发器
			CronTrigger trigger = new CronTrigger(jobName, TRIGGER_GROUP_NAME);// 触发器名,触发器组
			trigger.setCronExpression(time);// 触发器时间设定
			Date date = sched.scheduleJob(jobDetail, trigger);
			// 启动
			if (!sched.isShutdown()) {
				sched.start();
			}

			return date;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description: 添加一个定时任务
	 * 
	 * @param jobName
	 *            任务名
	 * @param jobGroupName
	 *            任务组名
	 * @param triggerName
	 *            触发器名
	 * @param triggerGroupName
	 *            触发器组名
	 * @param jobClass
	 *            任务
	 * @param time
	 *            时间设置，参考quartz说明文档
	 * 
	 * @Title: QuartzManager.java
	 * @Copyright: Copyright (c) 2014
	 * 
	 * @author Comsys-LZP
	 * @date 2014-6-26 下午03:48:15
	 * @version V2.0
	 */
	@SuppressWarnings("unchecked")
	public static Date addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName,
			Class jobClass, String time) {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			JobDetail jobDetail = new JobDetail(jobName, jobGroupName, jobClass);// 任务名，任务组，任务执行类
			// 触发器
			CronTrigger trigger = new CronTrigger(triggerName, triggerGroupName);// 触发器名,触发器组
			trigger.setCronExpression(time);// 触发器时间设定
			Date date = sched.scheduleJob(jobDetail, trigger);
			// 启动
			if (!sched.isShutdown()) {
				sched.start();
			}
			return date;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static Date addSetRedPackage(String jobName, Class cls, String time) {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			JobDetail jobDetail = new JobDetail(jobName, JOB_GROUP_NAME, cls);// 任务名，任务组，任务执行类
			// 触发器
			CronTrigger trigger = new CronTrigger(jobName, TRIGGER_GROUP_NAME);// 触发器名,触发器组
			trigger.setCronExpression(time);// 触发器时间设定
			Date date = sched.scheduleJob(jobDetail, trigger);
			// 启动
			if (!sched.isShutdown()) {
				sched.start();
			}
			return date;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static Date addJobForLive(String jobName, Class cls, String time, Map<String, String> params) {
		String cid = params.get("cid").toString();
		String beginDate = params.get("beginDate").toString();
		String endDate = params.get("endDate").toString();
		String liveTitle = params.get("liveTitle").toString();
		String userId = params.get("userId").toString();
		String liveId = params.get("liveId").toString();

		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			JobDetail jobDetail = new JobDetail(jobName, JOB_GROUP_NAME, cls);// 任务名，任务组，任务执行类
			jobDetail.getJobDataMap().put("cid", cid);
			jobDetail.getJobDataMap().put("beginDate", beginDate);
			jobDetail.getJobDataMap().put("endDate", endDate);
			jobDetail.getJobDataMap().put("liveTitle", liveTitle);
			jobDetail.getJobDataMap().put("userId", userId);
			jobDetail.getJobDataMap().put("liveId", liveId);
			// 触发器
			CronTrigger trigger = new CronTrigger(jobName, TRIGGER_GROUP_NAME);// 触发器名,触发器组
			trigger.setCronExpression(time);// 触发器时间设定
			Date date = sched.scheduleJob(jobDetail, trigger);
			// 启动
			if (!sched.isShutdown()) {
				sched.start();
			}
			return date;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description: 修改一个任务的触发时间(使用默认的任务组名，触发器名，触发器组名)
	 * 
	 * @param jobName
	 * @param time
	 * 
	 * @Title: QuartzManager.java
	 * @Copyright: Copyright (c) 2014
	 * 
	 * @author Comsys-LZP
	 * @date 2014-6-26 下午03:49:21
	 * @version V2.0
	 */
	@SuppressWarnings("unchecked")
	public static Date modifyJobTime(String jobName, Class cls, String time, String messageId, String status) {
		try {
			Date date = null;
			Scheduler sched = gSchedulerFactory.getScheduler();
			CronTrigger trigger = (CronTrigger) sched.getTrigger(jobName, TRIGGER_GROUP_NAME);
			if (trigger == null) {
				date = addJob(jobName, cls, time, messageId, status);
			} else {
				String oldTime = trigger.getCronExpression();
				if (!oldTime.equalsIgnoreCase(time)) {
					JobDetail jobDetail = sched.getJobDetail(jobName, JOB_GROUP_NAME);
					Class objJobClass = jobDetail.getJobClass();
					if (objJobClass == null) {
						date = addJob(jobName, cls, time, messageId, status);
					} else {
						removeJob(jobName);
						date = addJob(jobName, cls, time, messageId, status);
					}
				}
			}

			return date;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description: 修改一个任务的触发时间
	 * 
	 * @param triggerName
	 * @param triggerGroupName
	 * @param time
	 * 
	 * @Title: QuartzManager.java
	 * @Copyright: Copyright (c) 2014
	 * 
	 * @author Comsys-LZP
	 * @date 2014-6-26 下午03:49:37
	 * @version V2.0
	 */
	public static Date modifyJobTime(String triggerName, String triggerGroupName, String time) {
		try {
			Date date = DateUtil.getStringToDate(time);
			Scheduler sched = gSchedulerFactory.getScheduler();
			CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerName, triggerGroupName);
			if (trigger == null) {
				return null;
			}
			String oldTime = trigger.getCronExpression();
			if (!oldTime.equalsIgnoreCase(time)) {
				CronTrigger ct = (CronTrigger) trigger;
				// 修改时间
				ct.setCronExpression(time);
				// 重启触发器
				sched.resumeTrigger(triggerName, triggerGroupName);
			}
			return date;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description: 移除一个任务(使用默认的任务组名，触发器名，触发器组名)
	 * 
	 * @param jobName
	 * 
	 * @Title: QuartzManager.java
	 * @Copyright: Copyright (c) 2014
	 * 
	 * @author Comsys-LZP
	 * @date 2014-6-26 下午03:49:51
	 * @version V2.0
	 */
	public static void removeJob(String jobName) {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();

			CronTrigger trigger = (CronTrigger) sched.getTrigger(jobName, TRIGGER_GROUP_NAME);
			if (trigger != null) {
				sched.pauseTrigger(jobName, TRIGGER_GROUP_NAME);// 停止触发器
				sched.unscheduleJob(jobName, TRIGGER_GROUP_NAME);// 移除触发器
				sched.deleteJob(jobName, JOB_GROUP_NAME);// 删除任务
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description: 移除一个任务
	 * 
	 * @param jobName
	 * @param jobGroupName
	 * @param triggerName
	 * @param triggerGroupName
	 * 
	 * @Title: QuartzManager.java
	 * @Copyright: Copyright (c) 2014
	 * 
	 * @author Comsys-LZP
	 * @date 2014-6-26 下午03:50:01
	 * @version V2.0
	 */
	public static void removeJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName) {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			sched.pauseTrigger(triggerName, triggerGroupName);// 停止触发器
			sched.unscheduleJob(triggerName, triggerGroupName);// 移除触发器
			sched.deleteJob(jobName, jobGroupName);// 删除任务
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description:启动所有定时任务
	 * 
	 * 
	 * @Title: QuartzManager.java
	 * @Copyright: Copyright (c) 2014
	 * 
	 * @author Comsys-LZP
	 * @date 2014-6-26 下午03:50:18
	 * @version V2.0
	 */
	public static void startJobs() {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			sched.start();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description:关闭所有定时任务
	 * 
	 * 
	 * @Title: QuartzManager.java
	 * @Copyright: Copyright (c) 2014
	 * 
	 * @author Comsys-LZP
	 * @date 2014-6-26 下午03:50:26
	 * @version V2.0
	 */
	public static void shutdownJobs() {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			if (!sched.isShutdown()) {
				sched.shutdown();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @param jobName
	 * @param cls
	 * @param time
	 * @param redId
	 * @param flag
	 *            0:发布 1关闭
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Date changeRedPackageJob(String jobName, Class cls, String time, String redId, String flag) {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			JobDetail jobDetail = new JobDetail(jobName, JOB_GROUP_NAME, cls);// 任务名，任务组，任务执行类
			jobDetail.getJobDataMap().put("redId", redId);
			jobDetail.getJobDataMap().put("flag", flag);
			// 触发器
			CronTrigger trigger = new CronTrigger(jobName, TRIGGER_GROUP_NAME);// 触发器名,触发器组
			trigger.setCronExpression(time);// 触发器时间设定
			Date date = sched.scheduleJob(jobDetail, trigger);
			// 启动
			if (!sched.isShutdown()) {
				sched.start();
			}
			return date;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
//	
	public static Date addActivityRedPackageJob(String jobName, Class<ActivityQuartz> cls, String time, String activityId) {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			
			JobDetail jobDetail = new JobDetail(jobName, JOB_GROUP_NAME, cls);// 任务名，任务组，任务执行类
			jobDetail.getJobDataMap().put("activityId", activityId);
			// 触发器
			CronTrigger trigger = new CronTrigger(jobName, TRIGGER_GROUP_NAME);// 触发器名,触发器组
//			SimpleTrigger	trigger = new SimpleTrigger("simple","simplegroup");
//			trigger.setStartTime(new Date());
//			trigger.setRepeatInterval(1000);
//			trigger.setRepeatCount(1);
			trigger.setCronExpression(time);// 触发器时间设定
			Date date = sched.scheduleJob(jobDetail, trigger);
			// 启动
			if (!sched.isShutdown()) {
				sched.start();
			}
			return date;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 活动begin
	@SuppressWarnings("unchecked")
	public static Date addActivityStatusJob(String jobName, Class cls, String time, String activityId,
			String activityTitle) {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			JobDetail jobDetail = new JobDetail(jobName, JOB_GROUP_NAME, cls);// 任务名，任务组，任务执行类
			jobDetail.getJobDataMap().put("activityId", activityId);
			jobDetail.getJobDataMap().put("activityTitle", activityTitle);
			// 触发器
			CronTrigger trigger = new CronTrigger(jobName, TRIGGER_GROUP_NAME);// 触发器名,触发器组
			trigger.setCronExpression(time);// 触发器时间设定
			Date date = sched.scheduleJob(jobDetail, trigger);
			// 启动
			if (!sched.isShutdown()) {
				sched.start();
			}

			return date;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}