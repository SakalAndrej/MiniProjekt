package web;

import at.htl.exceptions.NoConnectionException;
import at.htl.xiboClient.StatusApi;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDateTime;

@Model
@Named
public class IndexController {

    //@Inject
    //private object statusApi;

    public boolean isServerOnline() {
        return false;
    }
}
