package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DELIVERY")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    private Address destination;

    @OneToMany(fetch = FetchType.EAGER)
    private List<DeliveryItem> deliveryItems;

    public double weight;

    public Delivery(Customer customer, Address destination, double weight) {
        this.customer = customer;
        this.destination = destination;
        this.weight = weight;
    }

    public Delivery() { }

    //region Getter & Setter

    public Long getDV_ID() {
        return id;
    }

    public void setDV_ID(Long DV_ID) {
        this.id = DV_ID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getDestination() {
        return destination;
    }

    public void setDestination(Address destination) {
        this.destination = destination;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    //endregion

}
