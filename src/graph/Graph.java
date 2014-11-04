package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph<T> {
    Map<Node<T>, List<Node<T>>> adjlist = new HashMap<>();
    int m, n;

    public static <T> void BFS(Graph<T> graph, Node<T> node) {
        Queue<Node<T>> notVisited = new LinkedList<>();
        Queue<Node<T>> resultNode = new LinkedList<>();
        Map<Node<T>, Boolean> visited = new HashMap<>();
        Set<Node<T>> keys = graph.adjlist.keySet();

        for (Node<T> node2 : keys) {
            visited.put(node2, false);
        }

        notVisited.add(node);
        visited.put(node, true);
        while (!notVisited.isEmpty()) {
            Node<T> visit = notVisited.poll();
            resultNode.add(visit);
            Iterator<Node<T>> it = graph.adjlist.get(visit).iterator();
            while (it.hasNext()) {
                Node<T> tmp = it.next();
                if (!visited.get(tmp)) {
                    notVisited.add(tmp);
                    visited.put(tmp, true);
                }
            }
        }

        while (!resultNode.isEmpty()) {
            System.out.println(resultNode.poll());
        }
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        Node<Integer> n1 = new Node<>(1);

        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);
        Node<Integer> n6 = new Node<>(6);
        Node<Integer> n7 = new Node<>(7);
        Node<Integer> n8 = new Node<>(8);

        List<Node<Integer>> n1list = new ArrayList<>();
        n1list.add(n2);
        n1list.add(n3);
        n1list.add(n4);

        List<Node<Integer>> n2list = new ArrayList<>();
        n2list.add(n5);
        n2list.add(n6);
        n2list.add(n1);


        List<Node<Integer>> n3list = new ArrayList<>();
        n3list.add(n5);
        n3list.add(n1);

        List<Node<Integer>> n4list = new ArrayList<>();
        n4list.add(n6);
        n4list.add(n1);

        List<Node<Integer>> n5list = new ArrayList<>();
        n5list.add(n2);
        n5list.add(n3);
        n5list.add(n7);
        n5list.add(n8);

        List<Node<Integer>> n6list = new ArrayList<>();
        n6list.add(n2);
        n6list.add(n4);
        n6list.add(n7);
        n6list.add(n8);

        List<Node<Integer>> n7list = new ArrayList<>();
        n7list.add(n5);
        n7list.add(n6);
        n7list.add(n8);

        List<Node<Integer>> n8list = new ArrayList<>();
        n8list.add(n5);
        n8list.add(n6);
        n8list.add(n7);

        graph.adjlist.put(n1, n1list);
        graph.adjlist.put(n2, n2list);
        graph.adjlist.put(n3, n3list);
        graph.adjlist.put(n4, n4list);
        graph.adjlist.put(n5, n5list);
        graph.adjlist.put(n6, n6list);
        graph.adjlist.put(n7, n7list);
        graph.adjlist.put(n8, n8list);

        BFS(graph, n1);
    }
}
