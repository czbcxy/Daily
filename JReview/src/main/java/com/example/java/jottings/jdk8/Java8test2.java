package com.example.java.jottings.jdk8;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * @描述
 * @参数 $params$
 * @返回值 $return$
 * @创建人 czb
 * @创建时间 $date$
 * @修改人和其它信息
 */
public class Java8test2 {

    final static String salutation = "Hello! ";

    public static void main(String args[]) {
        ArrayList<Object> list = Lists.newArrayList();
        GreetingService tConsumer = message -> list.add(salutation + message);
        tConsumer.sayMessage("world");
        tConsumer.sayMessage("world1");
        tConsumer.sayMessage("world2");
        System.out.println(list);
    }

    interface GreetingService {
        void sayMessage(String message);
    }
}
