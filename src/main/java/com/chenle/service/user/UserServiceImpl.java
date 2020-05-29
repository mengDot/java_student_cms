package com.chenle.service.user;

import com.chenle.dao.BaseDao;
import com.chenle.dao.user.UserDao;
import com.chenle.dao.user.UserDaoImpl;
import com.chenle.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    //业务层都会调用dao层，所以 引入dao层
    private UserDao userDao;
    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }

    //登陆
    public User login(String id, String password) {
        Connection connection = null;
        User user = null;

        try {
            connection = BaseDao.getConnection();
            //通过业务层调用对应的具体的数据库操作
            user = userDao.getLoginUser(connection, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.clseall(connection,null,null);
        }
        if (user.getPassword().equals(password)){
            return user;
        }else{
            return null;
        }
    }

    //注册
    public boolean increase(String id, String username, String password, String faculties, String dormitory, String telephone, String time) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if (userDao.increase(connection,id,username,password,faculties,dormitory,telephone,time)>0){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.clseall(connection,null,null);
        }
        return flag;
    }

    //修改密码
    public boolean gaimi(String id, String password) {
        Connection connection = null;
        boolean flag = false;

        try {
            connection = BaseDao.getConnection();
            if (userDao.gaimima(connection,id,password) > 0){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.clseall(connection,null,null);
        }
        return flag;
    }

}
