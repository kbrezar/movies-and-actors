
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "movies")
@Entity
public class Movie implements Serializable {

    private String title;
    private int screenedYear;
    private String description;
    @ManyToMany
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name = "movies_id"),
            inverseJoinColumns = @JoinColumn(name = "actors_id")
    )
    @JsonIgnore
    private Set<Actor> starringActors;
    private int id;
    //private List<String> images; //list of file paths with pics to show?

    public Movie() {}

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getScreenedYear() {
        return this.screenedYear;
    }

    public void setScreenedYear(int screenedYear) {
        this.screenedYear = screenedYear;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Actor> getStarringActors() {
        return this.starringActors;
    }

    public void setStarringActors(Set<Actor> starringActors) {
        this.starringActors = starringActors;
    }

    @Id
    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }
}
