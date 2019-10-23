package stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestNull {
    public static void main(String[] args) {
        String[] strArray = new String[]{"a", "b", "c", "d"};

         //throw NoSuchElementException
        //String s = Stream.of(strArray).filter(x -> x.equals("u")).findFirst().get();

        String s = Stream.of(strArray).filter(x -> x.equals("a")).findFirst().orElseGet(()->"default word");
        System.out.println(s);
        // list size 0
        //List<String> list = Stream.of(strArray).filter(x -> x.equals("u")).collect(Collectors.toList());
        //System.out.println(list);
//        String s = Stream.of(strArray).filter(x -> x.equals("a")).findFirst().get();
//        System.out.println(s);

    }
}
