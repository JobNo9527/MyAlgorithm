package LC1147;

class Solution {

    // O(n^2)
    public int longestDecomposition(String text) {

        return solve(text, 0, text.length() - 1);
    }

    // s[left,right]
    private int solve(String s, int left, int right) {

        if (left > right) return 0;

        for (int i = left, j = right; i < j; i++, j--) {
            // s[left ,i] == s[j, right]
            if (equal(s, left, i, j, right))
                return 2 + solve(s, i + 1, j - 1);
        }

        // 说明分不出段，说明该text是个回文
        return 1;
    }

    // s[l1, r1] == s[l2, r2] ?
    private boolean equal(String s, int l1, int r1, int l2, int r2) {

        for (int i = l1, j = l2; i <= r1 && j <= r2; i++, j++)
            if (s.charAt(i) != s.charAt(j))
                return false;

        return true;
    }
}
