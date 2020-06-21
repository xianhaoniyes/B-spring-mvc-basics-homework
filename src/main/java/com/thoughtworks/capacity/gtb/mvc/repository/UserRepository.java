package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.exception.MismatchException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserExistException;
import com.thoughtworks.capacity.gtb.mvc.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private final Map<String, User> userMap;

    public UserRepository(){

        userMap = new HashMap<>();
        //user0 is only for test
        User user = new User(0L, "xianhaoni","mypassword","xianhaoni@xxx.com");
        userMap.put(user.getUsername(),user);
    }

    public void put(User user) throws UserExistException{

        if(userMap.containsKey(user.getUsername()))
            throw new UserExistException();

        user.setUserId((long) userMap.size());
        userMap.put(user.getUsername(),user);
    }

    public User find(String username, String password) throws MismatchException{
        User storedUser = userMap.get(username);
        if(storedUser==null||!storedUser.getPassword().equals(password))
            throw new MismatchException();
        else
            return storedUser;
    }


}
