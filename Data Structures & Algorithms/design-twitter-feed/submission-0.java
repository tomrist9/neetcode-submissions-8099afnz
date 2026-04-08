class Twitter {

    private HashMap<Integer, Set<Integer>> followMap;
    private HashMap<Integer, List<int[]>> tweetMap;
    private int time;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // source users: özü + follow etdikləri
        Set<Integer> sources = new HashSet<>();
        sources.add(userId);

        if (followMap.containsKey(userId)) {
            sources.addAll(followMap.get(userId));
        }

        // hər user üçün ən son tweet-i heap-ə qoy
        for (int srcUserId : sources) {
            if (!tweetMap.containsKey(srcUserId)) continue;

            List<int[]> tweets = tweetMap.get(srcUserId);
            int lastIndex = tweets.size() - 1;

            int lastTime = tweets.get(lastIndex)[0];
            int lastTweetId = tweets.get(lastIndex)[1];

            maxHeap.offer(new int[]{lastTime, lastTweetId, srcUserId, lastIndex});
        }

        // feed yığımı
        while (!maxHeap.isEmpty() && res.size() < 10) {
            int[] top = maxHeap.poll();

            int tweetId = top[1];
            int authorId = top[2];
            int idx = top[3];

            res.add(tweetId);

            int prevIdx = idx - 1;
            if (prevIdx >= 0) {
                int prevTime = tweetMap.get(authorId).get(prevIdx)[0];
                int prevTweetId = tweetMap.get(authorId).get(prevIdx)[1];
                maxHeap.offer(new int[]{prevTime, prevTweetId, authorId, prevIdx});
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) return;
        followMap.get(followerId).remove(followeeId);
    }
}
