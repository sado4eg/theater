package ua.epam.spring.hometask.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.epam.spring.hometask.dao.UserDao;
import ua.epam.spring.hometask.domain.User;

import java.util.Map;

public class UserDaoImpl implements UserDao {

    @Autowired
    private Map<String, User> users;

    @Override
    public User getByName(String name) {
        return null;
    }
}
