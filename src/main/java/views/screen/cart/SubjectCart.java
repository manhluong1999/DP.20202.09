package views.screen.cart;

import common.interfaces.Observable;

public interface SubjectCart<T> extends Observable<T> {
    void notifyRemove();
}
