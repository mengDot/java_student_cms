package com.chenle.dao.user;

import com.chenle.dao.BaseDao;
import com.chenle.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    //登陆
    public User getLoginUser(Connection connection, String id) throws SQLException {

        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;

        if (connection != null) {
            String sql = "select id,username,password from user where id=?";
            Object[] params = {id};

            rs = BaseDao.execute(connection, rs, pstm, sql, params);

            if (rs.next()) {
                user = new User();
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                System.out.println(user.getId()+":"+user.getUsername()+":"+user.getPassword());
            }
            BaseDao.clseall(null,pstm,rs);
        }
        return user;
    }

    //新增用户
    public int increase(Connection connection, String id, String username, String password, String faculties, String dormitory, String telephone, String time) throws SQLException {

        PreparedStatement pstm = null;
        int execute = 0;

        if (connection != null){

            String sql = "insert into user (id,username,password,faculties,dormitory,telephone,time) values(?,?,?,?,?,?,?)";
            Object params[] = {id,username,password,faculties,dormitory,telephone,time};
            execute = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.clseall(null,pstm,null);
        }
        return execute;
    }

    //修改密码
    public int gaimima(Connection connection, String id, String password) throws SQLException {

        PreparedStatement pstm = null;
        int execute = 0;

        if (connection != null){
            String sql = "update user set password = ? where id = ?";
            Object params[] = {password,id};
            execute = BaseDao.execute(connection, pstm, sql, params);

            BaseDao.clseall(null,pstm,null);
        }
        return execute;
    }

    public int usercount(Connection connection, String id) throws SQLException {
        return 0;
    }


}
