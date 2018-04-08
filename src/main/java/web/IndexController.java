package web;


import facades.CustomerFacade;
import model.Customer;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

@Model
@Named
public class IndexController {

    @Inject
    private CustomerFacade customerFacade;

    private Customer customerToAdd;


    @PostConstruct
    public void init() {
        customerToAdd = new Customer();
    }

    public void addCustomer() {
        if (customerToAdd != null)
            this.customerFacade.save(customerToAdd);
    }

    public Customer getCustomerToAdd() {
        return customerToAdd;
    }

    public void setCustomerToAdd(Customer customerToAdd) {
        this.customerToAdd = customerToAdd;
    }
}
