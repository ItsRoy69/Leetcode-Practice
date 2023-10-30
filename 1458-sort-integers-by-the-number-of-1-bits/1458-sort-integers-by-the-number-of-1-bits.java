class Solution {
    public int[] sortByBits(int[] arr) {
        
        Integer[] integerArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        
        Comparator<Integer> comparator = new BitCountComparator();

        Arrays.sort(integerArr, comparator);

        int[] sortedArr = Arrays.stream(integerArr).mapToInt(Integer::intValue).toArray();

        return sortedArr;
    }
}

class BitCountComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        // Compare based on the count of set bits (1s) in the binary representation
        int bitCountA = Integer.bitCount(a);
        int bitCountB = Integer.bitCount(b);

        if (bitCountA == bitCountB) {
            // If bit counts are the same, compare numerically
            return a - b;
        } else {
            // Sort by the number of set bits in ascending order
            return bitCountA - bitCountB;
        }
    }
}