package models;

import java.util.ArrayList;
import java.util.Random;

public class RootCrop {
    private final String type;
    private final double weight;
    private final String color;
    // Данные для случайной генерации
    static String[] types = {"Turnip", "Carrot", "Beet", "Radish", "Cabbage", "Potato"};
    static String[] colors = {"yellow", "red", "green", "brown"};

    RootCrop(Builder builder) {
        this.type = builder.type;
        this.weight = builder.weight;
        this.color = builder.color;
    }

    public String getType() {
        return type.toLowerCase();
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color.toLowerCase();
    }

    @Override
    public String toString() {
        return "Type: " + this.type + " | Weight: " + this.weight + " | Color: " + this.color;
    }

    public static class Builder {
        private String type;
        private double weight;
        private String color;

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder weight(Double weight) {
            this.weight = weight;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public RootCrop build() {
            return new RootCrop(this);
        }
    }

    // Случайная генерация корнеплода
    public static ArrayList<RootCrop> createObjects(int length) {
        ArrayList<RootCrop> rootCropList = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            rootCropList.add(new Builder().type(randomType()).weight(randomWeight()).color(randomColor()).build());
        }
        return rootCropList;
    }

    static Random random = new Random();

    private static Double randomWeight() {
        return (double) Math.round(random.nextDouble(0.01, 5) * 100) / 100;
    }

    private static String randomColor() {
        return colors[random.nextInt(1, colors.length)];
    }

    private static String randomType() {
        return types[random.nextInt(1, types.length)];
    }
}
