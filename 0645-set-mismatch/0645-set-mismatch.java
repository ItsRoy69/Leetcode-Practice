class Solution {
    public int[] findErrorNums(int[] arr) {
        int[] result = new int[2];
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != arr[arr[i] - 1]) {
                swap(arr, i, arr[i] - 1);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                result[0] = arr[i];
                result[1] = i + 1;
                break;
            }
        }
        return result;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}