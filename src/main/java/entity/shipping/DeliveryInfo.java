package entity.shipping;

import entity.order.Order;
import org.example.DistanceCalculator;

/**
 * StrategyPattern: Thêm hàm setDistanceCalculator
 */
public class DeliveryInfo {

    protected String name;
    protected String phone;
    protected String province;
    protected String address;
    protected String shippingInstructions;
    protected IDistanceCalculatorSP distanceCalculator;

    public DeliveryInfo(String name, String phone, String province, String address, String shippingInstructions) {
        this.name = name;
        this.phone = phone;
        this.province = province;
        this.address = address;
        this.shippingInstructions = shippingInstructions;
    }
    //stamp coupling vì truyền cả object Order mà ko sử dụng attribute nào
    public int calculateShippingFee(Order order) {
        int distance = distanceCalculator.calculateDistance(address, province);
        return (int) (distance * 1.2);
    }

    public void setDistanceCalculator(IDistanceCalculatorSP distanceCalculator){
        this.distanceCalculator = distanceCalculator;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getProvince() {
        return province;
    }

    public String getAddress() {
        return address;
    }

    public String getShippingInstructions() {
        return shippingInstructions;
    }
}
