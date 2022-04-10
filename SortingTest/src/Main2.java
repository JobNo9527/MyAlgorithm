import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) {

        int n = 1000_0000, w = 2;

        String[] arr = ArrayGenerator.generateRandomStringArray(n, w);
        String[] arr2 = ArrayGenerator.generateRandomSameLengthStringArray(n, w);
        String[] arr3 = Arrays.copyOf(arr, arr.length);
        String[] arr4 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("MSDSort", arr); // 当字符串长度较短，数据量很大的情况下，O(W*n)很优
        SortingHelper.sortTest("LSDSort", arr2);
        SortingHelper.sortTest("QuickSort2Ways", arr3);
        SortingHelper.sortTest("QuickSort3Ways", arr4);
    }
}