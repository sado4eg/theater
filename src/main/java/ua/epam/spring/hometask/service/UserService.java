package ua.epam.spring.hometask.service;

import ua.epam.spring.hometask.NotFoundException;
import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface UserService extends AbstractDomainObjectService<User> {

    @Nullable
    User getUserByEmail(@Nonnull String email) throws NotFoundException;

}
