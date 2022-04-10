import java.util.Random;

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

    public static Integer[] generateReversedArray(int n) {

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
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

    public static String[] generateRandomSameLengthStringArray(int n, int w) {

        String[] arr = new String[n];

        // 33~126 可打印的字符
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < w; j++)
                sb.append((char) (rnd.nextInt(94) + 33));
            arr[i] = sb.toString();
        }
        return arr;
    }

    // 生成一个大小为n的随机字符串数组，每个字符串最长为bound
    public static String[] generateRandomStringArray(int n, int bound) {

        String[] arr = new String[n];

        // 33~126 可打印的字符
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            // 长度随机化
            int w = rnd.nextInt(bound);
            for (int j = 0; j < w; j++)
                sb.append((char) (rnd.nextInt(94) + 33));
            arr[i] = sb.toString();
        }
        return arr;
    }
}
