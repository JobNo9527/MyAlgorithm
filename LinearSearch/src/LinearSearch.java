/**
 * @author 将晖
 */

public class LinearSearch {

    //禁止外部类创建对象
    private LinearSearch() {
    }

    //使用泛形方法，只能只能接受类对象，不能接收基本数据类型，但可以接收其对应的封装类型，其中有两个特殊的一个是Character,Integer
    public static <E> int search(E[] data, E target) {

        for (int i = 0; i < data.length; i++) if (data[i].equals(target)) return i;

        return -1;
    }

    public static void main(String[] args) {

        //Integer[] data = {24, 18, 12, 9, 16, 66, 32, 4};
        //LinearSearch ls = new LinearSearch();//static就无需创建对象

        int[] dataSize = {1000000, 10000000};
        for (int n : dataSize) {
            Integer[] data = ArrayGenerator.generateOrderedArray(n);

            long start = System.nanoTime();
            for (int i = 0; i < 10; i++) {
                LinearSearch.search(data, n);
            }
            long end = System.nanoTime();

            double time = (end - start) / 1000000000.0;
            System.out.println("n : " + n + ",100 runs : " + time + " s");
        }



        /*
        Stu[] stus = {new Stu("Alice"),
                new Stu("Bobo"),
                new Stu("Charles")};

        Stu bobo = new Stu("bobo");
        int res3 = LinearSearch.search(stus, bobo);
        System.out.println("返回的索引：" + res3);
         */

    }
}
