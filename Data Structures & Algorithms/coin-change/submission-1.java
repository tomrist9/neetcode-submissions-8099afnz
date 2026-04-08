class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {

       int res = dfs(coins, amount);
       if(res==Integer.MAX_VALUE){
        return -1;
       }
       return res;
        
    }
    private int dfs(int[] coins, int amount){
        if(amount==0) return 0;

        if(amount<0){
            return Integer.MAX_VALUE;
        }

        if(map.containsKey(amount)){
            return map.get(amount);
        }

        int min =Integer.MAX_VALUE;

        for(int coin : coins){
            int res = dfs(coins, amount-coin);
            if(res!=Integer.MAX_VALUE){
            min= Math.min(min, res+1);
        }

        map.put(amount, min);
        }
        return min;
    }
}
