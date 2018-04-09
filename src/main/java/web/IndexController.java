package web;

import facades.AddressFacade;
import facades.CustomerFacade;
import facades.DeliveryFacade;
import facades.ItemFacade;
import model.*;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Model
@Named
public class IndexController {

    @Inject
    private DeliveryFacade deliveryFacade;

    @Inject
    private CustomerFacade customerFacade;

    @Inject
    private AddressFacade addressFacade;

    @Inject
    private ItemFacade itemFacade;

    private List<Item> items;

    private List<DeliveryItem> deliveryItems;

    private List<Customer> customers;

    private Item itemToAdd;

    private Customer customerToAdd;

    private Address addressToAdd;

    private Delivery deliveryToAdd;

    @PostConstruct
    public void init() {
        itemToAdd = new Item();
        customerToAdd = new Customer();
        addressToAdd = new Address();
        items = itemFacade.load();
        customers = customerFacade.load();
        deliveryToAdd = new Delivery();
    }

    public void addItem() {
        if (itemToAdd != null) {
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

    public void AddItem(Item item) {
        if (item != null) {
            itemFacade.save(item);
        }
    }

    public void selectCustomer(Customer customer) {
        if (customer != null) {
            deliveryToAdd.setCustomer(customer);
        }
    }

    public void deselectCustomer(Customer customer) {
        if (customer != null) {
            deliveryToAdd.setCustomer(null);
        }
    }

    public void addDeliveryItem(Item item) {
        if (item != null) {
            boolean found = false;
            for (int i = 0; i < deliveryItems.size(); i++) {
                if (deliveryItems.get(i).getId() == item.getId()) {
                    deliveryItems.get(i).setAmount(deliveryItems.get(i).getAmount() + 1);
                    found = true;
                }
            }
            if (found == false) {
                DeliveryItem ditem = new DeliveryItem();
                ditem.setAmount(1);
                ditem.setItem(item);
                ditem.setDelivery(deliveryToAdd);
                deliveryItems.add(ditem);
            }
        }
    }

    //region Getter & Setter


    public List<DeliveryItem> getDeliveryItems() {
        return deliveryItems;
    }

    public void setDeliveryItems(List<DeliveryItem> deliveryItems) {
        this.deliveryItems = deliveryItems;
    }

    public Delivery getDeliveryToAdd() {
        return deliveryToAdd;
    }

    public void setDeliveryToAdd(Delivery deliveryToAdd) {
        this.deliveryToAdd = deliveryToAdd;
    }

    public DeliveryFacade getDeliveryFacade() {
        return deliveryFacade;
    }

    public void setDeliveryFacade(DeliveryFacade deliveryFacade) {
        this.deliveryFacade = deliveryFacade;
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

