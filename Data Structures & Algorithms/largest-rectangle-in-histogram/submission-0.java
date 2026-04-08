class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max =0;
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1);

        for(int i=0;i <=n; i++ ){
            int curr = (i == n) ? 0 : heights[i];
           
                while (st.peek() != -1 && curr < heights[st.peek()]) {
                int mid = st.pop();
                int left = st.peek();

                int width = i - left -1;
                    max = Math.max(max, heights[mid] * width);
            }
            st.push(i);
        }
        return max;
    }
}
