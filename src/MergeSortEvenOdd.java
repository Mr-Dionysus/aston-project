import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class MergeSortEvenOdd
{


    public static int[] sortOddEven(int[] arrayToSort, boolean sortEven)
    {
        int[] stored;
        stored = arrayToSort;
        if (sortEven) arrayToSort = Arrays.stream(arrayToSort).filter(i -> i%2 == 0).toArray();
            else arrayToSort = Arrays.stream(arrayToSort).filter(i -> i %2 != 0).toArray();
        mergeSort(arrayToSort, arrayToSort.length);
        return mergeOld(arrayToSort,stored,sortEven);
    }

    private static int[] mergeOld(int[] a, int[] b, Boolean sortEven)
    {
        int t = 0;
        for(int m = 0; m < b.length; m++)
        {
            if((b[m] % 2) != 0 ^ sortEven)
            {
                b[m] = a[t];
                t++;
            }
        }
        return b;
    }

    public static void mergeSort(int[] a, int n)
    {
        if (n < 2)
        {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

}
