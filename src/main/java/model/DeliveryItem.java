package model;

import javax.persistence.*;

@Entity
@Table(name = "DELIVERY_ITEM")
public class DeliveryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Item item;

    @ManyToOne(fetch = FetchType.EAGER)
    private Delivery delivery;

    private int amount;

    public DeliveryItem(Item item, Delivery delivery, int amount) {
        this.item = item;
        this.delivery = delivery;
        this.amount = amount;
    }

    public DeliveryItem() { }

    //region Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    //endregion
}
