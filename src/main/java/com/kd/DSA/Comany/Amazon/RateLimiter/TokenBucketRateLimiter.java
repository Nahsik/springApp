package com.kd.DSA.Comany.Amazon.RateLimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketRateLimiter implements RateLimiter {
    private final int capacity;
    private final int refillRate; // tokens per second
    private final Map<String, Bucket> userBuckets = new ConcurrentHashMap<>();

    public TokenBucketRateLimiter(int capacity, int refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
    }

    static class Bucket {
        int tokens;
        long lastRefillTime;
    }

    @Override
    public boolean allowRequest(String userId) {
        long now = System.currentTimeMillis();
        userBuckets.putIfAbsent(userId, new Bucket());
        Bucket bucket = userBuckets.get(userId);

        synchronized (bucket) {
            long elapsedTime = now - bucket.lastRefillTime;
            int tokensToAdd = (int) (elapsedTime / 1000.0 * refillRate);
            bucket.tokens = Math.min(capacity, bucket.tokens + tokensToAdd);
            bucket.lastRefillTime = now;

            if (bucket.tokens > 0) {
                bucket.tokens--;
                return true;
            }
            return false;
        }
    }
}

