package second;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CustomForkJoinTest {
    private static CustomList customList;
    private static CustomForkJoin customForkJoin;

    @BeforeAll
    static void beforeAll() {
        customList = new CustomList();
        customForkJoin = new CustomForkJoin(customList.getList());
    }

    @Test
    void sum_Ok() {
        Assertions.assertEquals(customList.sum(), customForkJoin.compute());
    }
}
