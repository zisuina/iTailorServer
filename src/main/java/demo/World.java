package demo;

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
    }
}
