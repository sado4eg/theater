package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.NotFoundException;
import ua.epam.spring.hometask.domain.DomainObject;

import java.util.Collection;

public interface AbstractDao<T extends DomainObject> {
    T findById(long id) throws NotFoundException;
    Collection<T> findAll();
    T save(T t);
}
