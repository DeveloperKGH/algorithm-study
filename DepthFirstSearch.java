import java.util.*;

/*
 * 깊이 우선 탐색
 * 1. 하나의 노드의 자식 레벨에 있는 노드들 (자식 노드들)을 먼저 탐색하는 방식 (최대한 깊이 내려간 뒤, 더이상 깊이 갈 곳이 없을 경우 옆으로 이동)
 * 2. 모든 노드를 방문 하고자 하는 경우에 이 방법을 선택
 * 3. 자료구조 스택과 큐를 활용 (needVisit : 스택, visited : 큐)
 * 3. 알고리즘 구조
 * 3-1. 탐색을 시작하는 노드의 정보를 방문이 필요한 스택(needVisit)에 삽입
 * 3-2. 방문이 필요한 스택(needVisit)에서 순서상 마지막 노드를 꺼내어, 인접 노드들을 찾아 차례대로 삽입
 * 3-3. 꺼낸 노드는 이미 방문한 큐에 삽입한다. (값이 중복인 경우 skip)
 */

public class DepthFirstSearch {
    String node;
    Map<String, List<String>> graph = new HashMap<>();


    /*
    *        <그래프 형태>
    *
    *              A
    *            /  \
    *          B     C
    *        /    /  |  \
    *      D    G   H    I
    *    /  \             \
    *  E     F             J
    *
    *
    * */

    public DepthFirstSearch() {
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("A", "D"));
        graph.put("C", Arrays.asList("A", "G", "H", "I"));
        graph.put("D", Arrays.asList("B", "E", "F"));
        graph.put("E", List.of("D"));
        graph.put("F", List.of("D"));
        graph.put("G", List.of("C"));
        graph.put("H", List.of("C"));
        graph.put("I", Arrays.asList("C", "J"));
        graph.put("J", List.of("I"));

        node = "A";
    }

    public void searchByList() {
        List<String> visited = new ArrayList<>();
        List<String> needVisit = new ArrayList<>();

        //탐색을 시작하는 노드의 정보를 방문이 필요한 스택(needVisit)에 삽입
        needVisit.add(node);
        int count = 0;

        while (needVisit.size() > 0) {
            String node = needVisit.remove(needVisit.size() - 1);

            ////방문이 필요한 스택(needVisit)에서 순서상 마지막 노드를 꺼내어, 인접 노드들을 찾아 차례대로 삽입 및 꺼낸 노드는 이미 방문한 큐에 삽입한다. (값이 중복인 경우 skip)
            if (!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(graph.get(node));
                System.out.println("탐색 node = " + node);
            }

            count ++;
        }

        System.out.println("시간 복잡도 count = " + count);

    }

    public void searchByQueueAndStack() {
        Queue<String> visited = new LinkedList<>();
        Stack<String> needVisit = new Stack<>();

        //탐색을 시작하는 노드의 정보를 방문이 필요한 스택(needVisit)에 삽입
        needVisit.push(node);
        int count = 0;

        while (needVisit.size() > 0) {
            String node = needVisit.pop();

            //방문이 필요한 스택(needVisit)에서 순서상 마지막 노드를 꺼내어, 인접 노드들을 찾아 차례대로 삽입 및 꺼낸 노드는 이미 방문한 큐에 삽입한다. (값이 중복인 경우 skip)
            if (!visited.contains(node)) {
                needVisit.addAll(graph.get(node));
                visited.add(node);
                System.out.println("탐색 node = " + node);
            }

            count++;

        }

        System.out.println("시간 복잡도 count = " + count);

    }

}
