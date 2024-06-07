package softuni.bg.pathfinder.models;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{
    @Column
    @Enumerated(EnumType.STRING)
    private UserRole name;

    public UserRole getName() {
        return name;
    }

    public void setName(UserRole name) {
        this.name = name;
    }
}
