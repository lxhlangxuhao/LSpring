package com.hao.xu.lang.mapper.mysql;

import com.hao.xu.lang.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 21:28 2019/6/9
 */
@Repository
public interface UserMapper {

	User selectByPrimaryKey(int id);

	void insertUser(User user);

	Integer findUserId(String name);
}
