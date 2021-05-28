package views.screen.home;

import javafx.stage.Stage;

import java.io.IOException;

public class DVDDetailScreenHandler extends DetailScreenHandler{

    protected DVDDetailScreenHandler(Stage stage, String screenPath, MediaHandler mediaHandler) throws IOException {
        super(stage, screenPath, mediaHandler);
    }

    @Override
    void setContent() {
        System.out.println("Content DVD");
        
    }
}
