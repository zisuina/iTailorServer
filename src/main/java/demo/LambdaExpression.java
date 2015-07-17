package demo;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liker on 14/07/2015 0014.
 * Group iTailor.hunters.neu.edu.cn
 */
public class LambdaExpression {
    String[] atp = {"Rafael Nadal", "Novak Djokovic",
            "Stanislas Wawrinka",
            "David Ferrer", "Roger Federer",
            "Andy Murray", "Tomas Berdych",
            "Juan Martin Del Potro"};
    List<String> players = Arrays.asList(atp);

    public void saySomethingInOldWay() {
        for (String player : players) {
            System.out.println(player + ";");
        }
    }
    public void saySomethingInLambdaWay(){
        players.forEach(
                (player) -> System.out.println(player + ";")
        );
    }
    public void saySomethingInDoubleColonOperator(){
        players.forEach(System.out::println);
    }

//    class Child extends LambdaExpression{
//        public void eat(){
//            System.out.println("I'm eating an elephant.");
//        }
//    }

    public static void main(String[] args) {
        LambdaExpression lambdaExpression = new LambdaExpression();
        lambdaExpression.saySomethingInOldWay();
        lambdaExpression.saySomethingInLambdaWay();
        lambdaExpression.saySomethingInDoubleColonOperator();

        LambdaInterface lambdaInterface = new LambdaInterface() {
            @Override
            public void eat() {
                System.out.println("I'm eating an elephant.");
            }
        };
        lambdaInterface.eat();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        }).start();

        new Thread(() -> System.out.println("Hello world !")).start();


        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        };

        Runnable race2 = () -> System.out.println("Hello world !");


        race1.run();
        race2.run();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Lambda is so sweet.");
            }
        }).start();
    }
}
