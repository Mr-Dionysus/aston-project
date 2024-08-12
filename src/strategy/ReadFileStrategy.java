package strategy;

import java.util.List;

public interface ReadFileStrategy<T> {
    List<T> readFile();
}
