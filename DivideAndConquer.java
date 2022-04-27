/*
 * 분할 정복 (Divide and Conquer)
 * 1. 문제를 풀 때 나눌 수 없을때까지 나누어서, 각각을 풀면서 다시 병합하여 최종적으로 문제를 해결하는 알고리즘
 * 2. 하향식 접근법(top-down approach) 사용 : 상위의 해답을 구하기 위해 아래로 내려가면서 해답을 구하는 방식 (재귀용법 사용)
 * 3. 알고리즘 구조
 * 3-1. Divide : 문제가 분할이 가능한 경우, 더 작은 하위 문제로 분할을 계속 수행한다.
 * 3-2. Conquer : 재귀적으로 각 하위 문제들을 해결하고, 하위 문제의 규모가 더 이상 나눌 수 없는 경우 탈출한다.
 * 3-3. Combine : Conquer 한 문제들을 통합하여 원래 문제의 답을 얻어 해결한다.
 */

public class DivideAndConquer {

    /*
    * 1. Divide: 1 ~ n까지의 합을 절반 씩 나눈다.
    * 2. Conquer: 절반씩 나눈 것들의 합을 구한다.
    * 3. Combine: Conquer에서 구한 값들을 모두 합친다.
    */
    public int sum(int start, int end) {
        if (start >= end) return start;
        int medium = (start + end) / 2;
        return sum(start, medium) + sum(medium + 1, end);
    }

}
