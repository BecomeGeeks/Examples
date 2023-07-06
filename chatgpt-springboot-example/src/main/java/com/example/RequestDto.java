package com.example;

public class RequestDto {
    private String message;
    private Integer maxTokens;
    public String getMessage() {
	return this.message;
    }
    public void setMessage(String message) {
	this.message = message;
    }
    public Integer getMaxTokens() {
	return this.maxTokens;
    }
    public void setMaxTokens(Integer maxTokens) {
	this.maxTokens = maxTokens;
    }
}