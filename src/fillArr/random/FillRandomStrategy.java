package fillArr.random;

import java.util.ArrayList;

public interface FillRandomStrategy<T> {
    ArrayList<T> fillRandom(int size);
}
