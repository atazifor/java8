package method;

import java.util.stream.Stream;

public class StaticDemoImplementor implements StaticDemo{
    @Override
    public void print(String s) {
        System.out.println("Invoked overriden method");
        System.out.println("Normalized String is: " + s);
    }

    static String normalize(String s) {
        System.out.println("Implementor method");
        return s;
    }

    public static void main(String[] args) {
        String s = null;
        s = StaticDemo.normalize(s);
        StaticDemoImplementor staticDemoImplementor = new StaticDemoImplementor();
        staticDemoImplementor.print(s);

    }
}
