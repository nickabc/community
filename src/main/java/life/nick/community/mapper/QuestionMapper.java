package life.nick.community.mapper;

import life.nick.community.model.Question;
import life.nick.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 *@author lijing
 *@date 2019/8/10
 **/
@Mapper
public interface QuestionMapper {

    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,tag)"
            + "values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator}, #{tag})")
    void createQuestion(Question question);
}
