import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate("", 0, 0, n, res);
        return res;
    }

    private void generate(String current, int open, int close, int n, List<String> res) {

        if (current.length() == 2 * n) {
            res.add(current);
            return;
        }
        if (open < n) {
            generate(current + "(", open + 1, close, n, res);
        }
        if (close < open) {
            generate(current + ")", open, close + 1, n, res);
        }
    }
}