package entity.payment;

import java.util.Map;

public interface Card {
    String print();
    void setInfo(Map<String, Object> info);
}
