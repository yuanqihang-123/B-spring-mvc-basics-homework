package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.entity.UserEntity;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {
    Map<Integer,UserEntity> userMap = new HashMap<Integer,UserEntity>();

    UserService(){
        userMap.put(1,new UserEntity("zhangsan","123456","123@qq.com"));
        userMap.put(1,new UserEntity("lisi","123456","123@qq.com"));
    }

    public void registerUser(UserEntity user) {
        Integer id = userMap.size()+1;
        userMap.put(id, user);
    }

    public UserEntity login(String username, String password) throws UserNotFoundException {
        List<UserEntity> userlist = userMap.values().stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password)).collect(Collectors.toList());
        if(userlist.size()>0){
            return userlist.get(0);
        }else {
            throw new UserNotFoundException("username or password did not exist");
        }
    }
}
