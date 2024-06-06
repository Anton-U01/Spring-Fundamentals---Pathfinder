package softuni.bg.pathfinder.models;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public BaseEntity() {
    }

    public long getId() {
        return id;
    }
}
