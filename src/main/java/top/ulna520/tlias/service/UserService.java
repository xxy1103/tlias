package top.ulna520.tlias.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ulna520.tlias.mapper.UserMapper;
import top.ulna520.tlias.model.User;
import top.ulna520.tlias.util.JwtUttil;

import javax.crypto.SecretKey;
import java.util.*;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtUttil jwtUttil;

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

    public String login(User user) {
        User quryUser = userMapper.getByUsernameAndPassword(user);
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", quryUser.getId());
        claims.put("username", quryUser.getUsername());

        String jwt = jwtUttil.constructJwt(claims);
        log.info(jwt);
        return jwt;
    }
}
