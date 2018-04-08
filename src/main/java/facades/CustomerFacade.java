package facades;

import model.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CustomerFacade {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Customer c) {
        entityManager.persist(c);
    }
}
