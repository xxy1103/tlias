package top.ulna520.tlias.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.ulna520.tlias.model.User;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserMapper {

    List<User> selectWithCondition(String name, Integer gender, Date begin, Date end, int offset, int pageSize);

    void deleteById(List<Integer> ids);

    void insert(User user);

    User selectById(Integer id);

    void  update(User user);

    User getByUsernameAndPassword(User user);
}
