import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int n = 1000_0000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);

        SortingHelper.sortTest("BucketSort", arr);
        SortingHelper.sortTest("BucketSort2", arr2);
    }
}