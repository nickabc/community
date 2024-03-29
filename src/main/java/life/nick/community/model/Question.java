package life.nick.community.model;

import lombok.Data;

/**
 *@author lijing
 *@date 2019/7/26
 **/
@Data
public class Question {

    private Integer id;

    private String title;

    private String description;

    private String tag;

    private Long gmtCreate;

    private Long gmtModified;

    private Integer creator;

    private Integer commentCount;

    private Integer viewCount;

    private Integer likeCount;


}

