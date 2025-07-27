package com.kd.DSA.Comany.Amazon.RateLimiter;

public interface RateLimiter {
    boolean allowRequest(String userId);
}
