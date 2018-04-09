package facades;

import model.Item;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ItemFacade {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Item i) {
        entityManager.persist(i);
    }

    public List<Item> load() {
        return entityManager.createNamedQuery("ITEM.GET").getResultList();
    }
}
