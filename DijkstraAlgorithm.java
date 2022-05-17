
/*
 * 다익스트라 알고리즘 (Dijkstra Algorithm)
 * 1. 그래프의 한 노드에서 다른 모든 노드까지의 최단 경로를 구하는 알고리즘 (가중치 그래프에서 간선의 가중치 합이 최소가 되도록)
 * 2. 인공위성 GPS 소프트웨어 등에서 가장 많이 사용
 * 3. 알고리즘 구조
 * 3-1. 첫 노드를 기준으로 각 노드까지의 거리를 저장하는 최단거리 map 선언 (초기에는 첫 노드 자기자신의 거리는 0으로 세팅하고, 나머지는 무한대로 우선 표현)
 * 3-2. 우선순위큐를 선언하여 (첫 노드, 0) 을 넣는다.
 * 3-3. 우선순위큐에서 노드를 순서대로 꺼내며, 인접한 노드들 각각에 대하여 거리를 구하고, 각각의 거리에 처음 꺼낸노드의 거리를 더한다.
 * 3-4. 최단거리 map 에 저장되어 있는 거리와 각각 구한 거리와 비교하여 더 새로 구한거리가 더 짧을 경우 최단거리 map 에 업데이트한다.
 * 3-5. 최단거리 map 에 업데이트가 발생한 경우, 해당 노드와 거리를 우선순위큐에도 넣는다.
 * 3-6. 이 과정을 반복하며 각 노드의 인접한 노드들을 모두 방문하고, 만약 최단거리 map 에 기록된 각 노드의 거리들보다 더 긴 노드일 경우 계산을 하지않고 건너뛴다.
 */

import java.util.*;

public class DijkstraAlgorithm {
    Map<String, List<Edge>> graph = new HashMap<>();

    public DijkstraAlgorithm() {
        graph.put("A", new ArrayList<>(Arrays.asList(new Edge("B", 8), new Edge("C", 1), new Edge("D", 2))));
        graph.put("B", new ArrayList<>());
        graph.put("C", new ArrayList<>(Arrays.asList(new Edge("B", 5), new Edge("D", 2))));
        graph.put("D", new ArrayList<>(Arrays.asList(new Edge("E", 3), new Edge("F", 5))));
        graph.put("E", new ArrayList<>(Arrays.asList(new Edge("F", 1))));
        graph.put("F", new ArrayList<>(Arrays.asList(new Edge("A", 5))));
    }

    public class Edge implements Comparable<Edge> {
        private String vertex;
        private int distance;

        public Edge(String vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "vertex : " + vertex + " distance : " + distance;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.distance - edge.distance;
        }
    }

    public Map<String, Integer> DijkstraFunction(String start) {
        Map<String, Integer> shortestDistances = new HashMap<>();
        Edge currentNode;
        String currentVertex, adjacentVertex;
        int currentDistance, adjacentDistance, totalDistance;

        for (String vertex : graph.keySet()) {
            int distance = 0;
            if (!vertex.equals(start)) distance = Integer.MAX_VALUE;
            shortestDistances.put(vertex, distance);
        }

        Queue<Edge> needVisit = new PriorityQueue<>();
        needVisit.add(new Edge(start, 0));

        while (needVisit.size() > 0) {
            currentNode = needVisit.poll();
            currentVertex = currentNode.vertex;
            currentDistance = currentNode.distance;

            if (shortestDistances.get(currentVertex) < currentDistance) continue;

            for (Edge adjacentEdge : graph.get(currentVertex)) {
                adjacentVertex = adjacentEdge.vertex;
                adjacentDistance = adjacentEdge.distance;
                totalDistance = currentDistance + adjacentDistance;

                if (shortestDistances.get(adjacentVertex) > totalDistance) {
                    shortestDistances.put(adjacentVertex, totalDistance);
                    needVisit.add(new Edge(adjacentVertex, totalDistance));
                }

            }

        }

        return shortestDistances;

    }

}
