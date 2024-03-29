package views.screen.payment;

import controller.PaymentController;
import entity.invoice.Invoice;
import entity.payment.Card;
import entity.payment.CardFactory;
import entity.payment.CreditCard;
import entity.payment.CreditCardFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.ViewsConfig;
import views.screen.popup.PopupScreen;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.logging.Logger;

public class PaymentScreenHandler extends BaseScreenHandler {

	private static final Logger LOGGER = Utils.getLogger(PaymentScreenHandler.class.getName());

	@FXML
	private Button btnConfirmPayment;

	@FXML
	private ImageView loadingImage;

	private Invoice invoice;

	@FXML
	private Label pageTitle;

	@FXML
	private TextField cardNumber;

	@FXML
	private TextField holderName;

	@FXML
	private TextField expirationDate;

	@FXML
	private TextField securityCode;

	private Map<String, Object> model = new Hashtable<>();

	public PaymentScreenHandler(Stage stage, String screenPath, Invoice invoice) throws IOException {
		super(stage, screenPath);
		try {
			setupData(invoice);
			setupFunctionality();
		} catch (IOException ex) {
			LOGGER.info(ex.getMessage());
			PopupScreen.error("Error when loading resources.");
		} catch (Exception ex) {
			LOGGER.info(ex.getMessage());
			PopupScreen.error(ex.getMessage());
		}
	}

	protected void setupData(Object dto) throws Exception {
		this.invoice = (Invoice) dto;
	}

	protected void setupFunctionality() throws Exception {
		btnConfirmPayment.setOnMouseClicked(e -> {
			try {
				confirmToPayOrder();
				((PaymentController) getBController()).emptyCart();
			} catch (Exception exp) {
				System.out.println(exp.getStackTrace());
			}
		});
	}

	void confirmToPayOrder() throws IOException{
		String contents = "pay order";
		PaymentController ctrl = (PaymentController) getBController();

		/*
		* Select các option thanh toán -> Khởi tạo đối tượng hình thức thanh toán
		* */

		Map<String, String> response = new Hashtable<>();
		try {
			model.put("cardCode", cardNumber.getText());
			model.put("owner", holderName.getText());
			model.put("dateExpired", ctrl.getExpirationDate(expirationDate.getText()));
			model.put("cvvCode", Integer.parseInt(securityCode.getText()));

			/**
			 * if (option) {
			 *
			 * }else{
			 *
			 * }
			 *
			 */

			CreditCard card = new CreditCard(cardNumber.getText(), holderName.getText(), ctrl.getExpirationDate(expirationDate.getText()), Integer.parseInt(securityCode.getText()));

			response = ctrl.payOrderRefactor(invoice.getAmount(), contents, card);
		}catch (Exception exception){
			response.put("RESULT", "PAYMENT FAILED!");
			response.put("MESSAGE", exception.getMessage());
		}
//
//		Map<String, String> response = ctrl.payOrder(invoice.getAmount(), contents, cardNumber.getText(), holderName.getText(),
//				expirationDate.getText(), securityCode.getText());

		BaseScreenHandler resultScreen = new ResultScreenHandler(this.stage, ViewsConfig.RESULT_SCREEN_PATH, response);
		resultScreen.setPreviousScreen(this);
		resultScreen.setHomeScreenHandler(homeScreenHandler);
		resultScreen.setScreenTitle("Result Screen");
		resultScreen.show();
	}
}