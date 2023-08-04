class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        if(arr.length==1)
        {
            return 0;
        }
        else{
            for(int i=0;i<arr.length;i++)
            {
                if(i==0)
                {
                    if(arr[i]>arr[i]+1)
                    {
                        return i;
                    }
                }
                else if(i==arr.length-1)
                {
                    if(arr[i]>arr[i-1])
                    {
                        return i;
                    }
                }
                else if(arr[i]>arr[i-1] && arr[i]>arr[i+1])
                {
                    return i;
                }
                
            }

        }

        
        return 0;
    }
}