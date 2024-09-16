package method;

public interface StaticDemo {
    static String normalize(String s) {
        System.out.println("Invoked Static Interface Method");
        return s == null ? "Empty String" : s;
    }

    void print(String s);
}
