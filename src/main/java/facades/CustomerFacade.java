package facades;

import model.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CustomerFacade {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Customer c) {
        entityManager.persist(c);
    }

    public List<Customer> load() {
        return entityManager.createNamedQuery("CUSTOMER.GET", Customer.class).getResultList();
    }
}
