package strategy.fillmanually;

public class FillManuallyContext<T> {
    private FillManuallyStrategy fillManuallyStrategy;

    public FillManuallyContext() {
    }

    public void setFillManuallyStrategy(FillManuallyStrategy fillManuallyStrategy) {
        this.fillManuallyStrategy = fillManuallyStrategy;
    }

    public T executeFillManually() {
        return fillManuallyStrategy.fillManually();
    }
}
