package com.study.mapper;
import com.study.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectAll();

    /**
     * 根据名字查询用户，查询用户是否存在
     * @param username
     * @return
     */
    User selectByName(@Value("name") String username);

    /**
     * 这是注册用户数据
     * @param user 注册时添加 用户名、密码、创建时间、创建用户等信息
     * @return 返回的是受影响的行数，当添加成功返回1，放添加失败返回0
     */
    Integer insert(User user);

    // 删除用户
    Integer delete(@Value("uid") int uid);


    //修改用户

}
