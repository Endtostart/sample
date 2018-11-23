package stream;

import com.google.common.collect.Lists;
import entityDemo.Country;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTestDemo {

    public static List<String> bastList = Lists.newArrayList("a", "b", "c");

    // map
    public static void map() {
        System.out.println("=============== map ===============");
        System.out.println("change before:" + bastList.toString());
        List<String> afterList = bastList.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("change after:" + afterList.toString());
    }

    // flatMap
    public static void flatMap() {
        System.out.println("============= flatMap =============");
        List<List<Integer>> beforetList = Lists.newArrayList(
                Arrays.asList(1,2),
                Arrays.asList(3,4),
                Arrays.asList(5,6)
        );

        System.out.println("change before:" + beforetList.toString());
        List<Integer> afterList = beforetList.stream().flatMap((list) ->
                list.stream()).collect(Collectors.toList());
        System.out.println("change after:" + afterList.toString());
    }

    /**
     * @Des peek
     * peek 与 foreach 功能类似
     * 区别：执行 foreach 后 stream被消费，
     *       而peek不会，可以进行后续操作
     * @param
     */
    public static void peek() {
        System.out.println("============= peek =============");
        List<String> afterList = bastList.stream().peek(e -> {
            System.out.println(e);
        }).filter(x -> {
            if (Objects.isNull(x)) {
                return false;
            }
            char a = x.toCharArray()[0];
            if (a > 'a') {
                return true;
            }
            return false;
        }).map(String::toUpperCase).collect(Collectors.toList());

        System.out.println("after change:" + afterList.toString());
    }

    /**
     * 组合处理
     */
    public static void reduce() {
        System.out.println("============= peek =============");
        System.out.println("String -> concat :");
        List<String> beforeStr = Stream.of("a", "b", "c").collect(Collectors.toList());
        System.out.println("befor string :" + beforeStr.toString());
        String afterStr = beforeStr.stream().reduce(String::concat).get();
        System.out.println("after reduce: " + afterStr);

        System.out.println("Integer -> sum :");
        List<Integer> beforeInt = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
        System.out.println("befor int :" + beforeInt);
        int sum = beforeInt.stream().filter(x -> x > 2).map(e -> e + 1)
                .peek(n -> System.out.println("need to reduce num:"))
                .peek(m -> System.out.println(m))
                .reduce(Integer::sum).get();
        System.out.println("after reduce, sum of nums : " + sum);
    }

    /**
     * limit 和 skip 操作
     * limit ：返回前 n 条数据
     * skip ： 跳过前 n 条数据
     */
    public static void limitAndSkip() {
        System.out.println("============= limit and skip =============");
        String name = "name";
        List<Integer> ids = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).collect(Collectors.toList());
        List<String> names = ids.stream().map(x -> name + x).peek(e -> System.out.println(e))
                .collect(Collectors.toList());
        System.out.println("do limit and skip after : ");
        List<String> afterNames = names.stream().limit(8).skip(6).collect(Collectors.toList());
        // 这里有个小问题：
        // 执行 names.stream().limit(8).skip(6).peek(...) 会提示peek被忽略
        // 这里需要注意一下
        System.out.println("after : " + afterNames);
    }

    /**
     * match
     * allMatch：Stream 中全部元素符合传入的 predicate，返回 true
     * anyMatch：Stream 中只要有一个元素符合传入的 predicate，返回 true
     * noneMatch：Stream 中没有一个元素符合传入的 predicate，返回 true
     *
     */
    public static void match() {
        System.out.println("============= match =============");
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("China", 1300));
        countries.add(new Country("Japan", 100));
        countries.add(new Country("USA", 400));
        countries.add(new Country("India", 1200));
        Predicate<Country> predicate = new Predicate<Country>() {
            @Override
            public boolean test(Country country) {
                if (country.getPopulatioin() > 400) {
                    return true;
                }
                return false;
            }
        };

        Predicate<Country> predicate2 = new Predicate<Country>() {
            @Override
            public boolean test(Country country) {
                if (country.getPopulatioin() > 1500) {
                    return true;
                }
                return false;
            }
        };

        boolean allMany = countries.stream().allMatch(predicate);
        boolean anyMany = countries.stream().anyMatch(predicate);
        System.out.println("all country people more than 400 : " + allMany);
        System.out.println("any country people more than 400 : " + anyMany);

        boolean noneMany = countries.stream().noneMatch(predicate2);
        System.out.println("none country people more than 1500 : " + noneMany);
    }

    /**
     * generate
     *
     * 生成自定义的流
     * 生成规则： 通过传入的Supplier，可以实现自己的Supplier 重写get方法
     */
    public static void generate() {
        System.out.println("============= generate =============");
        Random seed = new Random();
        Supplier<Integer> supplier = seed::nextInt;
        Stream.generate(supplier).limit(10).forEach(System.out::println);

        // 另外的方法
        IntStream.generate(() -> (int) System.nanoTime() % 100).limit(10)
                .forEach(System.out::println);
    }

    /**
     * iterate
     *
     * Stream.iterate 接受一个种子和一个UnaryOperator
     */
    public static void iterate() {
        System.out.println("============= iterate =============");
        System.out.println("等差数列;");
        Stream.iterate(0, n -> n + 3).limit(10).forEach(System.out::println);
    }

    public static void main(String[] args) {
        map();
        flatMap();
        peek();
        reduce();
        limitAndSkip();
        match();
        generate();
        iterate();
    }
}
