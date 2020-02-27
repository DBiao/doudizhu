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

    @Select("select * from users where name=#{name} and password=#{password}")
    User getUserByNameAndPw(User user);

    @Update("update users set token=#{token} where uid=#{uid}")
    int updateUser(User user);

    @Insert("insert into users (uid,token,name,password) values (#{uid},#{token},#{name},#{password})")
    int insertUser(User user);

    @Select("select * from users where token=#{token}")
    User getUserByToken(User user);
}
