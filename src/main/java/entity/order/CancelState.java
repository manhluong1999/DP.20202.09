package entity.order;

public class CancelState extends State{

    public CancelState(Order oder) {
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
