package com.userManagementSystem.dto;

public class ErrorResponse {

	private int status;
	private String message;
	private String path;
	private String timestamp;
	
	public ErrorResponse(int status, String message, String path, String timestamp) {
		
		this.status = status;
		this.message = message;
		this.path = path;
		this.timestamp = timestamp;
	}
	
	public ErrorResponse() {
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	};
	
	
	
}

