class Solution {
    public String fractionAddition(String expression) {
        int num = 0;
        int denom = 1;
        int i=0;
        while(i<expression.length()){
            int currNum = 0;
            int currDenom = 0;
            boolean isNegative = false;
            if(expression.charAt(i)=='-'||expression.charAt(i)=='+'){
                if(expression.charAt(i)=='-'){
                    isNegative = true;
                }
                i++;
            }
            while(Character.isDigit(expression.charAt(i))){
                int val = expression.charAt(i)-'0';
                currNum = currNum*10+val;
                i++;
            }
            if(isNegative)currNum*=-1;
            i++;
            while(i<expression.length()&&
            Character.isDigit(expression.charAt(i))){
                int val = expression.charAt(i)-'0';
                currDenom = currDenom*10+val;
                i++;
            }
            num = num*currDenom+currNum*denom;
            denom = denom*currDenom;
        }
        int gcd = Math.abs(findGCD(num,denom));
        num/=gcd;
        denom/=gcd;
        return num+"/"+denom;
    }
    private int findGCD(int a,int b){
        if(a==0)return b;
        return findGCD(b%a,a);
    }
}