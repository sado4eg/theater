package ua.epam.spring.hometask.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.epam.spring.hometask.NotFoundException;
import ua.epam.spring.hometask.dao.AuditoriumDao;
import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.domain.DomainObject;
import ua.epam.spring.hometask.service.AuditoriumService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;

public class AuditoriumServiceImpl implements AuditoriumService {

    @Autowired
    private AuditoriumDao auditoriumDao;

    @Override
    public DomainObject save(@Nonnull DomainObject object) {
        return null;
    }

    @Override
    public void remove(@Nonnull DomainObject object) {

    }

    @Override
    public Auditorium getById(@Nonnull Long id) throws NotFoundException {
        return auditoriumDao.findById(id);
    }

    @Nonnull
    @Override
    public Set<Auditorium> getAll() {
        return new HashSet<>(auditoriumDao.findAll());
    }

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        return null;
    }
}
