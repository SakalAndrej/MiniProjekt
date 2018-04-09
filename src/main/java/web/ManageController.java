package web;

import facades.DeliveryFacade;
import model.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
@Named
public class ManageController {

    @Inject
    private DeliveryFacade deliveryFacade;

    private List<Delivery> deliveryList;

    @PostConstruct
    public void init() {
        deliveryList = new LinkedList<>();
    }

    //region Getter & Setter

    public List<Delivery> getDeliveryList() {
        return deliveryFacade.load();
    }

    public void setDeliveryList(List<Delivery> deliveryList) {
        this.deliveryList = deliveryList;
    }


    //endregion
}
