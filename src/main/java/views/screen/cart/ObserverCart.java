package views.screen.cart;

import common.interfaces.Observable;
import common.interfaces.Observer;

public interface ObserverCart extends Observer {
    void remove(Observable observable);
}
