package softuni.bg.pathfinder.models;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{
    @Column
    @Enumerated(EnumType.STRING)
    private UserRoles name;

    public UserRoles getName() {
        return name;
    }

    public void setName(UserRoles name) {
        this.name = name;
    }
}
