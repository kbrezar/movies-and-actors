
import jakarta.ws.rs.*;
import java.util.List;
import jakarta.inject.*;

@Path("api/actors")
public class ActorEndpoint {

    @Inject
    ActorResource actorResource;

    @GET
    public List<Actor> getActors() {
        return actorResource.getActors();
    }

    @GET
    @Path("/page/{pageNum}:{pageSize}")
    public List<Actor> getActorsPaged(@PathParam("pageNum") int pageNum, @PathParam("pageSize") int pageSize) {
        return actorResource.getActorsPaged(pageNum, pageSize);
    }

    @GET
    @Path("/{id}")
    public Actor getActor(@PathParam("id") String id) {
        return actorResource.getActor(id);
    }

    @PUT
    @Path("/{id}")
    public Actor putActor(@PathParam("id") String id, Actor a) {
        return actorResource.updateActor(id, a);
    }

    @POST
    public Actor addActor(Actor a) {
        return actorResource.addActor(a);
    }

    @DELETE
    @Path("/{id}")
    public void deleteActor(@PathParam("id") String id) {
        actorResource.deleteActor(id);
    }
}
