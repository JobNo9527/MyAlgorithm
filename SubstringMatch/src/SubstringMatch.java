public class SubstringMatch {

    private SubstringMatch() {
    }

    // 在 s 中寻找 t ，并返回匹配的第一个索引 i; 如果没有找到，返回 -1
    public static int bruteforce(String s, String t) {

        if (s.length() < t.length()) return -1;

        // s[i,i + t.length() - 1] == t ?
        for (int i = 0; i + t.length() - 1 < s.length(); i++) {

            int j = 0;
            for (; j < t.length(); j++)
                if (s.charAt(i + j) != t.charAt(j))
                    break;

            if (j == t.length())
                return i;
        }
        return -1;
    }

    public static int rabinKarp(String s, String t) {

        if (s.length() < t.length()) return -1;
        if (t.length() == 0) return 0;

        long tHash = 0, MOD = (long) 1e9 + 7, B = 256;
        for (int i = 0; i < t.length(); i++)
            tHash = (tHash * B + t.charAt(i)) % MOD;

        long hash = 0, P = 1;
        for (int i = 0; i < t.length() - 1; i++)
            P = P * B % MOD;

        for (int i = 0; i < t.length() - 1; i++)
            hash = (hash * B + s.charAt(i)) % MOD;

        for (int i = t.length() - 1; i < s.length(); i++) {

            hash = (hash * B + s.charAt(i)) % MOD;

            if (hash == tHash && equal(s, i - t.length() + 1, t))
                return i - t.length() + 1;

            hash = (hash - s.charAt(i - t.length() + 1) * P % MOD + MOD) % MOD;
        }
        return -1;
    }

    // 判断两子串是否相等
    private static boolean equal(String s, int l, String t) {

        for (int i = 0; i < t.length(); i++)
            if (t.charAt(i) != s.charAt(i + l))
                return false;
        return true;
    }
}