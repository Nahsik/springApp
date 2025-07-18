package com.kd.DSA.Comany.Amazon;


import java.util.*;

class Logger {
    private Map<String, Integer> messageTimestampMap;
    private Set<String> set;
    private Queue<Log> logs;

    public Logger() {
        messageTimestampMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageTimestampMap.containsKey(message)) {
            messageTimestampMap.put(message, timestamp);
            return true;
        }

        int lastTimestamp = messageTimestampMap.get(message);
        if (timestamp - lastTimestamp >= 10) {
            messageTimestampMap.put(message, timestamp);
            return true;
        }

        return false;
    }

    public void Logger1() {
        this.logs = new LinkedList<>();
        this.set = new HashSet<>();
    }

    public boolean shouldPrintMessage1(int timestamp, String message) {
        while (logs.isEmpty() && logs.peek().intTime >= timestamp - 10) {
            String log = logs.poll().log;
            set.remove(log);
        }
        if (set.contains(message)) {
            return false;
        }
        set.add(message);
        logs.offer(new Log(timestamp, message));
        return true;
    }

    static class Log {
        private int intTime;
        private String log;

        public Log(int intTime, String log) {
            this.intTime = intTime;
            this.log = log;
        }
    }
}
