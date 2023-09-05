class Solution {
    public double average(int[] salary) {
       Arrays.sort(salary);
       int sum=0;
       for(int salaries:salary){
         sum+=salaries;
       }
       return (double)(sum-salary[0]-salary[salary.length-1])/(double)(salary.length-2);
    }
}