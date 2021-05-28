package views.screen.home;

import common.interfaces.Observable;
import common.interfaces.Observer;
import entity.media.Media;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import views.screen.BaseScreenHandler;

import java.io.IOException;
import java.util.List;

public abstract class DetailScreenHandler extends BaseScreenHandler implements Observable {

    // Các thuộc tính của JavaFX
    @FXML
    protected Button addToCartBtn;

    private List<Observer> observerList;

    private Media media;

    private MediaHandler mediaHandler;

    protected DetailScreenHandler(Stage stage, String screenPath, MediaHandler mediaHandler) throws IOException {
        super(stage, screenPath);
        this.mediaHandler = mediaHandler;
        this.media = mediaHandler.getMedia();
        try {
            setupFunctionality();
        }catch (Exception exception){
            // Exception
        }
    }

    protected void setupFunctionality() throws Exception {
        // do something else

        addToCartBtn.setOnMouseClicked(e -> {
            notifyObservers();
            // back to HomeScreen
            homeScreenHandler.show();
        });

        // do something else
    }

    public MediaHandler getMediaHandler() {
        return this.mediaHandler;
    }

    public void show() {
        // do something here

        setContent();

        // do something else
    }

    abstract void setContent();

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observerList.forEach(observer -> observer.updateCartFromDetail(this));
    }


}
