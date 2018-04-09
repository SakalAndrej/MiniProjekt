package facades;

import model.Delivery;
import model.DeliveryItem;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DeliveryItemFacade {

    @PersistenceContext
    EntityManager entityManager;

    public void save(DeliveryItem d) {
        entityManager.persist(d);
    }
}
