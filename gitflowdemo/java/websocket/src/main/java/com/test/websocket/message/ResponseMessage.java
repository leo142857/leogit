package com.test.websocket.message;
/**
* @author 蔡钧 E-mail: caijun-d@dfl.com.cn
* @version 创建时间： Apr 3, 2018 10:19:05 AM
* 
*/
public class ResponseMessage {
	
	public ResponseMessage(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	private String responseMsg;

	public String getResponseMsg() {
		return responseMsg;
	}
	
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
}