package controller;

import java.sql.SQLException;

import entity.cart.Cart;

/**
 * This class controls the flow of events when users view the Cart
 * @author nguyenlm
 */

/*
* Date: 22/05/2021
* Author: Minh
* Subject: Cohesion - Coincidental
* Reason: checkAvailabilityOfProduct nên phụ thuộc vào từng Product
* */

/*
* Date: 22/05/2021
* Author: Minh
* Subject: SOLID - SRP
* Reason: Class đang thực hiện thêm checkAvailabilityOfProduct() mà bản chất không phải nhiệm vụ class
* */
public class ViewCartController extends BaseController{
    
    /**
     * This method checks the available products in Cart
     * @throws SQLException
     */
    public void checkAvailabilityOfProduct() throws SQLException{
        SessionInformation.cartInstance.checkAvailabilityOfProduct();
    }

    /**
     * This method calculates the cart subtotal
     * @return subtotal
     */
    public int getCartSubtotal(){
        int subtotal = SessionInformation.cartInstance.calSubtotal();
        return subtotal;
    }

}
