package future.CompletableFuture;

import common.utils.StringUtil;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureDemo {


    public void baseExample() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Integer> list = Stream.iterate(1, i -> i + 1).limit(20).collect(Collectors.toList());
        System.out.println(list);
        List<CompletableFuture<Integer>> futures = list.stream().map(x -> CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " 数值:" + x);
            return x;
        },executorService).thenApplyAsync((z)->{
            return z.intValue()+1;
        })).collect(Collectors.toList());
        Integer sum = futures.stream().map(CompletableFuture::join).reduce(0, Integer::sum);
        System.out.println(sum);
    }

    public void thenApplyExample() {
        String message = "message";
        CompletableFuture.supplyAsync(() -> message).thenApply((x) -> x + "app").thenAccept(System.out::println);
    }

    /**
     * 异步消费
     * @Author N.wang
     * @Date 11:09 2018/11/1
     * @Param
     * @return
     **/
    public void thenAcceptAsyncExample() {
        StringBuilder sb = new StringBuilder();
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Date date = new Date();
            return "complate..." + date.toString();
        }).thenAcceptAsync(s -> sb.append(s));
        System.out.println("run..." + new Date());
        future.join();
        System.out.println("end..." + new Date());
        System.out.println(sb.toString());
    }



    /**
     * 同步 将两个执行结果合并
     * @Author N.wang
     * @Date 11:07 2018/11/1
     * @Param
     * @return
     **/
    public void thenCombineExample() {
        String msg = "message";
        CompletableFuture<String> future = CompletableFuture.completedFuture(msg).thenApply(s->{
            System.out.println("future1 runing begainTime:" + new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future1 runing endTime:" + new Date());
            return msg + "future1 " + new Date();
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            System.out.println("future2 run begainTime" + new Date());
            return msg + "future2" + new Date();
        }), (s1, s2) -> s1 + s2);

        System.out.println("result: "+future.getNow(null));
    }

    /**
     * 异步 将两个结果合并
     * @Author N.wang
     * @Date 11:08 2018/11/1
     * @Param
     * @return
     **/
    public void thenCombineAsyncExample() {
        String msg = "message";
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future1 runing begainTime:" + new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future1 runing endTime:" + new Date());
            return msg + "future1 " + new Date();
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            System.out.println("future2 run begainTime" + new Date());
            return msg + "future2" + new Date();
        }), (s1, s2) -> s1 + s2);
        System.out.println(future1.join());
    }


    /**
     * 多个任务 其中一个执行完成后创建 CompletableFuture
     * @Author N.wang
     * @Date 11:23 2018/11/1
     * @Param
     * @return
     **/
    public void anyOfExample() {
        StringBuilder sb = new StringBuilder();
        List<String> messages = Arrays.asList("a", "b", "c");
        List<CompletableFuture<String>> futures = messages.stream().map(msg -> CompletableFuture.completedFuture(msg)
                .thenApply(s -> s.toUpperCase())).collect(Collectors.toList());
        CompletableFuture.anyOf(futures.toArray(new CompletableFuture[futures.size()])).whenComplete((res,th)->{
            if (th == null) {
                System.out.println(res.equals(res.toString().toUpperCase()));
                sb.append(res);
            }
        });
        System.out.println(sb.toString());
    }

    /**
     * 同步执行
     * 所有执行完成创建 CompletableFuture
     * @Author N.wang
     * @Date 11:36 2018/11/1
     * @Param
     * @return
     **/
    public void allOfExample() {
        StringBuilder sb = new StringBuilder();
        List<String> messages = Arrays.asList("a", "b", "c");
        System.out.println("messgae:" + messages);
        List<CompletableFuture<String>> futures = messages.stream().map(msg ->
            CompletableFuture.completedFuture(msg).thenApply(s -> s.toUpperCase())
        ).collect(Collectors.toList());

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).whenComplete((res,th)->{
            futures.forEach(x->{
                System.out.println(x.getNow(null).toString());
                sb.append(x.getNow(null));
            });
        });
        System.out.println("result:"+sb.toString());
    }

    public void allofAsyncExample() {
        StringBuilder sb = new StringBuilder();
        List<String> messages = Arrays.asList("a", "b", "c");
        System.out.println("messgae:" + messages);
        List<CompletableFuture<String>> futures = messages.stream().map(x -> CompletableFuture.completedFuture(x)
                .thenApplyAsync(e -> e.toUpperCase())).collect(Collectors.toList());
        CompletableFuture allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
                .whenComplete((v,th)->{
                    futures.forEach(f->{
                        System.out.println(f.getNow(null));
                        sb.append(f.getNow(null));
                    });
                });
        allOf.join();
        System.out.println("result:" + sb.toString());
    }


    public static void main(String[] args) {
        CompletableFutureDemo demo = new CompletableFutureDemo();
        //demo.thenApplyExample();
        //demo.thenAcceptAsyncExample();
        //demo.thenCombineAsyncExample();
        //demo.thenCombineExample();
        demo.anyOfExample();
        //demo.allOfExample();
        //demo.allofAsyncExample();
    }
}
