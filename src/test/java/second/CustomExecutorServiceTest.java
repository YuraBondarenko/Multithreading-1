package second;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CustomExecutorServiceTest {
    private static CustomList customList;
    private static CustomExecutorService customExecutorService;

    @BeforeAll
    static void beforeAll() {
        customList = new CustomList();
        customExecutorService = new CustomExecutorService(customList);
    }

    @Test
    void sum_Ok() {
        Assertions.assertEquals(customList.sum(), customExecutorService.sum());
    }
}
