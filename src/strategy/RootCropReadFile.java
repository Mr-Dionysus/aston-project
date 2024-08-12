package strategy;

import models.RootCrop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RootCropReadFile implements ReadFileStrategy {
    @Override
    public List<RootCrop> ReadFile() {
        List<RootCrop> rootCropList = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("resources/rootcrops.txt"))) {
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(":", 3);
                String type = values[0];
                double weight = Double.parseDouble(values[1]);
                String color = values[2];
                RootCrop rootCrop = new RootCrop.Builder().type(type).weight(weight).color(color).build();
                rootCropList.add(rootCrop);
            }
        } catch (IOException e) {
            System.out.println("Exception\n");
            rootCropList = Collections.emptyList();
        }
        return rootCropList;
    }
}
