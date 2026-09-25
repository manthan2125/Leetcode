class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> result = solve(expression);
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }

    private Set<String> solve(String s) {
        Set<String> result = new HashSet<>();
        result.add("");

        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (ch == '{') {
                int count = 1;
                int j = i + 1;

                while (count > 0) {
                    if (s.charAt(j) == '{') {
                        count++;
                    } else if (s.charAt(j) == '}') {
                        count--;
                    }
                    j++;
                }

                Set<String> inside = solve(s.substring(i + 1, j - 1));
                result = multiply(result, inside);

                i = j;
            } else if (ch == ',') {
                Set<String> remaining = solve(s.substring(i + 1));
                result.addAll(remaining);
                break;
            } else {
                Set<String> next = new HashSet<>();

                for (String str : result) {
                    next.add(str + ch);
                }

                result = next;
                i++;
            }
        }

        return result;
    }

    private Set<String> multiply(Set<String> a, Set<String> b) {
        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}