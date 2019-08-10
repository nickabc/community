package life.nick.community.mapper;

import life.nick.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 *@author lijing
 *@date 2019/7/25
 **/
@Mapper
public interface UserMapper {

    @Insert("insert into user (name,accountId,token,gmtCreate,gmtModified) "
            + "values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insertUser(User user);

    @Select("select * from user where token = #{token}" )
    User findByToken(@Param("token") String token);
}
