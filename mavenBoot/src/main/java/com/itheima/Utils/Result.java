package com.itheima.Utils;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @date: 2018/12/24
 * @time: 15:00
 * spring mvc 返回结果集
 */
public class Result extends HashMap<String,Object> implements Serializable {

    private static final long serialVersionUID = -2665060914645729867L;

    private Boolean success;//后端返回正常结果为true，返回异常为false
    private String msg="";//发生异常的错误信息
    private Object obj;//后端返回结果数据对象

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
        this.put("success",success);

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
        this.put("msg",msg);
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
        this.put("data",obj);
    }

    private Result(Boolean success, String msg, Object obj){
        this.success = success;
        if(msg != null && !msg.trim().equals("")){
            this.msg = msg;
            put("msg",this.msg);
        }
        if(obj != null){
            this.obj = obj;
            put("data",this.obj);
        }
        put("success",this.success);
    }


    public static Result build(Boolean success){
        Result result = new Result(success,null,null);
        return result;
    }
//
    public static Result build(Boolean success, String msg){
        Result result = new Result(success,msg,null);
        return result;
    }
//
    public static Result build(Boolean success, String msg, Object obj){
        Result result = new Result(success,msg,obj);
        return result;
    }
//
    public static Result build(Boolean success, Object obj){
        Result result = new Result(success,null,obj);
        return result;
    }

}
