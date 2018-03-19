package ua.epam.spring.hometask.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.epam.spring.hometask.NotFoundException;
import ua.epam.spring.hometask.dao.UserDao;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.UserService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

public class UserServiceImpl implements UserService {

    private static final String ADMIN_LOGIN = "admin";

    @Autowired
    private UserDao userDao;

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) throws NotFoundException {
        return userDao.getByEmail(email);
    }

    @Override
    public User save(@Nonnull User user) {
        return userDao.save(user);
    }

    @Override
    public void remove(@Nonnull User object) {

    }

    @Override
    public User getById(@Nonnull Long id) {
        return null;
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return userDao.findAll();
    }
}
