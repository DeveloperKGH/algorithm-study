
/*
 * 탐욕 알고리즘 (Greedy Algorithm)
 * 1. 선택의 순간마다 당장 눈앞에 보이는 최선의 선택(가장 좋은 것)을 골라, 최종적인 값을 구하는 방식
 * 2. 최적의 해를 구하는데 사용하는 근사적인 방법
 * 3. 순간마다 하는 선택은 그 순간에 대해 지역적으로는 최적이지만, 그 선택들을 계속 수집하여 최종적(전역적)인 해답을 만들었다고 해서, 그것이 최적이라는 보장은 없음
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class GreedyAlgorithm {

    /*
    * 동전 문제
    * 지불해야 하는 값이 x원 일 때 주어진 동전 리스트를 활용하여 동전의 수가 가장 적게 지불하는 문제
    */

    public void coinFunction(Integer price, List<Integer> coins) {
        // 지불해야 하는 값이 0 또는 동전 리스트가 비어 있는경우 return
        if (price == 0 || coins.size() == 0) return;

        //가장 적은 동전 수로 지불하기 위해서는? : 큰금액의 동전부터 차례대로 지불
        coins.sort(Comparator.reverseOrder());

        int totalCoinCount = 0;
        int coinCount;

        // 지불해야할 남은 금액이 코인의 금액보다 작은 경우 0으로 skip
        for (Integer coin : coins) {
            coinCount = price / coin;
            totalCoinCount += coinCount;
            price -= coinCount * coin;

            System.out.println(coin + "원 동전 : " + coinCount + " 개");
        }

        System.out.println("총 동전 갯수 = " + totalCoinCount);

    }

    /*
     * 부분 배낭 문제 (Fractional Knapsack Problem)
     * 무게 제한이 x인 배낭에 최대 가치를 가지도록 물건을 넣는 문제 (단, 물건은 쪼갤 수 있으므로 물건의 일부분이 배낭에 넣어질 수 있음)
     *
     * |  물건  |  A |  B  |  C  |  D  |  E  |
     *
     * |  무게  | 10 | 15 | 20 | 25 | 30 |
     *
     * |  가치 | 10 | 12 | 10 | 8 | 5 |
     *
     */

    public void fractionalKnapsackFunction(double capacity) {
        // 한정된 무게에 최대 가치를 가지도록 물건을 넣기 위해서는? : 무게당 가치가 가장 높은 물건을 먼저 넣기위하여 내림차순 정렬
        Double[][] items = { {10.0, 10.0}, {15.0, 12.0}, {30.0, 5.0}, {25.0, 8.0}, {20.0, 10.0}};
        Arrays.sort(items, (list1, list2) -> Double.compare(list2[1] / list2[0], list1[1] / list1[0]));

        double totalValue = 0.0;
        double fraction;

        // 무게당 가치가 가장 높은 물건을 먼저 넣고, 배낭에 남은 무게가 넣을 물건의 무게보다 작을 경우 물건의 무게와 가치를 쪼개어서 넣기
        for (Double[] item : items) {
            if (capacity - item[0] > 0) {
                capacity -= item[0];
                totalValue += item[1];

                System.out.println("넣을 무게 = " + item[0]);
                System.out.println("넣을 가치 = " + item[1]);
                System.out.println("현재까지 넣은 가치 = " + totalValue);
                System.out.println("============================");
            } else {
                fraction = capacity / item[0];
                totalValue += fraction * item[1];

                System.out.println("원래 무게 = " + item[0]);
                System.out.println("쪼개서 넣을 무게 = " + capacity);
                System.out.println("쪼개서 넣을 가치 = " + fraction * item[1]);
                System.out.println("총 넣은 가치 = " + totalValue);
                System.out.println("============================");
                break;
            }
        }

    }

}
