package second;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CustomExecutorService {
    private static final int AMOUNT_OF_THREADS = 10;
    private static final int THREADS = 4;
    private final List<Integer> list;

    public CustomExecutorService(List<Integer> list) {
        this.list = list;
    }


    public Integer getSum() {
        int size = list.size();
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        List<Callable<Integer>> callables = new ArrayList<>();
        for (int i = 0; i < AMOUNT_OF_THREADS; i++) {
            callables.add(new SumCalculatorCallable(list,
                    i * size / AMOUNT_OF_THREADS, (i + 1) * size / AMOUNT_OF_THREADS));
        }
        int result = 0;
        try {
            List<Future<Integer>> futures = executorService.invokeAll(callables);
            for (Future<Integer> future : futures) {
                result += future.get();
            }
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException("Cannot invoke", e);
        } catch (ExecutionException e) {
            throw new RuntimeException("Cannot get", e);
        } finally {
            executorService.shutdown();
        }
    }
}
