package web;

import facades.AddressFacade;
import facades.CustomerFacade;
import facades.ItemFacade;
import model.Address;
import model.Customer;
import model.Item;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Model
@Named
public class IndexController {

    @Inject
    private CustomerFacade customerFacade;

    @Inject
    private AddressFacade addressFacade;

    @Inject
    private ItemFacade itemFacade;

    private List<Item> items;

    private List<Customer> customers;

    private Item itemToAdd;

    private Customer customerToAdd;

    private Address addressToAdd;

    @PostConstruct
    public void init() {
        itemToAdd = new Item();
        customerToAdd = new Customer();
        addressToAdd = new Address();
        items = itemFacade.load();
        customers = customerFacade.load();
    }

    public void addItem() {
        if (itemToAdd!=null) {
            itemFacade.save(itemToAdd);
            items = itemFacade.load();
        }
    }

    public void addCustomer() {
        if (customerToAdd != null && addressToAdd != null) {
            this.addressFacade.save(addressToAdd);
            this.customerFacade.save(customerToAdd);
            this.customers = customerFacade.load();
        }
    }

    //region Getter & Setter

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

    public Item getItemToAdd() {
        return itemToAdd;
    }

    public void setItemToAdd(Item itemToAdd) {
        this.itemToAdd = itemToAdd;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
    //endregion
}

