package ua.epam.spring.hometask.service;

import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import ua.epam.spring.hometask.domain.Auditorium;

/**
 * @author Yuriy_Tkach
 */
public interface AuditoriumService extends AbstractDomainObjectService {

    @Nonnull
    Set<Auditorium> getAll();

    @Nullable
    Auditorium getByName(@Nonnull String name);

}
