package views.screen.cart;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import common.exception.MediaUpdateException;
import common.exception.ViewCartException;
import common.interfaces.Observable;
import common.interfaces.Observer;
import controller.SessionInformation;
import entity.cart.Cart;
import entity.cart.CartItem;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import utils.Utils;
import views.screen.FXMLScreenHandler;
import views.screen.ViewsConfig;

public class MediaHandler extends FXMLScreenHandler implements SubjectCart<ObserverCart> {

	private static Logger LOGGER = Utils.getLogger(MediaHandler.class.getName());

	@FXML
	protected HBox hboxMedia;

	@FXML
	protected ImageView image;

	@FXML
	protected VBox description;

	@FXML
	protected Label labelOutOfStock;

	@FXML
	protected VBox spinnerFX;

	@FXML
	protected Label title;

	@FXML
	protected Label price;

	@FXML
	protected Label currency;

	@FXML
	protected Button btnDelete;

	private CartItem cartItem;

	private Spinner<Integer> spinner;

	private CartScreenHandler cartScreen;

	private List<ObserverCart> observerList;


	public MediaHandler(String screenPath, CartScreenHandler cartScreen) throws IOException {
		super(screenPath);
		this.cartScreen = cartScreen;
		hboxMedia.setAlignment(Pos.CENTER);
	}

	// DP - ObserverPattern
	public MediaHandler(String screenPath, CartItem cartItem, CartScreenHandler cartScreen) throws IOException {
		super(screenPath);
		this.observerList = new ArrayList<>();
		this.cartItem = cartItem;
		this.cartScreen = cartScreen;
		setMediaInfo();
		hboxMedia.setAlignment(Pos.CENTER);
	}
	
	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
		setMediaInfo();
//		setMediaInfoObserverPattern();
	}

	private void setMediaInfo() {
		title.setText(cartItem.getMedia().getTitle());
		price.setText(ViewsConfig.getCurrencyFormat(cartItem.getPrice()));
		File file = new File(cartItem.getMedia().getImageURL());
		Image im = new Image(file.toURI().toString());
		image.setImage(im);
		image.setPreserveRatio(false);
		image.setFitHeight(110);
		image.setFitWidth(92);

		// add delete button
		btnDelete.setFont(ViewsConfig.REGULAR_FONT);
		btnDelete.setOnMouseClicked(e -> {
//			try {
//				SessionInformation.cartInstance.removeCartMedia(cartItem); // update user cart
//				cartScreen.updateCart(); // re-display user cart
//
//				notifyRemove();
//
//				LOGGER.info("Deleted " + cartItem.getMedia().getTitle() + " from the cart");
//			} catch (SQLException exp) {
//				exp.printStackTrace();
//				throw new ViewCartException();
//			}
			notifyRemove();
		});

		initializeSpinner();
	}

//	private void setMediaInfoObserverPattern() {
//		title.setText(cartItem.getMedia().getTitle());
//		price.setText(ViewsConfig.getCurrencyFormat(cartItem.getPrice()));
//		File file = new File(cartItem.getMedia().getImageURL());
//		Image im = new Image(file.toURI().toString());
//		image.setImage(im);
//		image.setPreserveRatio(false);
//		image.setFitHeight(110);
//		image.setFitWidth(92);
//
//		// add delete button
//		btnDelete.setFont(ViewsConfig.REGULAR_FONT);
//		btnDelete.setOnMouseClicked(e -> {
//			notifyRemove();
//			LOGGER.info("Deleted " + cartItem.getMedia().getTitle() + " from the cart");
//		});
//
//		initializeSpinner();
//	}

	private void initializeSpinner(){
		SpinnerValueFactory<Integer> valueFactory = //
			new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, cartItem.getQuantity());
		spinner = new Spinner<Integer>(valueFactory);
		spinner.setOnMouseClicked( e -> {
			try {
				int numOfProd = this.spinner.getValue();
				int remainQuantity = cartItem.getMedia().getQuantity();
				LOGGER.info("NumOfProd: " + numOfProd + " -- remainOfProd: " + remainQuantity);
				if (numOfProd > remainQuantity){
					LOGGER.info("product " + cartItem.getMedia().getTitle() + " only remains " + remainQuantity + " (required " + numOfProd + ")");
					labelOutOfStock.setText("Sorry, Only " + remainQuantity + " remain in stock");
					spinner.getValueFactory().setValue(remainQuantity);
					numOfProd = remainQuantity;
				}

				// update quantity of mediaCart in useCart
				cartItem.setQuantity(numOfProd);

				// update the total of mediaCart
				price.setText(ViewsConfig.getCurrencyFormat(numOfProd* cartItem.getPrice()));

				// update subtotal and amount of Cart
//				cartScreen.updateCartAmount();
				notifyObservers();
			} catch (SQLException e1) {
				throw new MediaUpdateException(Arrays.toString(e1.getStackTrace()).replaceAll(", ", "\n"));
			}
			
		});
		spinnerFX.setAlignment(Pos.CENTER);
		spinnerFX.getChildren().add(this.spinner);
	}

	CartItem getCartItem() {
		return this.cartItem;
	}


	@Override
	public void attach(ObserverCart observer) {
		observerList.add(observer);
	}

	@Override
	public void remove(ObserverCart observer) {
		observerList.remove(observer);
	}

	@Override
	public void notifyObservers() {
		observerList.forEach(observer -> observer.update(this));
	}

	@Override
	public void notifyRemove() {
		observerList.forEach(observer -> observer.remove(this));
	}
}