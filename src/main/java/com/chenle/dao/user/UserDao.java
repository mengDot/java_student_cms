package com.chenle.dao.user;

import com.chenle.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {

    //得到登陆的用户
    public User getLoginUser(Connection connection,String id) throws SQLException;

    //新增用户
    public int increase(Connection connection, String id, String username, String password, String faculties, String dormitory, String telephone, String time)throws SQLException;

    //修改密码
    public int gaimima(Connection connection,String id,String password)throws SQLException;

    //查询用户总数
    public int usercount(Connection connection,String id) throws SQLException;

}
