package com.kd.DSA.Comany.Amazon.RateLimiter;

import java.util.HashMap;
import java.util.Map;

public class FixedWindow implements RateLimiter {
    private int maxSize;
    private long windowSizeInLong;
    private Map<String, Window> map;

    public FixedWindow(int maxRequest, int windowSizeInLong) {
        this.maxSize = maxRequest;
        this.windowSizeInLong = windowSizeInLong;
        this.map = new HashMap<>();
    }

    @Override
    public boolean allowRequest(String userId) {
        map.putIfAbsent(userId, new Window());
        long currentTime = System.currentTimeMillis();
        Window window = map.get(userId);
        synchronized (window) {
            if (currentTime - window.windowStart >= windowSizeInLong) {
                window.windowStart = currentTime;
                window.requestCount = 1;
                return true;
            } else if (window.requestCount < maxSize) {
                window.requestCount++;
                return true;
            } else {
                return false;
            }
        }
    }

    static class Window {
        long windowStart;
        int requestCount;

        Window() {

        }

        Window(long windowStart, int requestCount) {
            this.requestCount = requestCount;
            this.windowStart = windowStart;
        }
    }
}
