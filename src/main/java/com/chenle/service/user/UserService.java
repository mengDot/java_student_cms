package com.chenle.service.user;

import com.chenle.pojo.User;

public interface UserService {
    //用户登陆
    public User login(String id,String password);

    //用户注册
    public boolean increase(String id, String username, String password, String faculties, String dormitory, String telephone, String time);

    //修改密码
    public boolean gaimi(String id, String password);
}
