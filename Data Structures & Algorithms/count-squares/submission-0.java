class CountSquares {
   private Map<Integer, Map<Integer, Integer>> map;
    public CountSquares() {
        map = new HashMap();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        map.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> yMap = map.get(x);
        yMap.put(y, yMap.getOrDefault(y, 0)+1);
    }
    
    public int count(int[] point) {
        int x=point[0];
        int y=point[1];
        if(!map.containsKey(x)) return 0;
           int result = 0;
        Map<Integer, Integer> yMap = map.get(x);
        for(int y2:yMap.keySet()){
            if(y2==y) continue;

            int count2 = yMap.get(y2);
            int d = y2-y;

             if (map.containsKey(x + d)) {
                Map<Integer, Integer> right = map.get(x + d);

                result += count2
                        * right.getOrDefault(y, 0)
                        * right.getOrDefault(y2, 0);
            }

          
            if (map.containsKey(x - d)) {
                Map<Integer, Integer> left = map.get(x - d);

                result += count2
                        * left.getOrDefault(y, 0)
                        * left.getOrDefault(y2, 0);
            }
        }

        return result;
    }
}