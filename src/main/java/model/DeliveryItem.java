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

    private int amount;

    public DeliveryItem(Item item, int amount) {
        this.item = item;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    //endregion
}
