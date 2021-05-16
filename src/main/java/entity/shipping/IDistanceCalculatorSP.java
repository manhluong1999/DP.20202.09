package entity.shipping;


/**
 * Điều kiện ràng buộc để áp dụng StrategyPattern : Tham số truyền vào calculateDistance mặc định giống nhau. Hiện tại param truyền vào giống nhau nên có thể áp dụng được
* StrategyPattern : Chúng ta có 2 cách tính AltDítanceCalculator or DistanceCalculator
 * */
public interface IDistanceCalculatorSP {
    int calculateDistance(String address, String province);
}
