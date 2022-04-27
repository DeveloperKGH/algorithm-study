import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 병합 정렬
 * 1. 분할 정복 알고리즘의 하나 (문제를 우선 작은 문제로 쪼개고 난 후 다시 조합하여 원래의 문제를 푼다.)
 * 2. 알고리즘 구조
 * 2-1. 리스트를 절반으로 잘라 비슷한 크기의 두 부분 리스트로 나눈다.
 * 2-2. 각 부분 리스트를 재귀적으로 병합 정렬을 이용해 정렬한다.
 * 2-3. 두 부분 리스트를 다시 하나의 정렬된 리스트로 병합한다.
 */

public class MergeSort {

    //리스트를 절반으로 잘라 비슷한 크기의 두 부분 리스트로 나눈후, 각 부분 리스트를 재귀적으로 병합 정렬을 이용해 정렬한다.
    public List<Integer> splitAndMerge(List<Integer> list) {
        // 리스트 사이즈가 1개 이하인 경우 해당 값 리턴
        if (list.size() <= 1) return list;

        int medium = list.size() / 2;

        List<Integer> leftList;
        List<Integer> rightList;

        leftList = splitAndMerge(list.subList(0, medium));
        rightList = splitAndMerge(list.subList(medium, list.size()));

        return merge(leftList, rightList);
    }

    //두 부분 리스트를 다시 하나의 정렬된 리스트로 병합한다.
    public List<Integer> merge(List<Integer> leftList, List<Integer> rightList) {
        List<Integer> mergedList = new ArrayList<>();

        int leftIndex = 0;
        int rightIndex = 0;

        // CASE 1: 왼쪽/오른쪽 모두 아이템이 남아있는 경우
        while (leftList.size() > leftIndex && rightList.size() > rightIndex) {
            if (leftList.get(leftIndex) < rightList.get(rightIndex)) {
                mergedList.add(leftList.get(leftIndex));
                leftIndex += 1;
            } else {
                mergedList.add(rightList.get(rightIndex));
                rightIndex += 1;
            }
        }

        // CASE 2: 왼쪽만 남아있는 경우
        while (leftList.size() > leftIndex) {
            mergedList.add(leftList.get(leftIndex));
            leftIndex += 1;
        }

        // CASE 3: 오른쪽만 남아있는 경우
        while (rightList.size() > rightIndex) {
            mergedList.add(rightList.get(rightIndex));
            rightIndex += 1;
        }

        return mergedList;
    }

}
