public class Main {

    public static void main(String[] args) {

        String s1 = "hello, this is liuyubobobo";
        String t1 = "bo";
        SubstringMatchHelper.matchTest("bruteforce", s1, t1);
        SubstringMatchHelper.matchTest("rabinKarp", s1, t1);

        String s2 = FileOperation.readFile("SubstringMatch//pride-and-prejudice.txt");
        String t2 = "china";
        SubstringMatchHelper.matchTest("bruteforce", s2, t2);
        SubstringMatchHelper.matchTest("rabinKarp", s2, t2);

        SubstringMatchHelper.matchTest("bruteforce", s2, "zyx");
        SubstringMatchHelper.matchTest("rabinKarp", s2, "zyx");

        /// Worst case
        int n = 100_0000, m = 1_0000;

        StringBuilder s3 = new StringBuilder();
        s3.append("a".repeat(n));
        StringBuilder t3 = new StringBuilder();
        t3.append("a".repeat(m - 1));
        t3.append('b');

        SubstringMatchHelper.matchTest("bruteforce", s3.toString(), t3.toString());
        SubstringMatchHelper.matchTest("rabinKarp", s3.toString(), t3.toString());
    }
}
