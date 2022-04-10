import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int n = 26 * 26 * 26 * 26;

        // 初始的学生名字保持着字典序
        Student[] students = new Student[n];
        int k = 0;
        Random rnd = new Random();
        for (char c1 = 'a'; c1 <= 'z'; c1++)
            for (char c2 = 'a'; c2 <= 'z'; c2++)
                for (char c3 = 'a'; c3 <= 'z'; c3++)
                    for (char c4 = 'a'; c4 <= 'z'; c4++) {
                        students[k] = new Student("" + c1 + c2 + c3 + c4, rnd.nextInt(101));
                        k++;
                    }


    }
}
