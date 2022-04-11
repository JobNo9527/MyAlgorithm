package LC187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
    无取模，无需处理哈希冲突，每一次取得的hash值都是唯一的。
 */

public class Solution2 {

    public List<String> findRepeatedDnaSequences(String s) {

        if (s.length() < 10) return new ArrayList<>();

        // 采用十进制来表示DNA序列
        int[] map = new int[256];
        map['A'] = 1;
        map['C'] = 2;
        map['G'] = 3;
        map['T'] = 4;

        HashSet<Long> seen = new HashSet<>();
        HashSet<String> res = new HashSet<>();  // 去重

        long hash = 0, ten9 = (long) 1e9;  // 首位带来的影响，所需要减去的值，题目规定了就是十位

        for (int i = 0; i < 9; i++) // 如果长度不满足10的DNA，s.charAt(i)就会产生越界，开始判断一下就好了
            hash = hash * 10 + map[s.charAt(i)];

        for (int i = 9; i < s.length(); i++) {
            hash = hash * 10 + map[s.charAt(i)];
            if (seen.contains(hash))
                res.add(s.substring(i - 9, i + 1)); // 前闭后开
            else
                seen.add(hash);

            // 这个hash存储了新的长度为9的hash值，回到L30进行后加一个字符的判断
            hash -= map[s.charAt(i - 9)] * ten9;
        }

        return new ArrayList<>(res);
    }
}
