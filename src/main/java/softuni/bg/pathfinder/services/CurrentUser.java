package softuni.bg.pathfinder.services;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import softuni.bg.pathfinder.models.Role;

import java.util.Set;

@Component
@SessionScope
public class CurrentUser {
    private String fullName;
    private boolean isLoggedIn;
    private boolean isAdmin;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public void reset(){
        this.fullName = null;
        this.isLoggedIn = false;
    }
}
