import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int n = 10000000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n,n);
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);
        Integer[] arr3 = Arrays.copyOf(arr,arr.length);
        Integer[] arr4 = Arrays.copyOf(arr,arr.length);
        Integer[] arr5 = Arrays.copyOf(arr,arr.length);

        SortingHelper.sortTest("MergeSort",arr);
        SortingHelper.sortTest("QuickSort2Ways",arr2);
        SortingHelper.sortTest("QuickSort3Ways",arr3);
        SortingHelper.sortTest("HeapSort",arr4);
        SortingHelper.sortTest("HeapSort2",arr5);
    }
}

/*
    MergeSort , n = 10000000 : 5.704302 s
    QuickSort2Ways , n = 10000000 : 3.852956 s
    QuickSort3Ways , n = 10000000 : 8.413585 s
    HeapSort , n = 10000000 : 13.743302 s
    HeapSort2 , n = 10000000 : 12.680839 s
 */
