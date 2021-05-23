package common.interfaces;

/**
 * @author
 */
public interface Observable<T> {

    void attach(T observer);
    void remove(T observer);
    void notifyObservers();

}
