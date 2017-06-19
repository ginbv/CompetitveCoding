package mike.code.oj.leetcode;

import java.util.*;

/**
 * @author Mike
 * @project oj.code
 * @date 6/I16/I16, 1:45 PM
 * @e-mail mike@mikecoder.cn
 */
public class DesignTwitter {

    static int ID = 0;

    static class Feed {
        int id   = 0;
        int time = 0;

        public Feed(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    private HashMap<Integer, LinkedList<Feed>> userFeeds;
    private HashMap<Integer, HashSet<Integer>> userFollows;

    public DesignTwitter() {
        userFeeds = new HashMap<Integer, LinkedList<Feed>>();
        userFollows = new HashMap<Integer, HashSet<Integer>>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!userFeeds.containsKey(userId)) {
            userFeeds.put(userId, new LinkedList<Feed>());
            HashSet<Integer> follows = new HashSet<Integer>();
            follows.add(userId);
            userFollows.put(userId, follows);
        }
        userFeeds.get(userId).addFirst(new Feed(tweetId, ID++));
    }

    public List<Integer> getNewsFeed(int userId) {
        HashSet<Integer> followIds = userFollows.get(userId);
        LinkedList<Feed> res = new LinkedList<Feed>();
        if (followIds != null) {
            for (int followeeId : followIds) {
                if (userFeeds.containsKey(followeeId)) {
                    res.addAll(userFeeds.get(followeeId));
                }
            }
        }
        Collections.sort(res, new Comparator<Feed>() {
            public int compare(Feed o1, Feed o2) {
                return o1.time < o2.time ? 1 : -1;
            }
        });

        LinkedList<Integer> ret = new LinkedList<Integer>();
        for (Feed feed : res) {
            ret.add(feed.id);
        }
        return ret;
    }

    public void follow(int followerId, int followeeId) {
        if (!userFollows.containsKey(followerId)) {
            HashSet<Integer> follows = new HashSet<Integer>();
            follows.add(followerId);
            userFollows.put(followerId, follows);
        }
        userFollows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId)
            return;
        if (!userFollows.containsKey(followerId)) {
            userFollows.put(followerId, new HashSet<Integer>());
        }
        userFollows.get(followerId).remove(followeeId);
    }

    public static void main(String[] args) {
        DesignTwitter obj = new DesignTwitter();
        obj.postTweet(1, 5);
        obj.postTweet(1, 3);
        obj.postTweet(1, 101);
        obj.postTweet(1, 13);
        obj.postTweet(1, 10);
        obj.postTweet(1, 2);
        obj.postTweet(1, 505);
        obj.postTweet(1, 333);
        obj.postTweet(1, 22);
        obj.postTweet(1, 11);
        obj.postTweet(1, 1);
        System.out.println(obj.getNewsFeed(1));
        //        obj.follow(1, 2);
        //        obj.postTweet(2, 3);
        //        System.out.println(obj.getNewsFeed(2));
        //        System.out.println(obj.getNewsFeed(1));
        //        obj.unfollow(1, 2);
        //        System.out.println(obj.getNewsFeed(1));
        //
        //        DesignTwitter twitter = new DesignTwitter();
        //        System.out.println(twitter.getNewsFeed(1));
    }
}
