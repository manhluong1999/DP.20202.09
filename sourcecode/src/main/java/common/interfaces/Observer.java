package common.interfaces;

/**
 * @author
 */
public interface Observer {

    void update(Observable observable);

    void watchDetail(Observable observable);
    void updateCartFromDetail(Observable observable);

}
