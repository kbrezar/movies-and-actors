
import jakarta.ws.rs.*;
import java.util.List;
import jakarta.inject.*;

@Path("/api/movies")
class MovieEndpoint {

    @Inject
    MovieResource movieResource;

    @GET
    public List<Movie> getMovies() {
        return movieResource.getMovies();
    }

    @GET
    @Path("/page/{pageNum}:{pageSize}")
    public List<Movie> getMoviesPaged(@PathParam("pageNum") int pageNum, @PathParam("pageSize") int pageSize) {
        return movieResource.getMoviesPaged(pageNum, pageSize);
    }

    @GET
    @Path("/{id}")
    public Movie getMovie(@PathParam("id") String id) {
        return movieResource.getMovie(id);
    }

    @GET
    @Path("/search/{query}")
    public Movie findMovie(@PathParam("query") String query) { return movieResource.searchForMovieByTitle(query); }

    @PUT
    @Path("/{id}")
    public Movie putMovie(@PathParam("id") String id, Movie m) {
        return movieResource.updateMovie(id, m);
    }

    @POST
    public Movie addMovie(Movie m) {
        return movieResource.addMovie(m);
    }

    @DELETE
    @Path("/{id}")
    public void deleteMovie(@PathParam("id") String id) {
        movieResource.deleteMovie(id);
    }
}
