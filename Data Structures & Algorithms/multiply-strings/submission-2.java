
class Solution {
    public String multiply(String num1, String num2) {
    
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m+n];
        for(int i=n-1;i >=0; i--){
            for(int j=m-1; j>=0; j--){
                int mul = (num2.charAt(i)-'0')*(num1.charAt(j)-'0');
            int sum = mul + res[i + j + 1];

                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int x : res) {
            if (!(sb.length() == 0 && x == 0)) {
                sb.append(x);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}