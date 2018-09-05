package com.test.websocket.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;
import org.springframework.web.socket.messaging.SessionUnsubscribeEvent;

/**
* @author 蔡钧 E-mail: caijun-d@dfl.com.cn
* @version 创建时间： Apr 21, 2018 2:17:05 PM
* 
* 
* TODO session 控制
* 
*/
@Component
public class WebsocketEventListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WebsocketEventListener.class);

	@EventListener
	public void handleWebSocketConnectedListener(SessionConnectedEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		LOGGER.info("Received a new web socket connectionc - {}", headerAccessor);
//		LOGGER.debug(headerAccessor.getSessionId());
//		LOGGER.debug(headerAccessor.getNativeHeader("name").get(0));
//		LOGGER.debug(headerAccessor.getUser().getName());
    }
	
	@EventListener
	public void handleWebSocketSubscribeListener(SessionSubscribeEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		LOGGER.info("A web socket client Subscribed a topic - {}", headerAccessor);
    }
	
	@EventListener
	public void handleWebSocketUnsubscribeListener(SessionUnsubscribeEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		LOGGER.info("A web socket client unsubscribed a topic - {}", headerAccessor);
    }
	
	@EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        LOGGER.info("A web socket client disconnected - {}", headerAccessor.toString());
//        String username = (String) headerAccessor.getSessionAttributes().get("username");
    }
}
