import java.util.Collections;
import java.util.List;

/*
 * 버블 정렬
 * 두 인접한 데이터 비교 후, 앞에 있는 데이터가 뒤에 있는 데이터보다 크면 자리 변경
 * 규칙1 : n개의 리스트가 있는 경우 최대 n-1 번의 로직이 적용
 * 규칙2 : 로직이 1번씩 적용 될때마다 가장 큰 숫자가 맨 뒤에서 결정됨
 * 규칙3 : 로직이 일찍 끝날 수 도 있음 (ex : 이미 정렬된 경우). 따라서, 로직 적용 시 한번도 데이터가 교환된 적이 없다면, 이미 정렬된 상태이므로 로직을 더이상 적용 할 필요 없음
 */

public class BubbleSort {

    public List<Integer> sort(List<Integer> list) {

        // n개의 리스트가 있는 경우 최대 n-1 번의 로직이 적용
        for (int i = 0; i < list.size() - 1; i++) {
            boolean swap = false;

            /*
            * j 인덱스와 j+1 인덱스의 값을 비교하여 큰 수를 뒤쪽에 정렬
            * 로직이 1번씩 적용 될때마다 가장 큰 숫자가 맨 뒤에서 결정됨
            * */
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    Collections.swap(list, j, j+1);
                    swap = true;
                }
            }

            //로직 적용 시 한번도 데이터가 교환된 적이 없다면, 이미 정렬된 상태이므로 로직을 더이상 적용 할 필요 없음
            if (!swap) break;

        }

        return list;
    }

}
