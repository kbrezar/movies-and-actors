import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.inject.*;

import java.util.List;


@Singleton
public class ActorResource {
    @Inject
    EntityManager entityManager;

    public List<Actor> getActors() {
        return entityManager.createQuery("SELECT a FROM Actor a", Actor.class).getResultList();
    }

    public List<Actor> getActorsPaged(int pageNum, int pageSize) {
        return entityManager.createQuery("SELECT a FROM Actor a", Actor.class).setFirstResult((pageNum-1)*pageSize).setMaxResults(pageSize).getResultList();
    }

    public Actor getActor(String id) {
        return entityManager.find(Actor.class, id);
    }

    @Transactional
    public Actor addActor(Actor a) {
        entityManager.persist(a);
        return a;
    }

    @Transactional
    public Actor updateActor(String id, Actor a) {
        Actor actor = entityManager.find(Actor.class, id);
        if (null != actor) {
            actor.setFirstName(a.getFirstName());
            actor.setLastName(a.getLastName());
            actor.setBornDate(a.getBornDate());
            actor.setMoviesStarred(a.getMoviesStarred());
        }
        return actor;
    }

    @Transactional
    public void deleteActor(String id) {
        Actor a = getActor(id);
        entityManager.remove(a);
    }


}
