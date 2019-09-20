public class Solution {
    public int Add(int num1,int num2) {
        int sum = num1 ^ num2;
        int cry = (num1 & num2) << 1;
        
        num1 = sum;
        num2 = cry;
        while (num2 != 0) {
            sum = num1 ^ num2;
            cry = (num1 & num2) << 1;
            
            num1 = sum;
            num2 = cry;
        }
        
        return num1;
    }
}