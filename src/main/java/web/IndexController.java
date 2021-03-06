package web;

import facades.*;
import model.*;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
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

    @Inject
    private DeliveryItemFacade deliveryItemFacade;

    private List<Item> items;

    private List<DeliveryItem> deliveryItems;

    private List<Customer> customers;

    private Item itemToAdd;

    private Customer customerToAdd;

    private Address addressToAdd;

    private Delivery deliveryToAdd;

    private Address destinationToAdd;

    @PostConstruct
    public void init() {
        destinationToAdd = new Address();
        itemToAdd = new Item();
        customerToAdd = new Customer();
        addressToAdd = new Address();
        items = itemFacade.load();
        customers = customerFacade.load();
        deliveryToAdd = new Delivery();
        deliveryItems = new LinkedList<DeliveryItem>();
    }

    public void addItem() {
        if (itemToAdd != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            itemFacade.save(itemToAdd);
            items = itemFacade.load();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Succesfully added Item: " + itemToAdd.getName()));
            itemToAdd = new Item();
        }
    }

    public void addCustomer() {
        if (customerToAdd != null && addressToAdd != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            this.addressFacade.save(addressToAdd);
            this.customerFacade.save(customerToAdd);
            this.customers = customerFacade.load();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Succesfully added Customer"));
            addressToAdd = new Address();
            customerToAdd = new Customer();
        }
    }

    public void saveActDelivery() {
        if (deliveryToAdd != null && destinationToAdd != null && deliveryItems!= null && deliveryItems.size()>0 && deliveryToAdd.getCustomer()!= null) {
            FacesContext context = FacesContext.getCurrentInstance();
            addressFacade.save(destinationToAdd);
            deliveryToAdd.setDestination(destinationToAdd);
            for (int i = 0; i < deliveryItems.size(); i++) {
                deliveryItemFacade.save(deliveryItems.get(i));
            }
            deliveryFacade.save(deliveryToAdd);
            deliveryToAdd = new Delivery();
            destinationToAdd = new Address();
            deliveryItems = new LinkedList<>();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Succesfully added Delivery"));
        }
        else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Error while adding Delivery"));
        }
    }

    public void selectCustomer(Customer customer) {
        FacesContext context = FacesContext.getCurrentInstance();
        if (customer != null) {
            deliveryToAdd.setCustomer(customer);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Selected Customer"));
            }
        else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Error while selecting Customer"));
        }
        RequestContext.getCurrentInstance().update("growl");
    }

    public void deselectCustomer(Customer customer) {
        if (customer != null) {
            deliveryToAdd.setCustomer(null);
        }
    }

    public void addDeliveryItem(Item item) {
        FacesContext context = FacesContext.getCurrentInstance();
        if (item != null) {
            boolean found = false;
            for (int i = 0; i < deliveryItems.size(); i++) {
                if (deliveryItems.get(i).getItem().getId() == item.getId()) {
                    deliveryItems.get(i).setAmount(deliveryItems.get(i).getAmount() + 1);
                    deliveryItems.get(i).getItem().setWeight(deliveryItems.get(i).getItem().getWeight() * 3);
                    found = true;
                }
            }
            if (found == false) {
                DeliveryItem ditem = new DeliveryItem();
                ditem.setAmount(1);
                ditem.setItem(item);
                deliveryItems.add(ditem);
            }
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Added item to delivery"));
        }
        else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Error editing item"));
        }
    }

    //region Getter & Setter


    public Address getDestinationToAdd() {
        return destinationToAdd;
    }

    public void setDestinationToAdd(Address destinationToAdd) {
        this.destinationToAdd = destinationToAdd;
    }

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

