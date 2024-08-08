import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort {
	public <T> void mergeSort(List<T> array, Comparator<? super T> comparator) {
		// Проверка на минимальное количество элементов в массиве (min 2)
		if (array.size() <= 1) {
			return;
		}

		// Находим середину массива
		int middle = array.size() / 2;
		// Выделяем левую часть массива от 0 до середины
		List<T> left = new ArrayList<>(array.subList(0, middle));
		// Выделяем правую часть массива от середины до конца
		List<T> right = new ArrayList<>(array.subList(middle, array.size()));

		// Сортируем левую часть массива
		mergeSort(left, comparator);
		// Сортируем правую часть массива
		mergeSort(right, comparator);
		//Соеденияем части в один массив
		merge(array, left, right, comparator);
	}

	// Метод для слияние двух отсортированных частей (левой и правой)
	private <T> void merge(List<T> array, List<T> left, List<T> right, Comparator<? super T> comparator) {
		// Переменные для работы логики
		int i = 0, j = 0, k = 0;

		// Сравниваем элементы из обеих частей и добавляем в исходынй массив на свои места
		while (i < left.size() && j < right.size()) {
			if (comparator.compare(left.get(i), right.get(j)) <= 0) {
				array.set(k++, left.get(i++));
			} else {
				array.set(k++, right.get(j++));
			}
		}

		// Добавляем оставшиеся элементы из левой части (если они есть)
		while (i < left.size()) {
			array.set(k++, left.get(i++));
		}

		// Добавляем оставшиеся элементы из правой части (если они есть)
		while (j < right.size()) {
			array.set(k++, right.get(j++));
		}
	}

//	public static void main(String[] args) {
//		MergeSort mergeSort = new MergeSort();
//
//		List<Car> carList = new ArrayList<>();
//
//		Car car1 = new Car.CarBuilder(50, "A", 2012).build();
//		Car car2 = new Car.CarBuilder(100, "C", 2013).build();
//		Car car3 = new Car.CarBuilder(150, "B", 2020).build();
//		Car car4 = new Car.CarBuilder(50, "E", 2018).build();
//		Car car5 = new Car.CarBuilder(100, "D", 2022).build();
//		Car car6 = new Car.CarBuilder(150, "F", 2019).build();
//
//		carList.add(car1);
//		carList.add(car2);
//		carList.add(car3);
//		carList.add(car4);
//		carList.add(car5);
//		carList.add(car6);
//
//		System.out.println("До сортировки по мощнсоти: " + carList);
//		System.out.println();
//		mergeSort.mergeSort(carList, Comparator.comparingInt(Car::getPower));
//		System.out.println("После сортировки по мощности: " + carList);
//		System.out.println();
//
//		System.out.println("До сортировки по названию: " + carList);
//		System.out.println();
//		mergeSort.mergeSort(carList, Comparator.comparing(Car::getModel));
//		System.out.println("После сортировки по названию: " + carList);
//		System.out.println();
//
//		System.out.println("До сортировки по году: " + carList);
//		System.out.println();
//		mergeSort.mergeSort(carList, Comparator.comparingInt(Car::getYear));
//		System.out.println("После сортировки по году: " + carList);
//	}
}