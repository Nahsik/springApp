package com.kd.springApp.JavaCore;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class main {

    public static void main(String[] arg) {
//        System.gc();
//        Runnable runnable = () -> System.out.println("Current Runnable Thread :::" + Thread.currentThread());
//        Thread thread = new Thread(runnable);
//
//        thread.run();
//        thread.start();
//        System.out.println("current Main Thread" + Thread.currentThread());
//
//        String s = new String("123");
//        String b = new String("123");
//        if(s.equals(b)){
//            System.out.println("Both are Equals:" + s.hashCode());
//        }
//
//        Object o = new Object();
//        if(s==b){
//            System.out.println("Both are ===");
//        }
//        Objects.hash(1,b,1);
//        //thread.start();

        ObjectNode objectNode = new ObjectMapper().createObjectNode();

        List<String> list = new ArrayList<>();

    }

    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if ((ch == '(') || (ch == '{') || (ch == '[')) {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        char top = stack.pop();
                        if ((ch == ')' && top == '(') ||
                                (ch == ']' && top == '[') ||
                                (ch == '}' && top == '{')) {
                        } else {
                            return false;
                        }
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}



