package fillArr.random;

import models.RootCrop;

import java.util.ArrayList;
import java.util.Random;

public class RootCropFillRandom implements FillRandomStrategy{

    // Данные для случайной генерации
    String[] types = {"Turnip", "Carrot", "Beet", "Radish", "Cabbage", "Potato"};
    String[] colors = {"yellow", "red", "green", "brown"};

    Random random = new Random();

    private Double randomWeight() {
        return (double) Math.round(random.nextDouble(0.01, 5) * 100) / 100;
    }

    private String randomColor() {
        return colors[random.nextInt(1, colors.length)];
    }

    private String randomType() {
        return types[random.nextInt(1, types.length)];
    }

    @Override
    public ArrayList<RootCrop> fillRandom(int size) {
        ArrayList<RootCrop> rootCropList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            rootCropList.add(new RootCrop.Builder().type(randomType()).weight(randomWeight()).color(randomColor()).build());
        }

        return rootCropList;
    }
}
