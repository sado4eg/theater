package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.NotFoundException;
import ua.epam.spring.hometask.domain.User;

public interface UserDao extends AbstractDao<User> {

    User getByEmail(String name) throws NotFoundException;

}
