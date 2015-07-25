package demo;

/**
 * Created by liker on 14/07/2015 0014.
 * Group iTailor.hunters.neu.edu.cn
 */
public class OuterClass {
    private int size;

    private class InnerClass {
        private void display() {
            size++;
            System.out.println("The Inner Class makes a difference.");
        }
    }

    InnerClass ic = new InnerClass();


    public void showSize() {
        System.out.println("Before:" + size);
        ic.display();
        System.out.println("After:" + size);
        class Inner {
            private int size;

            private void whichSize() {
                size++;
                System.out.println("Inner class in a method:" + size);
            }
        }
        Inner in = new Inner();
        in.whichSize();
    }
    static class StaticClass {
        private int size = 100;

        public void display() {
            System.out.println("My size is " + size);
        }
    }

    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
        oc.showSize();
        InnerClass oci = oc.new InnerClass();
        oci.display();
        StaticClass sc = new StaticClass();
        sc.display();
    }
}
