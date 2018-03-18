package ua.epam.spring.hometask.dao.impl;

import ua.epam.spring.hometask.NotFoundException;
import ua.epam.spring.hometask.dao.AuditoriumDao;
import ua.epam.spring.hometask.domain.Auditorium;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public class AuditoriumDaoImpl implements AuditoriumDao {

    private Map<Long, Auditorium> auditoriums;

    @Override
    public Auditorium findById(long id) throws NotFoundException {
        Optional<Auditorium> auditoriumOptional = auditoriums.values().stream().filter(auditorium1 -> auditorium1.getId() == id).findFirst();
        if (auditoriumOptional.isPresent()) {
            return auditoriumOptional.get();
        } else {
            throw new NotFoundException("Auditorium with id [" + id + "] is not found");
        }
    }

    @Override
    public Collection<Auditorium> findAll() {
        return auditoriums.values();
    }

    @Override
    public Auditorium save(Auditorium auditorium) {
        return null;
    }

    public void setAuditoriums(Map<Long, Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }
}
