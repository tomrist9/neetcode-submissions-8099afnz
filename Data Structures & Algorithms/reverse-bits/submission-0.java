class Solution {
    public int reverseBits(int n) {
        int z=0;
        for(int i=0; i<32; i++){
            z<<=1;
            z|=(n&1);
            n>>=1;
             
        }
        return z;
    }
}
