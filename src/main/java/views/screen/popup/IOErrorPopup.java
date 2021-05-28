package views.screen.popup;

import java.io.IOException;

public class IOErrorPopup implements IOErrorInterface {
    @Override
    public void error() throws IOException {
        PopupScreen.error("Error when loading resources");
    }
}
