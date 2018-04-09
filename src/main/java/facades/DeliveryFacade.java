package facades;

import model.Delivery;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DeliveryFacade {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Delivery d) {
        entityManager.persist(d);
    }
}
