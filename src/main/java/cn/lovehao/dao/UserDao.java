package cn.lovehao.dao;

import cn.lovehao.entity.Student;
import cn.lovehao.entity.User;

public interface UserDao {

    public User selectById(User user);

    public User selectByName(User user);

    public int insert(User user);

    public int delete(User user);

}
