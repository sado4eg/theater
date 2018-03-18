package ua.epam.spring.hometask.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.epam.spring.hometask.NotFoundException;
import ua.epam.spring.hometask.dao.UserDao;
import ua.epam.spring.hometask.domain.User;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    @Autowired
    private User admin;

    private static Map<String, User> users;

    @PostConstruct
    private void init(){
        users = new HashMap<>();
        users.put(admin.getEmail(),admin);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        User user = users.get(email);
        if(user != null){
            return user;
        } else {
            throw new NotFoundException("User with email [" + email + "] is not found");
        }
    }

    @Override
    public User findById(long id) throws NotFoundException {
        Optional<User> userOptional = users.values().stream().filter(user1 -> user1.getId() == id).findFirst();
        if(userOptional.isPresent()){
            return userOptional.get();
        } else {
            throw new NotFoundException("User with id [" + id + "] is not found");
        }
    }

    @Override
    public Collection<User> findAll() {
        return users.values();
    }

    @Override
    public User save(User user) {
        users.put(user.getFirstName(), user);
        return user;
    }

}
