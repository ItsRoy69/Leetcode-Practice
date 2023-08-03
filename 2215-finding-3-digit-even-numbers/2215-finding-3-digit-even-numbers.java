class Solution {
    public int[] findEvenNumbers(int[] digits) {
            List<Integer> myList = new ArrayList<Integer>();

    Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();

    for (int i = 0 ; i < digits.length ; i++){
        int a = digits[i];
        myMap.put(a, myMap.getOrDefault(a, 0) + 1);
    }

    for (int i = 100 ; i < 999 ; i = i + 2){

        int[] arr = String.valueOf(i).chars().map(c -> c - '0').toArray();

        boolean status = checkStatus(new HashMap<Integer, Integer>(myMap), arr);

        if (status == true){
            myList.add(i);
        }

    }

    return myList.stream().mapToInt(i -> i).toArray();   
    
}

public static boolean checkStatus(Map<Integer, Integer> myMap, int[] arr){
    int k = 0;
    for (int i = 0 ; i < arr.length ; i++){
        if (myMap.containsKey(arr[i]) && myMap.get(arr[i]) > 0){
            int value = myMap.get(arr[i]);                
            k++;
            myMap.put(arr[i], value - 1);                
        }
    }
    if (k == 3) return true;
    return false;

    }
}