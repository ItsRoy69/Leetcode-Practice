class Solution {
    public String largestNumber(int[] nums) {
        String[] numsAsStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsAsStrings[i] = Integer.toString(nums[i]);
        }
        
        // Custom comparator to sort strings
        Arrays.sort(numsAsStrings, new Comparator<String>() {
        
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1); // Sort in descending order
            }
        });
            
        // Handle leading zeros
        if (numsAsStrings[0].equals("0")) {
            return "0";
        }
        
        // Concatenate sorted strings to form the largest number
        StringBuilder result = new StringBuilder();
        for (String numStr : numsAsStrings) {
            result.append(numStr);
        }
        
        return result.toString();
    }
}