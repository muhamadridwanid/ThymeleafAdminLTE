/*
 * Copyright (c) 2017,  Muhamadridwan.id
 * All rights reserved.
 */
package id.muhamadridwan.starter.utils;

import id.muhamadridwan.starter.models.User;
import java.util.List;

/**
 *
 * @author mridwan
 */
public class AjaxResponseBody {
    private String msg;
    private List<User> result;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setResult(List<User> result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public List<User> getResult() {
        return result;
    }
    
}
