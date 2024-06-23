package com.example.demo.models.common;

public class Response<T> {
	
	private String message;
	
	private T object;
	
	//Constructor
	public Response(String message, T object) {
		super();
		this.message = message;
		this.object = object;
	}

	public Response(String message) {
		this.message = message;
	}
	
	//Accessories
	public String getMessage(){
		return message;
	}

	public void setMessage(String message){
		this.message = message;
	}
	
	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}
	
	

}