package ua.epam.spring.hometask.service;

import ua.epam.spring.hometask.NotFoundException;
import ua.epam.spring.hometask.domain.DomainObject;

import javax.annotation.Nonnull;
import java.util.Collection;

/**
 * @param <T> DomainObject subclass
 * @author Yuriy_Tkach
 */
public interface AbstractDomainObjectService<T extends DomainObject> {

    T save(@Nonnull T object);

    void remove(@Nonnull T object);

    T getById(@Nonnull Long id) throws NotFoundException;

    @Nonnull
    Collection<T> getAll();
}
