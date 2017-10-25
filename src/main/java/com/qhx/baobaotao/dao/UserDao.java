package com.qhx.baobaotao.dao;

import com.qhx.baobaotao.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by QIUHX on 2017/9/26.
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //获得用户个数
    public int getMatchCount(String username,String password){
        String sqlStr = "select count(*) from t_user where user_name = ? and password = ?";
//        jdbcTemplate.queryForInt(sqlStr,new Object[]{username,password});
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sqlStr,new Object[]{username,password});
        List<Integer> list = jdbcTemplate.queryForList(sqlStr,new Object[]{username,password},Integer.class);
        int count = list.get(0);
        return count;
    }


    //根据用户名查找用户
    public User findUserByUsername(final String username){
        String sqlStr = "select user_id,user_name,credit from t_user where user_name = ?";
        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{username},
                new RowCallbackHandler() {
                    public void processRow(ResultSet resultSet) throws SQLException {
                        user.setUserId(resultSet.getInt("user_id"));
                        user.setUserName(username);
                        user.setCredits(resultSet.getInt("credit"));
                    }
                });
        return user;
    }
    //更新登录信息
    public void updateLoginInfo(User user){
        String sqlStr = "update t_user Set last_visit = ?,last_ip = ?,credit = ?"
                                    +"where user_id = ?";
        jdbcTemplate.update(sqlStr,new Object[]{user.getLastVisit(),
                            user.getLastIp(),user.getCredits(),user.getUserId()});
    }
}
