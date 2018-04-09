package business;

import facades.AddressFacade;
import facades.CustomerFacade;
import facades.ItemFacade;
import model.Address;
import model.Customer;
import model.Item;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class Init {

    @Inject
    ItemFacade itemFacade;

    @Inject
    CustomerFacade customerFacade;

    @Inject
    AddressFacade addressFacade;

    @PostConstruct
    public void init() {

        // Sample Data
        for (int i = 0; i < 10; i++) {
            Item item = new Item("ItemName {" + i + "}", "ItemDescr", (14 * i));
            itemFacade.save(item);

            Address address = new Address("Street", "City", "Country", "Additional");
            addressFacade.save(address);
            Customer c = new Customer("FirstName {"+i+"}",
                    "LastName {"+i+"}",address);
            customerFacade.save(c);
        }
    }
}
