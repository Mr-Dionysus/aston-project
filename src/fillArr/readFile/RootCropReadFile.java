package fillArr.readFile;

import models.RootCrop;
import validation.Validation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RootCropReadFile implements ReadFileStrategy {
    @Override
    public ArrayList<RootCrop> readFile() {
        ArrayList<RootCrop> rootCrops = new ArrayList<>();
        String input;
        // Чтение данных из файла
        try (BufferedReader reader = new BufferedReader(new FileReader("resources/rootcrops.txt"))) {
            while ((input = reader.readLine()) != null) {
                String[] values = input.split(":", 3);
                String type = Validation.removeSymbolsNums(values[0]);
                String weightString = Validation.removeSymbolsWithoutDotLettersSpaces(values[1]);
                double weight = Validation.rootCropWeight(weightString);
                String color = Validation.removeSymbolsNums(values[2]);
                RootCrop rootCrop = new RootCrop.Builder().type(type).weight(weight).color(color).build();

                if (weight == -1) {
                    rootCrop = null;
                }

                rootCrops.add(rootCrop);
            }
        } catch (IOException e) {
            System.out.println("Exception\n");
            rootCrops = null;
        }
        return rootCrops;
    }
}
