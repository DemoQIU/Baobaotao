package com.qhx.baobaotao.dao;

import com.qhx.baobaotao.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by QIUHX on 2017/9/26.
 */
@Repository
public class LoginLogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertLoginLog(LoginLog loginLog){
        String sqlStr = "insert into t_login_log(user_id,ip,login_datetime)"
                            +"values(?,?,?)";
        jdbcTemplate.update(sqlStr,new Object[]{
                                    loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDate()});
    }
}
