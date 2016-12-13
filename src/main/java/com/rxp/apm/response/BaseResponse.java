package com.rxp.apm.response;

import java.util.ArrayList;
import java.util.List;

public class BaseResponse {
	
	protected String responseCode;
	protected String responseMessage;
	protected List<String> messages;
	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}
	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	/**
	 * @return the responseMessage
	 */
	public String getResponseMessage() {
		return responseMessage;
	}
	/**
	 * @param responseMessage the responseMessage to set
	 */
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	/**
	 * @return the messages
	 */
	public List<String> getMessages() {
		if (null == messages) {
			messages = new ArrayList<String>();
		}
		return messages;
	}
	/**
	 * @param messages the messages to set
	 */
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
}
