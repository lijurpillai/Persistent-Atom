package com.perfomatix.atomcore.model.response;


public class ResponseMessage {
    public enum Type {
        success, warn, error, info;
    }

    private final Type type;
    private final String statusCode;
    private final String text;
    private final Object data;

    public ResponseMessage(Type type, String statusCode, String text,Object data) {
        this.type = type;
        this.text = text;
        this.data = data;
        this.statusCode = statusCode;
    }

    public String getText() {
        return text;
    }
    
    public String getStatusCode() {
        return statusCode;
    }
    
    public Type getType() {
        return type;
    }
    public Object getData(){
    	return data;
    }
}
