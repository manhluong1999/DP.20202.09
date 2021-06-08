package views.screen.popup;

import java.io.IOException;

public class IOErrorHandler {

    private IOErrorInterface ioError;

    public void setIOError(IOErrorInterface ioError){
        this.ioError = ioError;
    }

    public void error() throws IOException {
        ioError.error();
    }

}
