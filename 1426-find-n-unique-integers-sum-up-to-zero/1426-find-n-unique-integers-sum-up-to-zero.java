class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int sum = 0;
        
        for(int i=0; i<n; i++){
            if(i == n-1){
                arr[i] = sum * (-1);
            }
            else{
                arr[i] = i+1;
                sum+= i+1;
            }
        }
        return arr;
    }
}