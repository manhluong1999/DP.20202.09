package views.screen.home;

import javafx.stage.Stage;

import java.io.IOException;

public class BookDetailScreenHandler extends DetailScreenHandler{

    protected BookDetailScreenHandler(Stage stage, String screenPath, MediaHandler mediaHandler) throws IOException {
        super(stage, screenPath, mediaHandler);
    }

    @Override
    void setContent() {
        System.out.println("Content Book");
    }


}
