package com.test.websocket.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.websocket.message.ResponseMessage;
import com.test.websocket.service.WebsocketService;

/**
* @author 蔡钧 E-mail: caijun-d@dfl.com.cn
* @version 创建时间： Apr 3, 2018 10:54:01 AM
* 
*/
// 任务应该存放在队列中，方便管理和控制
// 以下schedule只为测试
@Component
public class TaskScheduler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskScheduler.class);
	
	@Autowired
	private WebsocketService service;

//	@Scheduled(fixedDelay= 10 * 1000)
	public void send2All() {
		LOGGER.info("[Scheduler] start~~~~~");
		service.sendMsg(new ResponseMessage("[Message from scheduler] 亲亲，订单状态改变了哦～～"));
		LOGGER.info("[Scheduler] end~~~~~");
	}
}
