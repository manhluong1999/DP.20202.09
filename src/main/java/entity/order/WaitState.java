package entity.order;

public class WaitState extends State{

    public WaitState(Order oder) {
        super(oder);
    }

    @Override
    void waitProcess() {
        // do Something here
    }

    @Override
    void cancelProcess() {
        // do Something here
    }

    @Override
    void successProcess() {
        // do Something here
    }
}
