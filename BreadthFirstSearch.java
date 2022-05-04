import java.util.*;

/*
 * 너비 우선 탐색
 * 1. 하나의 노드와 같은 레벨에 있는 노드들 (형제 노드들)을 먼저 탐색하는 방식
 * 2. 최단거리(모든 간선의 비용 동일) 를 구하는 문제를 효과적으로 해결 할 수 있음
 * 3. 자료구조 큐를 활용 (needVisit, visited)
 * 3. 알고리즘 구조
 * 3-1. 탐색을 시작하는 노드의 정보를 방문이 필요한 큐(needVisit)에 삽입
 * 3-2. 방문이 필요한 큐(needVisit)에서 노드를 꺼내어, 인접 노드들을 찾아 차례대로 삽입
 * 3-3. 꺼낸 노드는 이미 방문한 큐에 삽입한다. (값이 중복인 경우 skip)
 */

public class BreadthFirstSearch {
    String node;
    Map<String, List<String>> graph = new HashMap<>();

    public BreadthFirstSearch() {
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

        //탐색을 시작하는 노드의 정보를 방문이 필요한 큐(needVisit)에 삽입
        needVisit.add(node);
        int count = 0;

        while (needVisit.size() > 0) {
            String node = needVisit.remove(0);

            //방문이 필요한 큐(needVisit)에서 노드를 꺼내어, 인접 노드들을 찾아 차례대로 삽입 및 꺼낸 노드는 이미 방문한 큐에 삽입한다. (값이 중복인 경우 skip)
            if (!visited.contains(node)) {
                needVisit.addAll(graph.get(node));
                visited.add(node);
                System.out.println("탐색 node = " + node);
            }

            count++;

        }

        System.out.println("시간 복잡도 count = " + count);

    }

    public void searchByQueue() {
        Queue<String> visited = new LinkedList<>();
        Queue<String> needVisit = new LinkedList<>();

        //탐색을 시작하는 노드의 정보를 방문이 필요한 큐(needVisit)에 삽입
        needVisit.offer(node);
        int count = 0;

        while (needVisit.size() > 0) {
            String node = needVisit.poll();

            //방문이 필요한 큐(needVisit)에서 노드를 꺼내어, 인접 노드들을 찾아 차례대로 삽입 및 꺼낸 노드는 이미 방문한 큐에 삽입한다. (값이 중복인 경우 skip)
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
