package org.lkpay.common.exceptions;


public class NotFoundException extends RuntimeException{

    private String message;

    private Class<?> clazz;

    private String field;

    private Object value;

    public NotFoundException(Class<?> clazz, String field, Object value){
        super(String.format("cannot find %s with the field: %s with value %s", clazz, field, value.toString()));
    }

    public NotFoundException(String message){
        super(message);
    }
}
