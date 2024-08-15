package fillArr.random;

import java.util.ArrayList;

public class FillRandomContext <T>{
    private FillRandomStrategy fillRandomStrategy;

    public FillRandomContext() {
    }

    public void setFillRandomStrategy(FillRandomStrategy fillRandomStrategy) {
        this.fillRandomStrategy = fillRandomStrategy;
    }

    public ArrayList<T> executeFillRandom(int size) {
        return fillRandomStrategy.fillRandom(size);
    }
}
