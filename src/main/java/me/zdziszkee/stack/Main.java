package me.zdziszkee.stack;

import java.util.HashMap;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Map<String,String> map = new Map<>();
        map.put("1","2");
        map.put("2","3");
        map.put("3","4");
        map.put("4","5");
        System.out.println(map.get("1"));
        map.remove("1");
        System.out.println(map.get("1"));

    }

}