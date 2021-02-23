package second;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CustomForkJoin extends RecursiveTask<Integer> {
    private static final int AMOUNT_OF_THREADS = 10;
    private static final int THRESHOLD = 100_000;
    private final List<Integer> list;

    public CustomForkJoin(List<Integer> list) {
        this.list = list;
    }

    @Override
    protected Integer compute() {
        if (list.size() > THRESHOLD) {
            return ForkJoinTask.invokeAll(createSubtasks())
                    .stream()
                    .mapToInt(ForkJoinTask::join)
                    .sum();
        }
        return processing();
    }

    private List<CustomForkJoin> createSubtasks() {
        List<CustomForkJoin> subtasks = new ArrayList<>();
        for (int i = 0; i < AMOUNT_OF_THREADS; i++) {
            subtasks.add(new CustomForkJoin(list
                    .subList(i * list.size() / AMOUNT_OF_THREADS,
                            (i + 1) * list.size() / AMOUNT_OF_THREADS)));
        }
        return subtasks;
    }

    private Integer processing() {
        return list
                .stream()
                .mapToInt(s -> s)
                .sum();
    }

}
