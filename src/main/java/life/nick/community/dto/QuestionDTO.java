package life.nick.community.dto;

import life.nick.community.model.User;
import lombok.Data;

/**
 *@author lijing
 *@date 2019/8/11
 **/
@Data
public class QuestionDTO {
    private Integer id;

    private String title;

    private String description;

    private Long gmtCreate;

    private Long gmtModified;

    private String creator;

    private Integer commentCount;

    private Integer viewCount;

    private Integer likeCount;

    private String tag;

    private User user;
}

