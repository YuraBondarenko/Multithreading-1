package second;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CustomExecutorServiceTest {
    private static ListOfNumbersCreator listOfNumbersCreator;
    private CustomExecutorService customExecutorService;

    @BeforeAll
    public static void beforeAll() {
        listOfNumbersCreator = new ListOfNumbersCreator();
    }

    @Test
    public void sum_Ok() {
        List<Integer> list = listOfNumbersCreator.getList(0, 1_000_000);
        customExecutorService = new CustomExecutorService(list);
        Assertions.assertEquals(list
                .stream()
                .reduce(0, Integer::sum), customExecutorService.getSum());
    }

    @Test
    public void negativeNumbers_Ok() {
        List<Integer> list = listOfNumbersCreator.getList(-100, -1);
        customExecutorService = new CustomExecutorService(list);
        Assertions.assertEquals(list
                .stream()
                .reduce(0, Integer::sum), customExecutorService.getSum());
    }

    @Test
    public void empty_Ok() {
        List<Integer> list = listOfNumbersCreator.getList(0, 0);
        customExecutorService = new CustomExecutorService(list);
        Assertions.assertEquals(list
                .stream()
                .reduce(0, Integer::sum), customExecutorService.getSum());
    }
}
