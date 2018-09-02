package com.igogogo.api;

import java.util.HashMap;
import java.util.Map;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.igogogo.domain.ResultJson;
import com.igogogo.utils.PropertyUtil;
import com.igogogo.utils.StringUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "${server.api-path}/task")
@Api(value = "TaskApi", description = "任务相关API")
public class TaskApi {

	@Autowired
	private Scheduler scheduler;

	private final String taskTime = PropertyUtil.getProperty("taobaoke.properties", "tasktime");

	private Map<String, Object> jobMap = new HashMap<String, Object>();

	@ApiOperation(value = "task1Start")
	@RequestMapping(value = "/task1Start", method = RequestMethod.POST)
	public ResultJson task1Start(@RequestParam String jobname, @RequestParam String triggername,
			@RequestParam String groupname, @RequestParam String classname, @RequestParam String keywords) {
		Boolean flag = startJob(scheduler, jobname, triggername, groupname, classname, keywords);
		if (flag) {
			return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
					.setData(null);
		}
		return ResultJson.getInstance().setCode(StringUtils.FAIL_CODE).setMsg(StringUtils.FAIL_MSG).setData(null);
	}

	@ApiOperation(value = "task1Stop")
	@RequestMapping(value = "/task1Stop", method = RequestMethod.POST)
	public ResultJson task1Stop(@RequestParam String jobname, @RequestParam String triggername,
			@RequestParam String groupname, @RequestParam String classname) {
		Boolean flag = stopJob(scheduler, jobname, triggername, groupname, classname);
		if (flag) {
			return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
					.setData(null);
		}
		return ResultJson.getInstance().setCode(StringUtils.FAIL_CODE).setMsg(StringUtils.FAIL_MSG).setData(null);
	}

	private Boolean stopJob(Scheduler scheduler, String jobname, String triggername, String groupname,
			String classname) {
		System.out.println("停止定时任务...");
		Boolean flag = false;
		JobDetail jobDetail = (JobDetail) jobMap.get(jobname);
		if (jobDetail != null) {
			TriggerKey triggerKey = TriggerKey.triggerKey(triggername);
			if (triggerKey != null) {
				try {
					scheduler.pauseTrigger(triggerKey);// 停止触发器
					scheduler.unscheduleJob(triggerKey);// 移除触发器
					scheduler.deleteJob(jobDetail.getKey());// 删除任务
					flag = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		// JobDetail jobDetail = (JobDetail) jobMap.get(jobname);
		//
		// if (jobDetail != null) {
		// try {
		// scheduler.deleteJob(jobDetail.getKey());
		// flag = true;
		// } catch (SchedulerException e) {
		// e.printStackTrace();
		// }
		// }
		return flag;
	}

	private Boolean startJob(Scheduler scheduler, String jobname, String triggername, String groupname,
			String classname, String keywords) {

		Boolean flag = false;
		// 每3s执行一次
		// CronScheduleBuilder scheduleBuilder =
		// CronScheduleBuilder.cronSchedule("0/3 * * * * ?");
		// CronScheduleBuilder scheduleBuilder =
		// CronScheduleBuilder.cronSchedule("0 0/30 * * * ?");
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(taskTime);
		// 停止之前的任务
		stopJob(scheduler, jobname, triggername, groupname, classname);
		// 开始新任务
		JobDetail jobDetail = (JobDetail) jobMap.get(jobname);
		try {
			Class<?> obj = Class.forName("com.igogogo.task." + classname);
			@SuppressWarnings("unchecked")
			Class<? extends Job> jobClass = (Class<? extends Job>) obj;
			jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobname, groupname).build();
			jobDetail.getJobDataMap().put("keywords", keywords);
			jobMap.put(jobname, jobDetail);
			CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggername, groupname)
					.withSchedule(scheduleBuilder).build();
			scheduler.scheduleJob(jobDetail, cronTrigger);
			flag = true;
			System.out.println("开始定时任务...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// JobDetail jobDetail = (JobDetail) jobMap.get(jobname);
		// try {
		// if (jobDetail != null) {
		// scheduler.deleteJob(jobDetail.getKey());
		// } else {
		// Class<?> obj = Class.forName("com.igogogo.task." + classname);
		// @SuppressWarnings("unchecked")
		// Class<? extends Job> jobClass = (Class<? extends Job>) obj;
		// jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobname,
		// groupname).build();
		// jobDetail.getJobDataMap().put("keywords", keywords);
		// jobMap.put(jobname, jobDetail);
		// }
		// CronTrigger cronTrigger =
		// TriggerBuilder.newTrigger().withIdentity(triggername, groupname)
		// .withSchedule(scheduleBuilder).build();
		// scheduler.scheduleJob(jobDetail, cronTrigger);
		// flag = true;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		return flag;
	}

}
