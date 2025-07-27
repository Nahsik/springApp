package com.kd.DSA.Comany.Amazon.RateLimiter;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowCounterRateLimiter implements RateLimiter {
    private final int maxRequests;
    private final long windowSizeMs;
    private final Map<String, TreeMap<Long, Integer>> userBuckets = new ConcurrentHashMap<>();
    private final long bucketSizeMs;

    public SlidingWindowCounterRateLimiter(int maxRequests, long windowSizeMs, long bucketSizeMs) {
        this.maxRequests = maxRequests;
        this.windowSizeMs = windowSizeMs;
        this.bucketSizeMs = bucketSizeMs;
    }

    @Override
    public boolean allowRequest(String userId) {
        long now = System.currentTimeMillis();
        long currentBucket = now / bucketSizeMs;

        userBuckets.putIfAbsent(userId, new TreeMap<>());
        TreeMap<Long, Integer> buckets = userBuckets.get(userId);

        synchronized (buckets) {
            // Remove outdated buckets
            long earliestBucket = (now - windowSizeMs) / bucketSizeMs;
            buckets.headMap(earliestBucket).clear();

            int totalRequests = buckets.values().stream().mapToInt(Integer::intValue).sum();

            if (totalRequests >= maxRequests) {
                return false;
            }

            buckets.put(currentBucket, buckets.getOrDefault(currentBucket, 0) + 1);
            return true;
        }
    }
}

