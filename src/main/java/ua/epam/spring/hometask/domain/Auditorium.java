package ua.epam.spring.hometask.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @author Yuriy_Tkach
 */
public class Auditorium extends DomainObject {

    private String name;

    private long numberOfSeats;

    private Set<Long> vipSeats = Collections.emptySet();

    public Auditorium() {
    }

    /**
     * Counts how many vip seats are there in supplied <code>seats</code>
     *
     * @param seats Seats to process
     * @return number of vip seats in request
     */
    public long countVipSeats(Collection<Long> seats) {
        return seats.stream().filter(seat -> vipSeats.contains(seat)).count();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(long numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Set<Long> getAllSeats() {
        return LongStream.range(1, numberOfSeats + 1).boxed().collect(Collectors.toSet());
    }

    public Set<Long> getVipSeats() {
        return vipSeats;
    }

    public void setVipSeats(Set<Long> vipSeats) {
        this.vipSeats = vipSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Auditorium that = (Auditorium) o;

        return numberOfSeats == that.numberOfSeats && name.equals(that.name) && (vipSeats != null ? vipSeats.equals(that.vipSeats) : that.vipSeats == null);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (int) (numberOfSeats ^ (numberOfSeats >>> 32));
        result = 31 * result + (vipSeats != null ? vipSeats.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Auditorium{\n" +
                "   name='" + name + '\'' +
                "\n numberOfSeats=" + numberOfSeats +
                "\n vipSeats=" + vipSeats +
                "}\n";
    }
}
