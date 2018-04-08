package web;


import facades.AddressFacade;
import facades.CustomerFacade;
import model.Address;
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

    @Inject
    private AddressFacade addressFacade;

    private Customer customerToAdd;

    private Address addressToAdd;

    @PostConstruct
    public void init() {
        customerToAdd = new Customer();
        addressToAdd = new Address();
    }

    public void addCustomer() {
        if (customerToAdd != null && addressToAdd != null) {
            this.addressFacade.save(addressToAdd);
            this.customerFacade.save(customerToAdd);
        }
    }

    public Customer getCustomerToAdd() {
        return customerToAdd;
    }

    public void setCustomerToAdd(Customer customerToAdd) {
        this.customerToAdd = customerToAdd;
    }

    public CustomerFacade getCustomerFacade() {
        return customerFacade;
    }

    public void setCustomerFacade(CustomerFacade customerFacade) {
        this.customerFacade = customerFacade;
    }

    public AddressFacade getAddressFacade() {
        return addressFacade;
    }

    public void setAddressFacade(AddressFacade addressFacade) {
        this.addressFacade = addressFacade;
    }

    public Address getAddressToAdd() {
        return addressToAdd;
    }

    public void setAddressToAdd(Address addressToAdd) {
        this.addressToAdd = addressToAdd;
    }
}
