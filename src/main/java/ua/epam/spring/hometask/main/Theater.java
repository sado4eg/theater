package ua.epam.spring.hometask.main;

import org.springframework.beans.factory.annotation.Autowired;
import ua.epam.spring.hometask.NotFoundException;
import ua.epam.spring.hometask.action.AdminActions;
import ua.epam.spring.hometask.action.EntryActions;
import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.domain.UserType;
import ua.epam.spring.hometask.service.AuditoriumService;
import ua.epam.spring.hometask.service.EventService;
import ua.epam.spring.hometask.service.UserService;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;

public class Theater {

    @Autowired
    private UserService userService;

    @Autowired
    private EventService eventService;

    @Autowired
    private AuditoriumService auditoriumService;

    private Scanner scanner;

    @PostConstruct
    private void init() {
        scanner = new Scanner(System.in);
    }

    public void entryPoint() {
        while (true) {
            System.out.println("Welcome to the cinema, please select your action: ");
            EntryActions.printAll();
            EntryActions actions = EntryActions.getById(Integer.parseInt(scanner.nextLine()));
            switch (actions) {
                case LOGIN:
                    logIn();
                    break;
                case REGISTRATION:
                    registration();
                    break;
                case EXIT:
                    System.out.println("Good Bye!");
                    return;
            }
        }

    }

    public void logIn() {
        System.out.println("Enter your email : ");
        String email = scanner.nextLine();
        User user;
        try {
            user = userService.getUserByEmail(email);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
            user = registration();
            return;
        }
        if (user.getType() == UserType.ADMIN) {
            adminActions(user);
        }
    }

    private void adminActions(User user) {
        while (true) {
            System.out.println("Welcome " + user.getFirstName() + ", please select your action: ");
            AdminActions.printAll();
            AdminActions actions = AdminActions.getById(Integer.parseInt(scanner.nextLine()));
            switch (actions) {
                case CREATE_EVENT:
                    createEvent();
                    break;
                case VIEW_EVENTS:
                    viewEvents();
                    break;
                case VIEW_TICKETS:
                    viewTickets();
                    break;
                case LOG_OUT:
                    entryPoint();
                    return;
            }
        }
    }

    private void viewTickets() {

    }

    private void viewEvents() {
        System.out.println(eventService.getAll());
    }

    private void createEvent() {
        Event event = new Event();
        System.out.println("Please enter event name");
        event.setName(scanner.nextLine());
        assignDatesAndAuditoriums(event);
        System.out.println("enter price");
        event.setBasePrice(Double.parseDouble(scanner.nextLine()));
        eventService.save(event);
    }

    private void assignDatesAndAuditoriums(Event event) {
        System.out.println("please enter air dates and Auditoriums:");
        Map<LocalDateTime, Auditorium> auditoriums = event.getAuditoriums();
        do {
            System.out.println("enter year");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.println("enter month");
            int month = Integer.parseInt(scanner.nextLine());
            System.out.println("enter day");
            int day = Integer.parseInt(scanner.nextLine());
            System.out.println("enter hour");
            int hour = Integer.parseInt(scanner.nextLine());
            System.out.println("enter minutes");
            int minutes = Integer.parseInt(scanner.nextLine());
            LocalDateTime date = LocalDateTime.of(year, month, day, hour, minutes);
            selectAuditorium(date, auditoriums);
            System.out.println("add another date?(y/n)");
            if (scanner.nextLine().equals("n")) {
                break;
            }
        } while (true);
        event.getAirDates().addAll(auditoriums.keySet());
    }

    private void selectAuditorium(LocalDateTime date, Map<LocalDateTime, Auditorium> auditoriums) {
        System.out.println("select auditorium:");
        auditoriumService.getAll().forEach(auditorium -> System.out.println(auditorium.getId() + "." + auditorium.getName()));
        try {
            auditoriums.put(date, (Auditorium) auditoriumService.getById(Long.parseLong(scanner.nextLine())));
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
            selectAuditorium(date, auditoriums);
        }
    }

    private User registration() {
        return null;
    }


}
