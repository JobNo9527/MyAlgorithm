import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int n = 10000000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n,n);
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);
        Integer[] arr3 = Arrays.copyOf(arr,arr.length);
        Integer[] arr4 = Arrays.copyOf(arr,arr.length);

        SortingHelper.sortTest("MergeSort",arr);
        SortingHelper.sortTest("QuickSort2Ways",arr2);
        SortingHelper.sortTest("QuickSort3Ways",arr3);
        SortingHelper.sortTest("HeapSort",arr4);
    }
}