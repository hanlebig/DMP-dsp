package com.taiyear.dsp.utils;

import java.io.Serializable;

/**
 * Created by liul on 2017/03/28.
 */
public class HttpResult<T> implements Serializable {

	private Boolean success;

	private String message;

	private String[] messages;

	public static final HttpResult<String> SUCCESS = new HttpResult<String>(
			true);
	public static final HttpResult<String> FAILURE = new HttpResult<String>(
			false);

	private T data;

	public HttpResult(T data) {
		success = true;
		this.data = data;
	}

	public HttpResult(Boolean success, String message, T data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}

	public HttpResult(Boolean success, String[] messages, T data) {
		this.success = success;
		this.messages = messages;
		this.data = data;
	}

	public HttpResult(Boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public HttpResult(Boolean success, String[] messages) {
		this.success = success;
		this.messages = messages;
	}

	public HttpResult(Boolean success) {
		this.success = success;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public String[] getMessages() {
		return messages;
	}

	public void setMessages(String[] messages) {
		this.messages = messages;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
