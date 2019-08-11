package life.nick.community.model;

import lombok.Data;

/**
 *@author lijing
 *@date 2019/7/26
 **/
@Data
public class User {

    private Integer id;

    private String name;

    private String accountId;

    private String token;

    private Long gmtCreate;

    private Long gmtModified;

    private String avatarUrl;

}

