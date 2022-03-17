/**
 * @author 将晖
 */


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

    public static <E extends Comparable<E>> void sortTest(String sortName, E[] arr,int n) {

        //随机情况下
        long start = System.nanoTime();
        if (sortName.equals("SelectionSort"))
            SelectionSort.sort(arr);
        else if (sortName.equals("InsertionSort"))
            InsertionSort.sort(arr);
        long end = System.nanoTime();
        double time = (end - start) / 1000000000.0;


        //逆序情况下
        Integer[] arr2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = n - i;
        }
        long start2 = System.nanoTime();
        if (sortName.equals("SelectionSort"))
            SelectionSort.sort(arr2);
        else if (sortName.equals("InsertionSort"))
            InsertionSort.sort(arr2);
        long end2 = System.nanoTime();
        double time2 = (end2 - start2) / 1000000000.0;


        //验证排序是否正确
        if (!SortingHelper.isSorted(arr) && !SortingHelper.isSorted(arr2))
            throw new RuntimeException(sortName + " failed");



        System.out.printf("%s , n = %d : %f s%n", sortName, arr.length, time);
        System.out.printf("Worst: %s , n = %d : %f s%n", sortName, arr.length, time2);
    }
}
