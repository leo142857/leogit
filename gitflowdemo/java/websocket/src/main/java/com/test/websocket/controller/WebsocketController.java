package com.test.websocket.controller;
/**
* @author 蔡钧 E-mail: caijun-d@dfl.com.cn
* @version 创建时间： Apr 2, 2018 2:10:04 PM
* 
*/

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import com.test.websocket.message.RequestMessage;
import com.test.websocket.message.ResponseMessage;
import com.test.websocket.service.WebsocketService;

@Controller
public class WebsocketController {
//	private String userId = "abc";
	@Autowired
	private WebsocketService service;
	
    @MessageMapping("/hello")
    @SendTo("/topic/chebaba")
//    @SendToUser("/msg")
    public ResponseMessage greeting(RequestMessage message) throws Exception {
        String userId = message.getName();
        Thread.sleep(1000); // simulated delay
//        service.sendMsg(new ResponseMessage("public message!"));
//        service.sendMsg2User(userId, new ResponseMessage("private message"));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg","Hello, " + message.getName() + "!");
        jsonObject.put("url","https://www.chebaba.com");
        jsonObject.put("title","车巴巴");
        return new ResponseMessage(jsonObject.toString());
//        return new ResponseMessage("Hello, " + message.getName() + "!");
    }
}
