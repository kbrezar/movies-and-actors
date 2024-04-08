
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name = "actors")
@Entity
public class Actor implements Serializable {

        private String firstName;
        private String lastName;
        private Date bornDate;

        @ManyToMany(mappedBy = "starringActors")
        @JsonIgnore
        private Set<Movie> moviesStarred;
        private int id;

        public Actor() {}

        public String getFirstName() {
            return this.firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Date getBornDate() {
            return this.bornDate;
        }

        public void setBornDate(Date bornDate) {
            this.bornDate = bornDate;
        }

        public Set<Movie> getMoviesStarred() {
            return this.moviesStarred;
        }

        public void setMoviesStarred(Set<Movie> moviesStarred) {
            this.moviesStarred = moviesStarred;
        }

        @Id
        public int getId() { return this.id; }

        public void setId(int id) { this.id = id; }
}
