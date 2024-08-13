package strategy;

import java.util.ArrayList;

public interface ReadFileStrategy<T> {
    ArrayList<T> readFile();
}
