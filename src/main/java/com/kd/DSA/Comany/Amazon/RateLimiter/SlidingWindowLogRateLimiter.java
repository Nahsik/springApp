package com.kd.DSA.Comany.Amazon.RateLimiter;

import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class SlidingWindowLogRateLimiter implements RateLimiter {
    private final int maxRequests;
    private final long timeWindowMillis;
    private final Map<String, Deque<Long>> userRequestLogs = new ConcurrentHashMap<>();

    public SlidingWindowLogRateLimiter(int maxRequests, long timeWindowMillis) {
        this.maxRequests = maxRequests;
        this.timeWindowMillis = timeWindowMillis;
    }

    @Override
    public boolean allowRequest(String userId) {
        long now = System.currentTimeMillis();
        userRequestLogs.putIfAbsent(userId, new ConcurrentLinkedDeque<>());
        Deque<Long> logs = userRequestLogs.get(userId);

        synchronized (logs) {
            while (!logs.isEmpty() && now - logs.peekFirst() > timeWindowMillis) {
                logs.pollFirst();
            }
            if (logs.size() < maxRequests) {
                logs.addLast(now);
                return true;
            }
            return false;
        }
    }
}

