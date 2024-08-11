package sort;

import model.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSortEvenOdd implements SortingStrategy
{

    @Override
    public void sort(List array, Comparator comparator)
    {
        MergeSort tempSort = new MergeSort();
        List<Car> stored;
        List<Car> modCar;
        modCar = (ArrayList<Car>) array;
        stored = (ArrayList<Car>) array;
        modCar.removeIf(i -> i.getYear()%2 == 0);
        tempSort.sort(modCar, comparator);
        array = mergeOld(modCar, stored, true);
    }

    public void sort(List array, Comparator comparator, boolean even)
    {
        MergeSort tempSort = new MergeSort();
        List<Car> stored;
        List<Car> modCar;
        modCar = (ArrayList<Car>) array;
        stored = (ArrayList<Car>) array;
        if (even) modCar.removeIf(i -> i.getYear()%2 == 0);
        else modCar.removeIf(i -> i.getYear()%2 != 0);
        tempSort.sort(modCar, comparator);
        array = mergeOld(modCar, stored, even);
    }

    private static List<Car> mergeOld(List<Car> a, List<Car> b, Boolean sortEven)
    {
        int t = 0;
        for(int m = 0; m < b.size(); m++)
        {
            if((b.get(m).getYear() % 2) != 0 ^ sortEven)
            {
                b.set(m, a.get(t));
                t++;
            }
        }
        return b;
    }


}
