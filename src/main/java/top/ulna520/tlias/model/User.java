package top.ulna520.tlias.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer gender;
    private Integer job;
    private String image;
    private Integer deptId;
    private Date createTime;
    private Date updateTime;
}
