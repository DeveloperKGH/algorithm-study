import java.util.Collections;
import java.util.List;

/*
 * 이진 탐색
 * 1. 데이터가 정렬되어 있는 배열에서 특정한 값을 찾아내는 알고리즘
 * 2. 분할 정복 알고리즘의 하나 (문제를 우선 작은 문제로 쪼개고 난 후 다시 조합하여 원래의 문제를 푼다.)
 * 3. 알고리즘 구조
 * 3-1. 배열의 중간에 있는 임의의 값을 선택하여, 리스트를 두개의 서브 리스트로 나눈다. (Divide)
 * 3-2. 찾고자 하는 값이 임의의 중간 값보다 작은 경우 중간 값 기준 좌측의 숫자들을, 큰 경우 우측의 숫자들을 찾는다. (Conquer)
 * 3-3. 찾고자 하는 값을 찾을때까지 분할과 정복을 반복한다.
 */

public class BinarySearch {

    public boolean search(List<Integer> list, int target) {
        //CASE 1 : 리스트의 사이즈가 0 인 경우 : 찾아볼 대상의 값 조차도 존재하지 않으므로 false return
        if (list.size() == 0) return false;

        //CASE 2 : 리스트의 사이즈가 1 인 경우 : 찾아볼 대상의 값이 target 과 일치하는지 여부 return
        if (list.size() == 1) {
            return list.get(0) == target;
        }


        //CASE 3 : 리스트의 사이즈가 2 이상인 경우
        //배열의 중간에 있는 임의의 값을 선택하여, 정렬 된 리스트를 두개의 서브 리스트로 나눈다.
        int medium = list.size() / 2;
        Collections.sort(list);

        //찾고자 하는 값이 임의의 중간 값보다 작은 경우 중간 값 기준 좌측의 숫자들을, 큰 경우 우측의 숫자들을 찾는다. 그리고, 찾고자 하는 값을 찾을때까지 분할과 정복을 반복한다.
        if (target == list.get(medium)) {
            return true;
        } else if (target < list.get(medium)) {
            return search(list.subList(0, medium), target);
        } else {
            return search(list.subList(medium, list.size()), target);
        }

    }

}
