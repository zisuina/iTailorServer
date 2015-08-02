package demo;

/**
 * Created by liker on 30/07/2015 0030.
 * Group iTailor.hunters.neu.edu.cn
 */
public interface Hello {


    public default void world(String string2) {
        System.out.println("YES,IT'S INSIDE THE INTERFACE!");
        wacaca(string2);
        System.out.println("YES,IT'S INSIDE THE INTERFACE 2!");
    }

    public void wacaca(String string);



}
