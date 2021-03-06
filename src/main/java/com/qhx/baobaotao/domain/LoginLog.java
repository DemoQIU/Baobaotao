package com.qhx.baobaotao.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by QIUHX on 2017/9/26.
 */
public class LoginLog implements Serializable{
    private int loginLogId = 0;
    private int userId = 0;
    private String ip = "";
    private Date loginDate = new Date(0);

    public int getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(int loginLogId) {
        this.loginLogId = loginLogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}

