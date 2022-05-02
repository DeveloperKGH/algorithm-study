import java.util.List;

/*
 * 순차 탐색
 * 탐색은 여러 데이터 중 원하는 데이터를 찾아내는 것을 의미하고, 순차 탐색은 배열을 앞에서부터 하나씩 비교해서 원하는 데이터를 찾는 방법
 */

public class SequentialSearch {

    public int search(List<Integer> list, int target) {
        for (int item : list) {
            if (target == item) {
                return target;
            }
        }

        return -1;
    }

}
