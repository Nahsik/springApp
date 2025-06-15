package com.kd.springApp.JavaCore;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI8 {

    public static void main(String[] arg) {
        convert();
//        int[] array = new int[]{1, 2, 3, 4, 5};
//
//        int sum = Arrays.stream(array).filter(a -> a % 2 == 0).sum();
//
//        List<Integer> list = new ArrayList<>();
//
//        List<Integer> list1 = list.stream()
//                .map(a -> a - 1)
//                .collect(Collectors.toUnmodifiableList());

    }

    public static void createStream() {
        Hashtable<String,Integer> hashtable = new Hashtable<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("test",1);
        Hashtable<String,Integer> hashtable1  = new Hashtable<>();
        hashtable1.get("");

        String[] array = new String[]{"Kishan", "Patel"};
        Stream<String> stream = Arrays.stream(array);

        List<String> list = Arrays.asList("Kishan", "Patel");
        Stream<String> listStream = list.stream();

        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4);

        Stream<Integer> stream2 = Stream.iterate(0, n -> n + 2).limit(100);

        Stream<Integer> stream3 = Stream.generate(() -> (int) (Math.random() * 100)).limit(100);

       try{
           System.out.println(1/0);
       } finally {

       }
    }


    public static void convert() {
        List<Integer> list = Arrays.asList(1,2,5,6,8,10);
        list = list.stream().map(a -> a * a).sorted().toList();
        System.out.println(list);

        Set<Integer>  set=  Stream.concat(list.stream(),list.stream()).collect(Collectors.toSet());
    }


}
