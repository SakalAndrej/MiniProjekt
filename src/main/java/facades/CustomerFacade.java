package facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CustomerFacade {

    @PersistenceContext
    EntityManager entityManager;
}
