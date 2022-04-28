
/*
 * 퀵 정렬
 * 1. 분할 정복 알고리즘의 하나 (문제를 우선 작은 문제로 쪼개고 난 후 다시 조합하여 원래의 문제를 푼다.)
 * 2. 알고리즘 구조
 * 2-1. 리스트 안에 한 요소를 기준점(pivot)으로 정한다.
 * 2-2. 피벗을 기준으로 피벗보다 작은 요소들은 모두 피벗의 왼쪽으로 옮겨지고, 피벗보다 큰 요소들은 모두 피벗의 오른쪽으로 옮겨진다.
 * 2-3. 피벗을 기준으로 분할 된 왼쪽/오른쪽 리스트에 대하여 재귀용법을 통하여 분할 및 정렬을 반복한다. (분할된 리스트의 크기가 0 또는 1 될때까지)
 * 2-4. 정복이 완료 된 리스트들을 다시 병합하여 하나의 정렬된 리스트로 만든다.
 */

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    public List<Integer> sort(List<Integer> list) {
        if (list.size() <= 1) return list;

        //리스트 안에 한 요소를 기준점(pivot)으로 정한다.
        int pivot = list.get(0);

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        //피벗을 기준으로 피벗보다 작은 요소들은 모두 피벗의 왼쪽으로 옮겨지고, 피벗보다 큰 요소들은 모두 피벗의 오른쪽으로 옮겨진다.
        for (int i = 1; i < list.size(); i ++) {
            if (pivot > list.get(i)) {
                leftList.add(list.get(i));
            } else {
                rightList.add(list.get(i));
            }
        }
        List<Integer> mergedList = new ArrayList<>();

        //피벗을 기준으로 분할 된 왼쪽/오른쪽 리스트에 대하여 재귀용법을 통하여 분할 및 정렬을 반복한다. (분할된 리스트의 크기가 0 또는 1 될때까지) 그 후, 정복이 완료 된 리스트들을 다시 병합하여 하나의 정렬된 리스트로 만든다.
        mergedList.addAll(sort(leftList));
        mergedList.addAll(List.of(pivot));
        mergedList.addAll(sort(rightList));

        return mergedList;
    }

}
