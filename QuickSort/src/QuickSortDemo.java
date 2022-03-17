import java.util.Arrays;

public class QuickSortDemo {

    public static void main(String[] args) {

        int n = 100000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest("QuickSort", arr);
        SortingHelper.sortTest("QuickSort2Ways", arr2);
        SortingHelper.sortTest("QuickSort3Ways", arr3);

        System.out.println("--------");

        arr = ArrayGenerator.generateOrderedArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest("QuickSort", arr);
        SortingHelper.sortTest("QuickSort2Ways", arr2);
        SortingHelper.sortTest("QuickSort3Ways", arr3);

        System.out.println("--------");

        arr = ArrayGenerator.generateRandomArray(n, 1);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest("QuickSort", arr);
        SortingHelper.sortTest("QuickSort2Ways", arr2);
        SortingHelper.sortTest("QuickSort3Ways", arr3);

    }
}
