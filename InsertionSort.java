import java.util.Collections;
import java.util.List;

/*
 * 삽입 정렬
 * 두번째 인덱스부터 시작하여, 해당 인덱스를 key 로 만들어 앞에 인덱스 데이터와 비교하여 key의 값이 작은경우 앞으로 이동
 * 규칙1 : n개의 리스트가 있는 경우 최대 n-1 번의 로직이 적용
 * 규칙2 : key 인덱스를 기준으로 앞에 정렬되어 있는 인덱스들과 크고작음을 비교하여 삽입
 */

public class InsertionSort {

    public List<Integer> sort(List<Integer> list) {
        //n개의 리스트가 있는 경우 최대 n-1 번의 로직이 적용
        for (int i = 0; i < list.size() - 1; i++) {
            //key 인덱스를 기준으로 앞에 정렬되어 있는 인덱스들과 크고작음을 비교하여 삽입
            for (int j = i + 1; j > 0; j--) {
                if (list.get(j) < list.get(j - 1)) Collections.swap(list, i, j);
            }
        }
        return list;
    }

}
