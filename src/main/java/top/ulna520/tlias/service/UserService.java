package top.ulna520.tlias.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ulna520.tlias.mapper.UserMapper;
import top.ulna520.tlias.model.User;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> selectWithCondition(String name, Integer gender, Date begin, Date end, Integer page, Integer pageSize){
        int offset = (page - 1) * pageSize;
        return userMapper.selectWithCondition(name,gender,begin,end,offset,pageSize);
    }


    public void deleteById(List<Integer> ids) {
        userMapper.deleteById(ids);
    }

    public void addUser(User user) {
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insert(user);
    }

    public User getUserById(Integer id) {
        return userMapper.selectById(id);
    }

    public void updateUser(User user) {
        user.setUpdateTime(new Date());
        userMapper.update(user);
    }
}
