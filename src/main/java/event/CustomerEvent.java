package event;

import bean.CustomerBean;

/**
 * Created by darshan.mistry on 10/30/2015.
 */
public class CustomerEvent {

    private CustomerBean obj;

    public CustomerEvent(CustomerBean obj) {
        this.obj = obj;
    }

    public CustomerBean getObj() {
        return obj;
    }
}
