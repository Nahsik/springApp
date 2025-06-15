package com.kd.springApp.JavaCore.Generics;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] arge) {
        List list = new ArrayList<>();
        list.add("234");
        list.add(1);
        list.add(4);

        System.out.println(list.size());

        ///  1
        Box<String> box = new Box<>("123");

        ///  2

       // Box1<String> box1 = new Box1<String>(); => Invalid
        Box1<Integer> box1= new Box1<>(1);

    }


}



