package controller;

import entity.cart.Cart;
import entity.user.User;

import java.time.LocalDateTime;

/**
 * @author
 */
/*
*  Coincidental Cohesion: Vì các phần thử trong lớp không liên quan đến nhau
* */
//DP: Singleton pattern vi SessionInformation chi nen duoc tao ra chi 1 instance trong qua trinh chay chuong trinh
public class SessionInformation {

 private User mainUser;
 private Cart cartInstance = Cart.getInstance();
 private LocalDateTime expiredTime;
 private static SessionInformation instance;
 
 private SessionInformation() {
 	cartInstance = Cart.getInstance();
 }
 
 public static SessionInformation getInstance() {
 	if (instance == null) {
 		instance = new SessionInformation();
 	}
 	return instance;
 }
 
 public User getMainUser() {
 	return mainUser;
 }

}
