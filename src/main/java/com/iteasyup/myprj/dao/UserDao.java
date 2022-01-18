package com.iteasyup.myprj.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.iteasyup.myprj.dao.entity.UserEntity;

@Repository
public interface UserDao {
    /*
     * 检索此用户是否存在
     */
	@Select("select id,username,email,password,creatTime from learnee where username = #{username}")
	UserEntity searchUserExitsByUsername(@Param("username") String username );
	
	/*
	 * 注册用户
	 */
	@Insert("insert into learnee values(seq_learnee_id.nextval,#{username},#{email},#{password})")
	int addUser(UserEntity userEntity);
	
	@Select("select id,username,email,password,creatTime from learnee where"
			+ " username = #{username} and password = #{password}")
	UserEntity searchUserByUsernameAndPassword(@Param("username") String username,@Param ("password") String password );
	
}
