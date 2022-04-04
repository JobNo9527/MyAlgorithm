public class SortingHelper {

    private SortingHelper() {
    }

    //因为要实现比较，所以这个泛形需要实现一下comparable接口进行比较
    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {

        for (int i = 1; i < arr.length; i++)
            if (arr[i - 1].compareTo(arr[i]) > 0)   //如果能进去if说明不是有序的
                return false;
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortName, E[] arr) {

        long start = System.nanoTime();
        switch (sortName) {
            case "SelectionSort" -> SelectionSort.sort(arr);
            case "InsertionSort" -> InsertionSort.sort(arr);
            case "MergeSort" -> MergeSort.sort(arr);
            case "QuickSort" -> QuickSort.sort(arr);
            case "QuickSort2Ways" -> QuickSort2Ways.sort2ways(arr);
            case "QuickSort3Ways" -> QuickSort3Ways.sort3ways(arr);
            case "HeapSort" -> HeapSort.sort(arr);
            case "HeapSort2" -> HeapSort.sort2(arr);
            case "BubbleSort" -> BubbleSort.sort(arr);
            case "BubbleSort2" -> BubbleSort.sort2(arr);
            case "BubbleSort3" -> BubbleSort.sort3(arr);
            case "ShellSort" -> ShellSort.sort(arr);
            case "ShellSort2" -> ShellSort.sort2(arr);
        }
        long end = System.nanoTime();
        double time = (end - start) / 1000000000.0;

        //验证排序是否正确
        if (!SortingHelper.isSorted(arr))
            throw new RuntimeException(sortName + " failed");

        System.out.printf("%s , n = %d : %f s%n", sortName, arr.length, time);
    }
}
