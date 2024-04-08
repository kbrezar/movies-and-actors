
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import jakarta.ws.rs.*;
import java.util.List;
import jakarta.inject.*;

@Path("api/actors")
public class ActorEndpoint {

    @Inject
    ActorResource actorResource;
    MeterRegistry registry = Metrics.globalRegistry;
    @Counted(value = "counted.requests")
    @GET
    public List<Actor> getActors() {
        return actorResource.getActors();
    }
    @Counted(value = "counted.requests")
    @GET
    @Path("/page/{pageNum}:{pageSize}")
    public List<Actor> getActorsPaged(@PathParam("pageNum") int pageNum, @PathParam("pageSize") int pageSize) {
        return actorResource.getActorsPaged(pageNum, pageSize);
    }
    @Counted(value = "counted.requests")
    @GET
    @Path("/{id}")
    public Actor getActor(@PathParam("id") String id) {
        return actorResource.getActor(id);
    }
    @Counted(value = "counted.requests")
    @PUT
    @Path("/{id}")
    public Actor putActor(@PathParam("id") String id, Actor a) {
        return actorResource.updateActor(id, a);
    }
    @Counted(value = "counted.requests")
    @POST
    public Actor addActor(Actor a) {
        return actorResource.addActor(a);
    }
    @Counted(value = "counted.requests")
    @DELETE
    @Path("/{id}")
    public void deleteActor(@PathParam("id") String id) {
        actorResource.deleteActor(id);
    }
}
