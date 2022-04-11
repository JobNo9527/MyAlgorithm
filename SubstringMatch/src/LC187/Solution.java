package LC187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        HashSet<String> seen = new HashSet<>();
        HashSet<String> res = new HashSet<>();  // 去重
        for (int i = 0; i + 10 <= s.length(); i++) {
            String key = s.substring(i, i + 10); // 前闭后开的
            if (seen.contains(key))
                res.add(key);
            else
                seen.add(key);
        }
        return new ArrayList<>(res);
    }
}