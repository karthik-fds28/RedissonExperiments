package com.logicbig.example.redissonExamples;

import org.redisson.Redisson;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueExamples {


    public static void main(String[] args) {
        // connects to 127.0.0.1:6379 by default
        RedissonClient redisson = Redisson.create();

        RQueue<String> queue = redisson.getQueue("myQueue");
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");


        for (String string : queue) {
            // iteration through bulk loaded values
            System.out.println("queue value=" + string);
        }

        queue.contains("1");

        String peek = queue.peek();
        System.out.println("peek=" + peek);

        String poll = queue.poll();
        System.out.println("poll=" + poll);

        String element = queue.element();
        System.out.println("element=" + element);

        for (String string : queue) {
            // iteration through bulk loaded values
            System.out.println("queue value=" + string);
        }

        /*

        boolean removedValue = queue.remove("1");
        queue.removeAll(Arrays.asList("1", "2", "3"));
        queue.containsAll(Arrays.asList("4", "1", "0"));

        List<String> secondList = new ArrayList<>();
        secondList.add("4");
        secondList.add("5");
        queue.addAll(secondList);

       */

        RQueue<String> secondQueue = redisson.getQueue("mySecondQueue");

        queue.pollLastAndOfferFirstTo(secondQueue.getName());

        redisson.shutdown();
    }

}
