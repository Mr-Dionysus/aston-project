package fillArr.readFile;

import java.util.ArrayList;

public class ReadFileContext<T> {

    private ReadFileStrategy<T> readFileStrategy;

    public ReadFileContext() {
    }

    public ReadFileContext(ReadFileStrategy<T> readFileStrategy) {
        this.readFileStrategy = readFileStrategy;
    }

    public void setReadFileStrategy(ReadFileStrategy<T> readFileStrategy) {
        this.readFileStrategy = readFileStrategy;
    }

    public ArrayList<T> executeReadFileStrategy() {
        return readFileStrategy.readFile();
    }


}
