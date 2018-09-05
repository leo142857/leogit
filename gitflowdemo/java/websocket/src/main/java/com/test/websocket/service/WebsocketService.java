package com.test.websocket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.test.websocket.message.ResponseMessage;

/**
 * @author 蔡钧 E-mail: caijun-d@dfl.com.cn
 * @version 创建时间： Apr 2, 2018 2:09:31 PM
 * 
 */
@Service
public class WebsocketService {
	
	@Autowired
	private SimpMessagingTemplate template;
	
	public void sendMsg(String message) {
		template.convertAndSend("/topic/greetings", message);
	}

	public void sendMsg(ResponseMessage message) {
		template.convertAndSend("/topic/greetings", message);
	}
	
	public void sendMsg2User(String userId, String message) {
		template.convertAndSendToUser(userId, "/msg", message);
	}

	public void sendMsg2User(String userId, ResponseMessage message) {
		template.convertAndSendToUser(userId, "/msg", message);
	}
}
