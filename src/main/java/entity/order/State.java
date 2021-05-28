package entity.order;

public abstract class State {
    private Order order;

    public State(Order oder){
        this.order = oder;
    }

    abstract void waitProcess();
    abstract void cancelProcess();
    abstract void successProcess();

}
