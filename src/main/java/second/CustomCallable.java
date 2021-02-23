package second;

import java.util.concurrent.Callable;

public class CustomCallable implements Callable<Integer> {
    private final CustomList customList;
    private final int till;
    private final int from;

    public CustomCallable(CustomList customList, int from, int till) {
        this.customList = customList;
        this.till = till;
        this.from = from;
    }

    @Override
    public Integer call() {
        return customList.getList().subList(from, till)
                .stream()
                .mapToInt(Math::toIntExact)
                .sum();
    }
}
