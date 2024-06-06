package softuni.bg.pathfinder.models;

import jakarta.persistence.*;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity{
    private String title;
    @Column(nullable = false,columnDefinition = "TEXT")
    private String url;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id",referencedColumnName = "id")
    private Route route;
    @ManyToOne
    private User author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
