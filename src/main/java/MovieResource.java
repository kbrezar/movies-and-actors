import io.quarkus.logging.Log;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.inject.*;

import java.util.List;

@Singleton
public class MovieResource {
    @Inject
    EntityManager entityManager;

    public List<Movie> getMovies() {
        return entityManager.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
    }

    public List<Movie> getMoviesPaged(int pageNum, int pageSize) {
        return entityManager.createQuery("SELECT m FROM Movie m", Movie.class).setFirstResult((pageNum-1)*pageSize).setMaxResults(pageSize).getResultList();
    }

    public Movie getMovie(String id) {
        return entityManager.find(Movie.class, id);
    }

    public Movie searchForMovieByTitle (String title) {
        try{
            Movie m = entityManager.createQuery("Select m FROM Movie m WHERE m.title LIKE ?1", Movie.class).setParameter(1, title).getSingleResult();
            for (Actor a : m.getStarringActors())
                a.setMoviesStarred(null);
            return m;
        }
        catch (Exception e) {
            Log.warn("Movie " + title + " not found!");
            return null;
        }
    }

    @Transactional
    public Movie addMovie(Movie m) {
        entityManager.persist(m);
        return m;
    }

    @Transactional
    public Movie updateMovie(String id, Movie m) {
        Movie Movie = entityManager.find(Movie.class, id);
        if (null != Movie) {
            Movie.setTitle(m.getTitle());
            Movie.setDescription(m.getDescription());
            Movie.setStarringActors(m.getStarringActors());
            Movie.setScreenedYear(m.getScreenedYear());
        }
        return Movie;
    }

    @Transactional
    public void deleteMovie(String id) {
        Movie m = getMovie(id);
        entityManager.remove(m);
    }


}

