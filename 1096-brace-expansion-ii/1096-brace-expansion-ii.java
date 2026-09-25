class Solution {
    private int i = 0;

    public List<String> braceExpansionII(String expression) {
        Set<String> set = parseExpr(expression);
        List<String> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }

    private Set<String> parseExpr(String s) {
        Set<String> res = new HashSet<>();
        Set<String> cur = new HashSet<>();
        cur.add("");

        while (i < s.length() && s.charAt(i) != '}') {
            if (s.charAt(i) == ',') {
                res.addAll(cur);
                cur = new HashSet<>();
                cur.add("");
                i++;
            } else {
                Set<String> next;
                if (s.charAt(i) == '{') {
                    i++;
                    next = parseExpr(s);
                    i++;
                } else {
                    next = new HashSet<>();
                    next.add(String.valueOf(s.charAt(i)));
                    i++;
                }

                Set<String> combined = new HashSet<>();
                for (String a : cur) {
                    for (String b : next) {
                        combined.add(a + b);
                    }
                }
                cur = combined;
            }
        }

        res.addAll(cur);
        return res;
    }
}