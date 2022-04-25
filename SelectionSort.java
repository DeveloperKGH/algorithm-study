import java.util.Collections;
import java.util.List;

/*
 * 선택 정렬
 * 배열안의 최소값을 찾아, 맨 앞에 값과 교체해나가면서 배열안의 모든 데이터를 순회하며 정렬한다.
 * 규칙1 : n개의 리스트가 있는 경우 최대 n-1 번의 로직이 적용
 * 규칙2 : 각 로직마다 맨 앞의 가장 작은수와 그외의 나머지 배열 원소값들을 순회하며 비교하여, 맨 앞의 수보다 작을 경우 위치 변경
 * 규칙3 : 로직이 1번씩 적용 될때마다 가장 작은 숫자가 맨 앞에서 결정됨
 */

public class SelectionSort {

    public List<Integer> sort(List<Integer> list) {
        int lowest = 0;

        //n개의 리스트가 있는 경우 최대 n-1 번의 로직이 적용
        for (int target = 0; target < list.size() - 1; target ++) {
            lowest = target;

            //각 로직마다 맨 앞의 가장 작은수와 그외의 나머지 배열 원소값들을 순회하며 비교하여, 맨 앞의 수보다 작을 경우 위치 변경
            for (int comparison = target + 1; comparison < list.size(); comparison ++) {
                if (list.get(lowest) > list.get(comparison)) {
                    lowest = comparison;
                }
            }

            //로직이 1번씩 적용 될때마다 가장 작은 숫자가 맨 앞에서 결정됨
            Collections.swap(list, lowest, target);

        }

        return list;
    }

}
