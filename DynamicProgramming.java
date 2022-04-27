
/*
 * 동적 계획법 (Dynamic Programming)
 * 1. 문제를 풀 때 하나의 문제를 여러 하위 문제로 나누어 풀고, 그것들의 해를 활용해서, 보다 큰 크기의 부분 문제를 해결, 최종적으로 문제를 해결하는 알고리즘
 * 2. 상향식 접근법(bottom-up approach) / 메모이제이션(Memoization) 사용
 * 2-1. 상향식 접근법(bottom-up approach) : 가장 최하위 해답을 구한 후, 이를 저장하고, 해당 결과값을 활용하여 상위 문제를 풀어가는 방식
 * 2-2. 메모이제이션(Memoization) : 프로그램 실행 시 이전에 계산한 값을 저장하여, 다시 계산하지 않도록 하여 전체 실행 속도를 빠르게 하는 기술
 */

public class DynamicProgramming {

    /*
    * 피보나치 수열을 구현할 때 재귀용법을 활용하여 구현한다면, 이미 진행되었던 연산이 중복으로 연산되어 낭비가 있음
    * ex) fibonacci(6) 을 구할때 fibonacci(4)의 연산이 두번 진행 됨
    * 따라서, 메모이제이션(Memoization) 을 활용하여 진행되는 연산을 기록하여, 중복으로 연산을 방지하여 해결하는 동적계획법이 고안됨
    */

    // 재귀용법 활용을 통한 피보나치 수열 구현
    public int fibonacciFuncByRecursion(int n) {
        if (n <= 1) return n;

        return fibonacciFuncByRecursion(n - 1) + fibonacciFuncByRecursion(n - 2);
    }

    // 동적계획법 활용을 통한 피보나치 수열 구현
    public int fibonacciFuncByDp(int n) {
        int[] cache = new int[n + 1];

        cache[0] = 0;
        cache[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[n];
    }

}
