package com.pjf.pjf.exception;


//错误代码枚举类型
public enum CustomizeErrrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND(2001, "你找的问题不在了，要不要换个试试？"),
    TARGET_PARAM_NOT_FOUND(2002, "未选中任何问题或评论进行回复。"),
    NO_LOGIN(2003, "未登录不能进行评论，请先登录。"),
    SYS_ERROR(2004, "服务器冒烟了!，要不然你稍后在试试。"),
    TYPE_PARAM_WRONG(2005, "评论类型错误或不存在。"),
    COMMENT_NOT_FOUND(2006, "回复的评论不在了，要不要换个试试?");

    //消息代码
    private Integer code;
    private String message;


    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    CustomizeErrrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
