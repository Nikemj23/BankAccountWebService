package com.app.dto;

import java.time.LocalDateTime;

public class ErrorResponse {//dto sent as json representation with frontend
private String message;
private LocalDateTime timeStamp;

      public ErrorResponse() {
		    
	}
public ErrorResponse(String message, LocalDateTime timeStamp) {
	super();
	this.message = message;
	this.timeStamp = timeStamp;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public LocalDateTime getTimeStamp() {
	return timeStamp;
}
public void setTimeStamp(LocalDateTime timeStamp) {
	this.timeStamp = timeStamp;
}


@Override
public int hashCode() {
	// TODO Auto-generated method stub
	return super.hashCode();
}
@Override
public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	return super.equals(obj);
}
@Override
public String toString() {
	return "ErrorResponse [message=" + message + ", timeStamp=" + timeStamp + "]";
}


}
