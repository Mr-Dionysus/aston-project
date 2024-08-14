package strategy.readfile;

import exceptions.ValidateException;
import models.RootCrop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RootCropReadFile implements ReadFileStrategy {
    @Override
    public ArrayList<RootCrop> readFile() {
        ArrayList<RootCrop> rootCropList = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("resources/rootcrops.txt"))) {
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(":", 3);
                if (values.length == 3) {
                    String type = values[0];
                    double weight = Double.parseDouble(values[1]);
                    String color = values[2];
                    RootCrop rootCrop = new RootCrop.Builder().type(type).weight(weight).color(color).build();
                    rootCropList.add(rootCrop);
                }
            }
        } catch (IOException | ValidateException | NumberFormatException e) {
            System.out.println("Некоректные данные в файле");
            rootCropList = null;
        }
        return rootCropList;
    }
}
