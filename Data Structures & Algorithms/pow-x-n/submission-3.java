class Solution {
    public double myPow(double x, int n) {
            long N = n; 
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
         double result =1;
          while (N > 0) {
           result*=x;
           N--;
        }

        return result;
    }
}
