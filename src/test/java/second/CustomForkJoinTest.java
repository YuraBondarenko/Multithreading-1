package second;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CustomForkJoinTest {
    private static ListOfNumbersCreator listOfNumbersCreator;
    private CustomForkJoin customForkJoin;

    @BeforeAll
    static void beforeAll() {
        listOfNumbersCreator = new ListOfNumbersCreator();
    }

    @Test
    void sum_Ok() {
        List<Integer> list = listOfNumbersCreator.getList(0, 1_000_000);
        customForkJoin = new CustomForkJoin(list);
        Assertions.assertEquals(list
                .stream()
                .reduce(0, Integer::sum), customForkJoin.compute());
    }

    @Test
    public void negativeNumbers_Ok() {
        List<Integer> list = listOfNumbersCreator.getList(-100, -1);
        customForkJoin = new CustomForkJoin(list);
        Assertions.assertEquals(list
                .stream()
                .reduce(0, Integer::sum), customForkJoin.compute());
    }

    @Test
    public void empty_Ok() {
        List<Integer> list = listOfNumbersCreator.getList(0, 0);
        customForkJoin = new CustomForkJoin(list);
        Assertions.assertEquals(list
                .stream()
                .reduce(0, Integer::sum), customForkJoin.compute());
    }
}
