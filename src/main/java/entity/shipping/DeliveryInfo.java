package entity.shipping;

import entity.order.Order;
import org.example.DistanceCalculator;

/*
* Date: 22/05/2021
* Author: Minh
* Subject: Cohesion - Stamp
* Reason: calculateShippingFee() truyền order nhưng không sử dụng
* */

/*
 * Date: 22/05/2021
 * Author: Minh
 * Subject: SOLID - OCP, DIP
 * Reason: Khi thêm cách tính distance mới việc thay đổi lại code là thiết yếu, và việc giao tiếp cụ thể phải chỉnh sửa
 * Solutions: StrategyPattern or Abstract Factory
 * */

public class DeliveryInfo {

    protected String name;
    protected String phone;
    protected String province;
    protected String address;
    protected String shippingInstructions;
    protected DistanceCalculator distanceCalculator;

    public DeliveryInfo(String name, String phone, String province, String address, String shippingInstructions, DistanceCalculator distanceCalculator) {
        this.name = name;
        this.phone = phone;
        this.province = province;
        this.address = address;
        this.shippingInstructions = shippingInstructions;
        this.distanceCalculator = distanceCalculator;
    }
    public int calculateShippingFee(Order order) {
        int distance = distanceCalculator.calculateDistance(address, province);
        return (int) (distance * 1.2);
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
