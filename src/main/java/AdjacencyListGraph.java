import java.net.Inet4Address;
import java.util.*;

public class AdjacencyListGraph<E> implements Graph<E> {
    // Give the map a node (a key) and get back the list of nodes (values) that it points to
    Map<Node<E>, Set<Node<E>>> adjacencyList;

    // Give the map a node, which returns a map of other nodes, and each one of those nodes has a cost
    Map<Node<E>, Map<Node<E>, Edge>> costs;

    Set<Edge<E>> edges;


    public AdjacencyListGraph() {
        adjacencyList = new HashMap<>();
        costs = new HashMap<>();
        edges = new HashSet<>();
    }

    @Override
    public void addNode(Node<E> node) {
        adjacencyList.put(node, new HashSet<>());
        costs.put(node, new HashMap<>());
    }

    public Set<Node<E>> getNodes() {
        // Returns all the keys in the map
        return adjacencyList.keySet();
    }

    public Set<Edge<E>> getEdges() {
        return edges;
    }

    @Override
    public void addEdge(Node<E> start, Node<E> end) {
        checkNodesExists(start, end);
        addEdge(start, end, 0);
    }

    @Override
    public void addEdge(Node<E> start, Node<E> end, int cost) {
        checkNodesExists(start, end);

        addEdge(start, end);

        Map<Node<E>, Edge> options = costs.get(start);
        Edge edge = new Edge(start, end, cost);
        options.put(end, edge);
        edges.add(edge);
    }

    @Override
    public void addTwoWayEdge(Node<E> start, Node<E> end) {
        checkNodesExists(start, end);
        addTwoWayEdge(start, end, 0);
    }

    @Override
    public void addTwoWayEdge(Node<E> start, Node<E> end, int cost) {
        checkNodesExists(start, end);
        addEdge(start, end, cost);
        addEdge(end, start, cost);
    }

    @Override
    public Set<Node<E>> getNeighbors(Node<E> node) {
        checkNodesExists(node);
        return adjacencyList.get(node);
    }

    @Override
    public boolean isConnected(Node<E> start, Node<E> end) {
        checkNodesExists(start, end);
        return adjacencyList.get(start).contains(end);
    }

    @Override
    public Edge<E> getEdge(Node<E> start, Node<E> end) {
        checkNodesExists(start, end);
        return costs.get(start).get(end);
    }

    private void checkNodesExists(Node<E> node1, Node<E> node2) {
        checkNodesExists(node1);
        checkNodesExists(node2);
    }

    // leverage method overloading and use plural naming even for the single node check
    // because it's way easier to write the same method name everywhere than to remember to
    // write either "node" vs "nodes" in "checkNodeExists" or "checkNodesExists"
    private void checkNodesExists(Node<E> node) {
        if (!adjacencyList.containsKey(node)) {
            String message = "Attempt to access node that's not in the graph. Node: " + node;
            throw new IllegalArgumentException(message);
        }
    }
}
