package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.User;

/**
 * Created by alex on 18.03.2018.
 */
public interface UserDao {

    public User getByName(String name);

}
