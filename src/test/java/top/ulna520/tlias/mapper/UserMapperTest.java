package top.ulna520.tlias.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.ulna520.tlias.model.User;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectWithCondition(){
        String name = "e";
        int gender = 1;
        Date begin = new Date("2023/01/01");
        Date end = new Date("2025/9/31");
        userMapper.selectWithCondition(name, gender, begin, end,0,2).forEach(System.out::println);
    }

    @Test
    public void testDeleteById(){
        userMapper.deleteById(List.of(4,6));
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setUsername("test1");
        user.setPassword("test");
        user.setName("Test User");
        user.setGender(1);
        user.setJob(1);
        user.setImage("test.jpg");
        user.setDeptId(1);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insert(user);
    }

    @Test
    public void testSelectById(){
        System.out.println(userMapper.selectById(3));
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(3);
        user.setUsername("updatedUser");
        user.setPassword("updatedPass");
        user.setName("Updated");
        user.setGender(1);
        user.setUpdateTime(new Date());

        userMapper.update(user);
    }
}
