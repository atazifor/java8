package streams;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 4, 6, 8, 9, 10);
        Integer reduce = integerStream.filter(x -> x % 2 == 0)
                .reduce(0, (x, y) -> x + y);
        System.out.println("reduce = " + reduce);

        try {
            Files.lines(Paths.get("/Users/aminzifor/IdeaProjects/java-/pom.xml"))
                    .flatMap(s -> Stream.of(s.split(" ")))
                    .filter(s -> s.length() > 20)
                    .collect(Collectors.toList())
                    .forEach(s -> System.out.println("s = " + s));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
