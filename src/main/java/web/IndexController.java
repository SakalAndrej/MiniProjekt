package web;


import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

@Model
@Named
public class IndexController {

    @Inject
    //private object statusApi;

    public boolean isServerOnline() {
        return false;
    }
}
