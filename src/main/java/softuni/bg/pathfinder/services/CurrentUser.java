package softuni.bg.pathfinder.services;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import softuni.bg.pathfinder.models.Level;
import softuni.bg.pathfinder.models.Role;
import softuni.bg.pathfinder.models.User;

import java.util.Set;

@Component
@SessionScope
public class CurrentUser {
    private String fullName;
    private String username;
    private int age;
    private Level level;
    private boolean isLoggedIn;
    private boolean isAdmin;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

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

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void reset(){
        this.fullName = null;
        this.isLoggedIn = false;
    }

}
