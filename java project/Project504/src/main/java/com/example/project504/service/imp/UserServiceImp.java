package com.example.project504.service.imp;

import com.example.project504.dao.UserDao;
import com.example.project504.entity.User;
import com.example.project504.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User queryByUser(User user) {
        return userDao.queryByUser(user);
    }

    @Override
    public int editUser(User user) {
        return userDao.editUser(user);
    }

    @Override
    public int addUser(User user)
    {
        return userDao.addUser(user);
    }

    @Override
    public List<User> findAll() {
        List<User> userList = userDao.findAll();
        return userList;
    }

    @Override
    public User findByUsername(String username) {

        return userDao.findByUsername(username);
    }

    @Override
    public int deleteById(String id) {
        return userDao.deleteById(id);
    }
}
