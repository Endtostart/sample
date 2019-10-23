package thread.future;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FutureDemo {
    public static void main(String[] args) throws ExecutionException {

        List<Integer> list = Stream.iterate(1, i -> i + 1).limit(20).collect(Collectors.toList());
        System.out.println(list);

        List<Future<Integer>> futures = list.stream().map(x -> Executors.newSingleThreadExecutor().submit(() -> x)).collect(Collectors.toList());
        List<MyFuture<Integer>> myFutures = Lists.newArrayList();
        for (Future<Integer> future : futures) {
            MyFuture<Integer> myFuture = new MyFuture<>(future);
            myFutures.add(myFuture);
        }

        Integer count = myFutures.stream().map(x -> x.get()).reduce(0, Integer::sum);
        System.out.println(count);

    }
}

class MyFuture<T> implements Future {

    private Future<T> delegate;

    public static Future newInstance(Future future) {
        return new MyFuture(future);
    }

    public MyFuture(Future<T> future) {
        delegate = future;
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return delegate.cancel(mayInterruptIfRunning);
    }

    @Override
    public boolean isCancelled() {
        return delegate.isCancelled();
    }

    @Override
    public boolean isDone() {
        return delegate.isDone();
    }

    @Override
    public T get() {
        try {
            return delegate.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return delegate.get(timeout, unit);
    }
}
