package facades;

import model.Address;
import model.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AddressFacade {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Address a) {
        entityManager.persist(a);
    }
}
