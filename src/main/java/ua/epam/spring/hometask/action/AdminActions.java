package ua.epam.spring.hometask.action;

import com.sun.xml.internal.ws.addressing.model.ActionNotSupportedException;

public enum AdminActions {
    CREATE_EVENT(1, "Create new event"),
    VIEW_EVENTS(2, "View all events"),
    VIEW_TICKETS(3, "View all bought tickets"),
    LOG_OUT(4, "Log out from the app");

    private int id;
    private String action;

    AdminActions(int id, String action) {
        this.id = id;
        this.action = action;
    }

    public static AdminActions getById(int id) {
        for(AdminActions action : values()) {
            if(action.id == id) return action;
        }
        throw new ActionNotSupportedException("" + id);
    }

    public static void printAll(){
        for (AdminActions action : values()) {
            System.out.println(action.getId() + ". " + action.getAction());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
