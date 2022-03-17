/**
 * @author 将晖
 */


public class ArrayGenerator {

    //仅给用户生成一个数组，无需用户创建对象
    private ArrayGenerator(){}

    public static Integer[] generateOrderedArray(int n){

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }


}
