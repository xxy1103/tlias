package top.ulna520.tlias.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@NoArgsConstructor
@Component
public class Dept {
    int id;
    String name;
    Date createTime;
    Date updateTime;
}
