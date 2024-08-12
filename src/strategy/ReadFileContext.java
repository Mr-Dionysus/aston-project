package strategy;

import java.util.List;

public class ReadFileContext<T>{

    private ReadFileStrategy<T> readFileStrategy;

    public ReadFileContext() {
    }

    public ReadFileContext(ReadFileStrategy<T> readFileStrategy) {
        this.readFileStrategy = readFileStrategy;
    }

    public void setReadFileStrategy(ReadFileStrategy<T> readFileStrategy) {
        this.readFileStrategy = readFileStrategy;
    }

    public List<T> executeReadFileStrategy() {
        return readFileStrategy.readFile();
    }


}
