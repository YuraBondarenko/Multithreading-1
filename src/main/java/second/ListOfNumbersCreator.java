package second;

import java.util.ArrayList;
import java.util.List;

public class ListOfNumbersCreator {
    public List<Integer> getList(int start, int end) {
        List<Integer> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(i);
        }
        return list;
    }
}
