package stream;

import java.util.stream.Stream;

public class TestNull {
    public static void main(String[] args) {
        String[] strArray = new String[]{"a", "b", "c", "d"};

        // throw NoSuchElementException
        // String s = Stream.of(strArray).filter(x -> x.equals("u")).findFirst().get();

        String s = Stream.of(strArray).filter(x -> x.equals("a")).findFirst().get();
        System.out.println(s);

    }
}
