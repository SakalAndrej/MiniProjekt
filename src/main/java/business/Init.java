package business;

import facades.ItemFacade;
import model.Item;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
public class Init {

    @Inject
    ItemFacade itemFacade;

    @PostConstruct
    public void init() {
        // Example Data already in Junit Test and Selenium
    }
}
