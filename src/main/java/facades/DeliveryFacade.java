package facades;

import model.Delivery;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DeliveryFacade {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Delivery d) {
        entityManager.persist(d);
    }

    public List<Delivery> load() {
        return entityManager.createNamedQuery("DELIVERY.GET", Delivery.class).getResultList();
    }
}
