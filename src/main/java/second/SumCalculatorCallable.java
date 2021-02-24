package second;

import java.util.List;
import java.util.concurrent.Callable;

public class SumCalculatorCallable implements Callable<Integer> {
    private final List<Integer> list;
    private final int till;
    private final int from;

    public SumCalculatorCallable(List<Integer> list, int from, int till) {
        this.list = list;
        this.till = till;
        this.from = from;
    }

    @Override
    public Integer call() {
        return list.subList(from, till)
                .stream()
                .mapToInt(Math::toIntExact)
                .sum();
    }
}
