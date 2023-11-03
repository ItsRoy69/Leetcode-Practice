class Solution {
    public static List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int current = 1; 

        for (int i = 0; i < target.length; i++) {
            while (current < target[i]) {
                
                result.add("Push");
                result.add("Pop"); 
                current++;
            }

            result.add("Push");

            current++; 
        }

        return result;
    }
}