package softuni.bg.pathfinder.models;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity{
    @Column(nullable = false)
    private boolean approved;
    @Column(nullable = false)
    private Instant created;
    @Column(name = "text_content",nullable = false,columnDefinition = "TEXT")
    private String textContent;
    @ManyToOne
    @JoinColumn(name = "author_id",referencedColumnName = "id")
    private User author;
    @ManyToOne
    @JoinColumn(name = "route_id",referencedColumnName = "id")
    private Route route;

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
