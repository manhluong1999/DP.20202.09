package views.screen.popup;

public abstract class IOErrorText implements IOErrorInterface{

    @Override
    public void error() {
        // Do something here

        setContent();

        // Do something else

    }

    abstract void setContent();
}
