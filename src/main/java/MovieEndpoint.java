
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import jakarta.ws.rs.*;
import java.util.List;
import jakarta.inject.*;

@Path("/api/movies")
class MovieEndpoint {

    @Inject
    MovieResource movieResource;
    MeterRegistry registry = Metrics.globalRegistry;
    @Counted(value = "counted.requests")
    @GET
    public List<Movie> getMovies() {
        return movieResource.getMovies();
    }
    @Counted(value = "counted.requests")
    @GET
    @Path("/page/{pageNum}:{pageSize}")
    public List<Movie> getMoviesPaged(@PathParam("pageNum") int pageNum, @PathParam("pageSize") int pageSize) {
        return movieResource.getMoviesPaged(pageNum, pageSize);
    }
    @Counted(value = "counted.requests")
    @GET
    @Path("/{id}")
    public Movie getMovie(@PathParam("id") String id) {
        return movieResource.getMovie(id);
    }
    @Counted(value = "counted.requests")
    @GET
    @Path("/search/{query}")
    public Movie findMovie(@PathParam("query") String query) { return movieResource.searchForMovieByTitle(query); }
    @Counted(value = "counted.requests")
    @PUT
    @Path("/{id}")
    public Movie putMovie(@PathParam("id") String id, Movie m) {
        return movieResource.updateMovie(id, m);
    }
    @Counted(value = "counted.requests")
    @POST
    public Movie addMovie(Movie m) {
        return movieResource.addMovie(m);
    }
    @Counted(value = "counted.requests")
    @DELETE
    @Path("/{id}")
    public void deleteMovie(@PathParam("id") String id) {
        movieResource.deleteMovie(id);
    }
}
