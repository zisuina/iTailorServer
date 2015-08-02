package demo;

import java.util.ArrayList;

/**
 * Created by liker on 30/07/2015 0030.
 * Group iTailor.hunters.neu.edu.cn
 */
public class World {
    Hello hello = (String string) -> {
        System.out.println("LAMBADA:"+string);
    };

    public static void main(String[] args) {
        World world = new World();
        world.hello.world("nice me!");

        ArrayList<String> strings = new ArrayList<>();
        strings.add("hello");
        strings.add("world");
        strings.add("jersey");
        strings.add("waca-waca");
        System.out.println(strings.size());
        System.out.println(strings.subList(0,0));
        System.out.println(strings.subList(0,1));
        System.out.println(strings.subList(0,2));
        System.out.println(strings.subList(0,3));
        System.out.println(strings.subList(0,4));
        System.out.println(strings.subList(1,4));
    }
}
