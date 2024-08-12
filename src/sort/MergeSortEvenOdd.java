package sort;

import models.Book;
import models.Car;
import models.RootCrop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSortEvenOdd<T> implements SortingStrategy<T>
{
    //Различные варианты вызова сортировки. array - сортируемый лист, компаратор - сортируемое поле,
    //type - сортируемое поле овверайд, even - true чёт, false - нечёт, по умолчанию true.
    @Override
    public void sort(List<T> array, Comparator<? super T> comparator)
    {
        sort(array,comparator,true);
    }

    public void sort(List<T> array, Comparator<? super T> comparator, boolean even)
    {
        sort(array, comparator, "default", even);
    }

    public void sort(List<T> array, Comparator<? super T> comparator, String type)
    {
        sort(array,comparator,type,true);
    }

    public void sort(List<T> array, Comparator<? super T> comparator, String type, boolean even)
    {
        //Не сортируем листки с 1 значением
        if (array.size() <= 1)
        {
            return;
        }
        sortEvenOdd(array,comparator,type,even);
    }

    private void sortEvenOdd(List<T> array, Comparator<? super T> comparator, String type, boolean even)
    {
        //Валидация листа
        T example = array.getFirst();
        switch (type)
        {
            case "Year":
            case "Power":
                if (example instanceof Car)
                {
                    sortCaseCar((List<Car>) array, comparator, type, even);
                }
                break;
            case "Pages":
                if (example instanceof Book)
                {
                    sortCaseBook((List<Book>) array,comparator,type,even);
                }
                break;
            case "Weight":
                if (example instanceof RootCrop)
                {
                    sortCaseCrop((List<RootCrop>) array,comparator,type,even);
                }
                break;
            //Поле сортировки по умолчанию.
            default:
                if (example instanceof Car)
                {
                    sortCaseCar((List<Car>) array, comparator, "Year", even);
                } else if (example instanceof Book)
                {
                    sortCaseBook((List<Book>) array,comparator,"Pages",even);
                } else if (example instanceof  RootCrop)
                {
                    sortCaseCrop((List<RootCrop>) array,comparator,"Weight",even);
                } else
                {
                    System.out.println("Exception: Wrong sorting parameter");
                }
        }
    }

    private void sortCaseCar(List<Car> array, Comparator<? super T> comparator, String type, boolean even)
    {
        //Делаем копию листа
        List<Car> stored = new ArrayList<>();
        for (int i = 0; i < array.size(); i++)
        {
            stored.add(array.get(i));
        }
        //Удаляем все чёт/нечёт из копии, сортируем копию, передаём копию на мерж с основным листом
        SortingContext sortingContext = new SortingContext<>(new MergeSort<>());
        switch (type)
        {
            case "Year":
                Comparator<Car> compareToYear = Comparator.comparingInt(Car::getYear);
                if (even) stored.removeIf(i -> i.getYear() % 2 != 0);
                else stored.removeIf(i -> i.getYear() % 2 == 0);
                sortingContext.performSort(stored, compareToYear);
                mergeCaseCar(stored, array, type, even);
                break;
            case "Power":
                Comparator<Car> compareToPower = Comparator.comparingInt(Car::getPower);
                if (even) stored.removeIf(i -> i.getPower() % 2 != 0);
                else stored.removeIf(i -> i.getPower() % 2 == 0);
                sortingContext.performSort(stored, compareToPower);
                mergeCaseCar(stored, array, type, even);
                break;
        }
    }

    private void sortCaseBook(List<Book> array, Comparator<? super T> comparator, String type, boolean even)
    {
        List<Book> stored = new ArrayList<>();
        for (int i = 0; i < array.size(); i++)
        {
            stored.add(array.get(i));
        }
        SortingContext sortingContext = new SortingContext<>(new MergeSort<>());

        Comparator<Book> compareTo = Comparator.comparingInt(Book::getPages);
        if (even) stored.removeIf(i -> i.getPages() % 2 != 0);
        else stored.removeIf(i -> i.getPages() % 2 == 0);
        sortingContext.performSort(stored, compareTo);
        mergeCaseBook(stored, array, type, even);

    }

    private void sortCaseCrop(List<RootCrop> array, Comparator<? super T> comparator, String type, boolean even)
    {
        List<RootCrop> stored = new ArrayList<>();
        for (int i = 0; i < array.size(); i++)
        {
            stored.add(array.get(i));
        }
        SortingContext sortingContext = new SortingContext<>(new MergeSort<>());

        Comparator<RootCrop> compareTo = Comparator.comparingDouble(RootCrop::getWeight);
        if (even) stored.removeIf(i -> i.getWeight() % 2 != 0);
        else stored.removeIf(i -> i.getWeight() % 2 == 0);
        sortingContext.performSort(stored, compareTo);
        mergeCaseCrop(stored, array, type, even);

    }

    private void mergeCaseCar(List<Car> stored, List<Car> array, String type, Boolean sortEven)
    {
        //Итерируем по оригиналу и заменяем прошлые значения чёт/нечёт на сортированые.
        int t = 0;
        switch (type)
        {
            case "Year":
                for (int m = 0; m < array.size(); m++)
                {
                    if ((array.get(m).getYear() % 2) != 0 ^ sortEven)
                    {
                        array.set(m, stored.get(t));
                        t++;
                    }
                }
                break;
            case "Power":
                for (int m = 0; m < array.size(); m++)
                {
                    if ((array.get(m).getPower() % 2) != 0 ^ sortEven)
                    {
                        array.set(m, stored.get(t));
                        t++;
                    }
                }
                break;
            default:
        }
    }

    private void mergeCaseBook(List<Book> stored, List<Book> array, String type, Boolean sortEven)
    {
        int t = 0;
        for (int m = 0; m < array.size(); m++)
        {
            if ((array.get(m).getPages() % 2) != 0 ^ sortEven)
            {
                array.set(m, stored.get(t));
                t++;
            }
        }
    }

    private void mergeCaseCrop(List<RootCrop> stored, List<RootCrop> array, String type, Boolean sortEven)
    {
        int t = 0;
        for (int m = 0; m < array.size(); m++)
        {
            if ((array.get(m).getWeight() % 2) != 0 ^ sortEven)
            {
                array.set(m, stored.get(t));
                t++;
            }
        }
    }
}
