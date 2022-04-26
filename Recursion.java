
/*
 * 재귀용법
 * 함수 안에서 동일한 함수를 호출
 */

import java.util.List;

public class Recursion {

    /*
     * 팩토리얼 함수 예제 1
     */
    public int function1(int n) {
        if (n > 1) {
            return n * function1(n - 1);
        }

        return 1;
    }

    /*
     * 팩토리얼 함수 예제 2
     */
    public int function2(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * function2(n - 1);
    }

    /*
     * 숫자가 들어 있는 배열이 주어졌을 때, 배열의 합을 리턴하는 코드
     */
    public int function3(List<Integer> list) {
        if (list.size() <= 0) return 0;
        return list.get(0) + function3(list.subList(1, list.size()));
    }

    /*
     * 정수 n이 입력으로 주어졌을 때, n을 1, 2, 3의 합으로 나타낼 수 있는 방법의 수?
     * 1 : 1
     * -> 1가지
     * 2 : 1+1, 2
     * -> 2가지
     * 3 : 1+1+1, 1+2, 2+1, 3
     * -> 4가지
     * 4 : 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 1+3, 3+1, 2+2
     * -> 7가지
     * 5 : 1+1+1+1+1, 1+1+1+2, 1+1+2+1, 1+2+1+1, 2+1+1+1, 2+3, 3+2, 1+1+3, 1+3+1, 3+1+1, 1+2+2, 2+1+2, 2+2+1
     * -> 13가지
     *
     * 규칙 : f(n) = f(n-1) + f(n-2) + f(n-3)
     */
    public int function4(int n) {
        switch (n) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
            default:
                return function4(n - 1) + function4(n - 2) + function4(n - 3);
        }
    }

}
