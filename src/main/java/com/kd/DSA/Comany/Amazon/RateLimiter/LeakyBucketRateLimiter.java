package com.kd.DSA.Comany.Amazon.RateLimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LeakyBucketRateLimiter implements RateLimiter {
    private final int capacity;
    private final int leakRate; // tokens per second
    private final Map<String, Bucket> userBuckets = new ConcurrentHashMap<>();

    static class Bucket {
        int water;
        long lastLeakTime;
    }

    public LeakyBucketRateLimiter(int capacity, int leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate;
    }

    @Override
    public boolean allowRequest(String userId) {
        long now = System.currentTimeMillis();
        userBuckets.putIfAbsent(userId, new Bucket());
        Bucket bucket = userBuckets.get(userId);

        synchronized (bucket) {
            long elapsedTime = now - bucket.lastLeakTime;
            int leaked = (int) (elapsedTime / 1000.0 * leakRate);
            bucket.water = Math.max(0, bucket.water - leaked);
            bucket.lastLeakTime = now;

            if (bucket.water < capacity) {
                bucket.water++;
                return true;
            }
            return false;
        }
    }
}
