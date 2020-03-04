package com.pjf.pjf.exception;


//错误代码枚举类型
public enum CustomizeErrrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND("你找的问题不在了，要不要换个试试？");

    private String message;


    @Override
    public String getMessage() {
        return message;
    }

    CustomizeErrrorCode(String message) {
        this.message = message;
    }
}
