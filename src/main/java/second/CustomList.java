package second;

import java.util.ArrayList;
import java.util.List;

public class CustomList {
    private static final List<Integer> list = new ArrayList<>();
    private static final int MIN = 0;
    private static final int MAX = 1_000_000;

    public CustomList() {
        int counter = MIN;
        for (; counter < MAX; counter++) {
            list.add(counter);
        }
    }

    public List<Integer> getList() {
        return list;
    }

    public int sum() {
        return list
                .stream()
                .mapToInt(s -> s)
                .sum();
    }
}
