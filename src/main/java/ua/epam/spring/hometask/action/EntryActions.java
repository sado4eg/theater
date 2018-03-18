package ua.epam.spring.hometask.action;


import com.sun.xml.internal.ws.addressing.model.ActionNotSupportedException;

public enum EntryActions {
    LOGIN(1, "Log In"),
    REGISTRATION(2, "Registration"),
    EXIT(3, "Log out from the app");

    private int id;
    private String action;

    EntryActions(int id, String action) {
        this.id = id;
        this.action = action;
    }

    public static EntryActions getById(int id) {
        for(EntryActions action : values()) {
            if(action.id == id) return action;
        }
        throw new ActionNotSupportedException("" + id);
    }

    public static void printAll(){
        for (EntryActions action : values()) {
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
