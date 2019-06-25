package com.hao.xu.lang.mapper.oracle;

import com.hao.xu.lang.annotation.DataSource;
import com.hao.xu.lang.entity.LangUser;
import com.hao.xu.lang.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author 郎栩浩
 */
@Repository
public interface LangUserMapper {

    int insert(LangUser record);

    @DataSource(DataSource.MYSQL)
    User selectUserById(int id);

    LangUser selectByPrimaryKey(int id);

}