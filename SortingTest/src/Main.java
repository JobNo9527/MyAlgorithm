import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int n = 1000_0000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        Integer[] arr4 = Arrays.copyOf(arr, arr.length);
        Integer[] arr5 = Arrays.copyOf(arr, arr.length);
        Integer[] arr6 = Arrays.copyOf(arr, arr.length);
        Integer[] arr7 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("MergeSort", arr);
        SortingHelper.sortTest("QuickSort2Ways", arr2);
        SortingHelper.sortTest("QuickSort3Ways", arr3);
        SortingHelper.sortTest("HeapSort", arr4);
        SortingHelper.sortTest("HeapSort2", arr5);
        SortingHelper.sortTest("BucketSort", arr6);
        SortingHelper.sortTest("BucketSort2", arr7);
    }
}

/*
    MergeSort , n = 10000000 : 8.979324 s
    QuickSort2Ways , n = 10000000 : 5.427483 s
    QuickSort3Ways , n = 10000000 : 11.813075 s
    HeapSort , n = 10000000 : 26.030029 s
    HeapSort2 , n = 10000000 : 27.891599 s
    BucketSort , n = 10000000 : 6.889067 s
 */