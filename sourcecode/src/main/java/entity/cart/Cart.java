package entity.cart;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.exception.MediaNotAvailableException;
import entity.media.Media;

/*
* Date: 22/05/2021
* Author: Minh
* Subject: DesignPattern - Singleton
* Reason: Cart cần 1 instance trong thời gian runtime => áp dụng Singleton
* */

/*
 * Date: 22/05/2021
 * Author: Minh
 * Subject: SOLID - SRP
 * Reason: việc checkAvailabilityOfProduct() nên để cho media tự kiểm tra số lượng
 * */

/*
 * Date: 22/05/2021
 * Author: Minh
 * Subject: Coupling - Stamp
 * Reason: Method checkMediaInCart() chỉ sự dụng đến mediaId việc truyền cả Media là thừa thãi
 * */


public class Cart {
    private static Cart _instance;
    
    private List<CartItem> lstCartItem;

    private Cart() {
        lstCartItem = new ArrayList<>();
    }
    public static Cart getInstance() {
    	if(null == _instance) {
    		_instance = new Cart();
    	}
    	return _instance;
    }

    public void addCartMedia(CartItem cm){
        lstCartItem.add(cm);
    }

    public void removeCartMedia(CartItem cm){
        lstCartItem.remove(cm);
    }

    public List getListMedia(){
        return lstCartItem;
    }

    public void emptyCart(){
        lstCartItem.clear();
    }

    public int getTotalMedia(){
        int total = 0;
        for (Object obj : lstCartItem) {
            CartItem cm = (CartItem) obj;
            total += cm.getQuantity();
        }
        return total;
    }

    public int calSubtotal(){
        int total = 0;
        for (Object obj : lstCartItem) {
            CartItem cm = (CartItem) obj;
            total += cm.getPrice()*cm.getQuantity();
        }
        return total;
    }

    public void checkAvailabilityOfProduct() throws SQLException{
        boolean allAvailable = true;
        for (Object object : lstCartItem) {
            CartItem cartItem = (CartItem) object;
            int requiredQuantity = cartItem.getQuantity();
            int availQuantity = cartItem.getMedia().getQuantity();
            if (requiredQuantity > availQuantity) allAvailable = false;
        }
        if (!allAvailable) throw new MediaNotAvailableException("Some media not available");
    }

    public CartItem checkMediaInCart(Media media){
        for (CartItem cartItem : lstCartItem) {
            if (cartItem.getMedia().getId() == media.getId()) return cartItem;
        }
        return null;
    }

}
