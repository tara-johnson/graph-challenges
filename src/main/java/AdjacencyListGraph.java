import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AdjacencyListGraph<E> implements Graph<E> {
    public AdjacencyListGraph() {
    }

    public Set<Node<E>> getNodes() {
        return null;
    }

    public Set<Edge<E>> getEdges() {
        return null;
    }

    @Override
    public void addNode(Node<E> node) {
    }

    @Override
    public void addEdge(Node<E> start, Node<E> end) {
    }

    @Override
    public void addEdge(Node<E> start, Node<E> end, int cost) {
    }

    @Override
    public void addTwoWayEdge(Node<E> start, Node<E> end) {
    }

    @Override
    public void addTwoWayEdge(Node<E> start, Node<E> end, int cost) {
    }

    @Override
    public Set<Node<E>> getNeighbors(Node<E> node) {
        return null;
    }

    @Override
    public boolean isConnected(Node<E> start, Node<E> end) {
        return false;
    }

    @Override
    public Edge<E> getEdge(Node<E> start, Node<E> end) {
        return null;
    }

    private void checkNodesExists(Node<E> node1, Node<E> node2) {
    }

    // leverage method overloading and use plural naming even for the single node check
    // because it's way easier to write the same method name everywhere than to remember to
    // write either "node" vs "nodes" in "checkNodeExists" or "checkNodesExists"
    private void checkNodesExists(Node<E> node) {
    }
}
