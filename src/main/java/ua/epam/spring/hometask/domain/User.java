package ua.epam.spring.hometask.domain;

import java.util.NavigableSet;
import java.util.Objects;
import java.util.TreeSet;

/**
 * @author Yuriy_Tkach
 */
public class User extends DomainObject {

    private String firstName;

    private String lastName;

    private String email;

    private UserType type;

    private NavigableSet<Ticket> tickets = new TreeSet<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NavigableSet<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(NavigableSet<Ticket> tickets) {
        this.tickets = tickets;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!firstName.equals(user.firstName)) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (!email.equals(user.email)) return false;
        if (type != user.type) return false;
        return tickets != null ? tickets.equals(user.tickets) : user.tickets == null;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + email.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + (tickets != null ? tickets.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                ", tickets=" + tickets +
                '}';
    }
}
