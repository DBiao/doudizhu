package com.db.doudizhu.login.mapper;

import com.db.doudizhu.login.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * date: 2020/2/24 17:24
 * author: DengBiao
 */
@Mapper
public interface UserMapper {

    @Select("select * from users where name=#{user.name} and password=#{user.password}")
    User getUserByNameAndPw(User user);

    @Select("select * from users where token=#{user.token}")
    User getUserByToken(User user);

    @Update("update users set token=#{user.token} where uid=#{user.uid}")
    int updateUser(User user);

    @Insert("insert into users (uid,token,name,password) values (#{user.uid},#{user.token},#{user.name},#{user.password})")
    int insertUser(User user);
}
