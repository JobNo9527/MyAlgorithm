import java.util.Random;

/**
 * @author 将晖
 */


public class ArrayGenerator {

    //仅给用户生成一个数组，无需用户创建对象
    private ArrayGenerator() {
    }

    public static Integer[] generateOrderedArray(int n) {

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }


    /**
     * @param n     //随机数组规模
     * @param bound //随机数组的边界
     * @return arr
     */
    public static Integer[] generateRandomArray(int n, int bound) {

        Integer[] arr = new Integer[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++)
            arr[i] = rnd.nextInt(bound);//前闭后开的[0,bound)
        return arr;
    }
}
