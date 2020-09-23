package zy.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zy.demo.entity.User;
import zy.demo.mapper.UserMapper;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public boolean match(int id,String password){
        User user = userMapper.sel(id);
        if(user==null){
            return false;
        }

        if(user.getId()==id && user.getPassword().equals(password)){
            return true;
        }
        else{
            return false;
        }

    }
    public void register(User user){
        userMapper.add(user);
    }
}
